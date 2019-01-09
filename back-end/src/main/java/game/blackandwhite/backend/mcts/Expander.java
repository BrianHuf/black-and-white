package game.blackandwhite.backend.mcts;

interface Expander {
    Node expand(Node selected);
}
