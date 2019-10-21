package game.blackandwhite.backend.mcts;

interface Expander {
    MctsNode expand(MctsNode selected);
}
