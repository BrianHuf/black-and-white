package game.blackandwhite.backend.mcts;

import java.util.List;

import game.blackandwhite.backend.core.AI;
import game.blackandwhite.backend.core.Move;

public class Mcts implements AI {
    private Coordinator coordinator;
    private Selector selector;
    private Expander expander;
    private Simulator simulator;
    private Propagator propagator;

    private Node root;

    public Mcts(long numFixedIterations) {
        this(new FixedIterations(numFixedIterations), new StandardSelection(), new StandardExpansion(),
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
        root = new Node(fromMove);
        coordinator.doRounds(this);
        return selectByMostVisits(root.getChildren()).getMove();
    }

    private Node selectByMostVisits(List<Node> list) {
        int maxVisits = 0;
        Node maxNode = null;
        for (Node check : list) {
            if (check.getVisits() > maxVisits) {
                maxNode = check;
                maxVisits = check.getVisits();
            }
        }
        
        return maxNode;
    }

    void doOneRound() {
        Node selected = selector.select(root);
        Node simulateThis = expander.expand(selected);
        float goodness = simulator.playout(simulateThis);
        propagator.backPropagate(simulateThis, goodness);
    }

    public String toString() {
        if (root == null) {
            return "MCTS not initialized";
        }

        return String.format("Root = %s, Best = %s", root.toString(), selectByMostVisits(root.getChildren()));
    }
}
