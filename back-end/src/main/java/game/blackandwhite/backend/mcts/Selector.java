package game.blackandwhite.backend.mcts;

interface Selector {
    Node select(Node root);
}
