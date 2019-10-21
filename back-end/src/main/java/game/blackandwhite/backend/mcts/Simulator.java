package game.blackandwhite.backend.mcts;

interface Simulator {
    float playout(MctsNode node);
}
