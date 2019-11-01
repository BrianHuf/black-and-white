package game.blackandwhite.backend.rest;

import java.util.List;
import java.util.stream.Collectors;

import game.blackandwhite.backend.core.Node;

public class NodeState {
    private final Node node;

    private final int toDepth;

    public NodeState(Node node, int toDepth) {
        int delta = 0;
        for (Node check = node; check != null; check = check.getParent()) {
            delta++;
        }

        this.node = node;
        this.toDepth = toDepth + delta;
    }

    public String getMove() {
        return node.getMove().getBoard();
    }

    public List<NodeState> getChildren() {
        return node.getChildren(toDepth).stream().map(this::createChild).collect(Collectors.toList());
    }

    private NodeState createChild(Node n) {
        return new NodeState(n, toDepth);
    }

    public int getVisits() {
        return node.getVisits();
    }

    public float getGoodness() {
        return getVisits() > 0 ? 100.f * node.getGoodness() / (float)node.getVisits() : 0.0f;
    }
}