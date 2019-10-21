package game.blackandwhite.backend.rest;

import java.util.List;
import java.util.stream.Collectors;

import game.blackandwhite.backend.core.Node;

public class NodeState {
    private final Node node;

    private final int toDepth;

    public NodeState(Node node, int toDepth) {
        this.node = node;
        this.toDepth = toDepth;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NodeState other = (NodeState) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }

}