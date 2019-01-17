package game.blackandwhite.backend.mcts;

import game.blackandwhite.backend.core.Player;

class StandardPropagation implements Propagator {
    @Override
    public void backPropagate(Node node, float goodness) {
        Player startingPlayer = node.getMove().getPlayer();
        for (Node current = node; current != null; current = current.getParent()) {
            Player currentPlayer = current.getMove().getPlayer();
            float currentGoodness = current.isRoot() || currentPlayer.equals(startingPlayer) ? goodness : -goodness;
            current.addGoodness(currentGoodness);
        }
    }
}
