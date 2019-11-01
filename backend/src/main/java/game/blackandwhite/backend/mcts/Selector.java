package game.blackandwhite.backend.mcts;

interface Selector {
    MctsNode select(MctsNode root);
}
