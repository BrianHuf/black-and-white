package game.blackandwhite.backend.core;

import game.blackandwhite.backend.mcts.Mcts;

public class PlayerLogicMcts implements PlayerLogic {
    private final Mcts mcts;

    public PlayerLogicMcts(long iterations) {
        mcts = new Mcts(iterations);
    }

    @Override
    public Move select(State state) {
        return mcts.findBest(state);
    }

    @Override
    public String toString() {
        return mcts.toString();
    }
}
