package game.blackandwhite.backend.mcts;

interface Propagator {
    void backPropagate(MctsNode selected, float goodness);
}
