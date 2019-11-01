package game.blackandwhite.backend.mcts;

import java.util.Collection;

import game.blackandwhite.backend.core.AI;
import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Node;

public class Mcts implements AI {
    private Coordinator coordinator;
    private Selector selector;
    private Expander expander;
    private Simulator simulator;
    private Propagator propagator;

    private MctsNode root;

    public Mcts(long numFixedIterations) {
        this(new FixedConcurrentIterations(numFixedIterations), new StandardSelection(), new StandardExpansion(),
                new StandardSimulator(), new StandardPropagation());
    }

    public Mcts(Coordinator coordinator, Selector selector, Expander expander, Simulator simulator,
            Propagator propagator) {
        this.coordinator = coordinator;
        this.selector = selector;
        this.expander = expander;
        this.simulator = simulator;
        this.propagator = propagator;
    }

    @Override
    public Move findBestMove(Move fromMove) {
        root = new MctsNode(fromMove);
        coordinator.doRounds(this);
        return selectByMostVisits(root.getMctsChildren()).getMove();
    }

    @Override
    public Node getRootNode() {
        return root;
    }

    private MctsNode selectByMostVisits(Collection<MctsNode> list) {
        int maxVisits = 0;
        MctsNode maxNode = null;
        for (MctsNode check : list) {
            if (check.getVisits() > maxVisits) {
                maxNode = check;
                maxVisits = check.getVisits();
            }
        }

        return maxNode;
    }

    void doOneRound() {
        MctsNode selected = selector.select(root);
        MctsNode simulateThis = expander.expand(selected);
        float goodness = simulator.playout(simulateThis);
        propagator.backPropagate(simulateThis, goodness);
    }

    public String toString() {
        if (root == null) {
            return "MCTS not initialized";
        }

        return String.format("Root = %s, Best = %s", root.toString(), selectByMostVisits(root.getMctsChildren()));
    }
}
