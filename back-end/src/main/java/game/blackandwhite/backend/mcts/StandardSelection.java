package game.blackandwhite.backend.mcts;

import static game.blackandwhite.backend.mcts.WeightedRandomSelector.weightedSelect;

class StandardSelection implements Selector, WeightGetter<Node> {
    private static float C = (float) Math.sqrt(2);

    @Override
    public Node select(Node root) {
        Node current = root;
        while (current.hasChildren()) {
            current = pickChild(current);
        }
        return current;
    }

    private Node pickChild(Node current) {
        return weightedSelect(current.getChildren(), this);
    }

    @Override
    public float getWeight(Node node) {
        // FIXME +1.0f -- is this really correct?
        float wi = node.getGoodness();
        float ni = node.getVisits() + 1.0f;
        float Ni = node.getParent().getVisits() + 1.01f;
        float weight = wi / ni + C * (float) Math.log(Ni) / ni;
        return weight;
    }
}
