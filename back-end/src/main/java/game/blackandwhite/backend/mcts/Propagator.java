package game.blackandwhite.backend.mcts;

interface Propagator {
    void backPropagate(Node selected, float goodness);
}
