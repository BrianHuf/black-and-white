package game.blackandwhite.backend.mcts;

interface Simulator {
    float playout(Node node);
}
