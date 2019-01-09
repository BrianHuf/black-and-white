package game.blackandwhite.backend.mcts;

class StandardPropagation implements Propagator {
    @Override
    public void backPropagate(Node node, float goodness) {
        for (Node current = node; current != null; current = current.getParent()) {
            if (current.isRoot()) {
                goodness = 1.0f - goodness;
            }
            current.addGoodness(goodness);
            goodness = 1.0f - goodness;
        }

    }
}
