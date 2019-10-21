package game.blackandwhite.backend.mcts;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Node;

class MctsNode implements Node {
    private final MctsNode parent;
    private final List<MctsNode> children = new CopyOnWriteArrayList<>();
    private final Move move;
    private int visits = 0;
    private float goodness = 0;

    public MctsNode(Move startingMove) {
        parent = null;
        move = startingMove;

        for (Move move : startingMove.getNextMoves()) {
            addNode(move);
        }
    }

    private MctsNode(MctsNode parent, Move move) {
        this.parent = parent;
        this.move = move;
        parent.children.add(this);
    }

    public MctsNode getFirstLevel() {
        if (isRoot()) {
            throw new IllegalStateException("getFirstLevel() is called from root -- not allowed");
        }

        MctsNode current = this;
        while (!current.getParent().isRoot()) {
            current = current.getParent();
        }

        return current;
    }

    public Move getMove() {
        return move;
    }

    public void expand() {
        if (children.isEmpty()) {
            for (Move nextMove : move.getNextMoves()) {
                addNode(nextMove);
            }
        }
    }

    public MctsNode addNode(Move move) {
        return new MctsNode(this, move);
    }

    @Override
    public String toString() {
        return String.format("Stats=%s, Move=%s", getStatusString(), move == null ? "root" : move.toString());
    }

    private String getStatusString() {
        return String.format("%4.3f/%d", goodness / visits, visits);
    }

    public MctsNode getParent() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public List<Node> getChildren(int toDepth) {
        if (getDepth() > toDepth) {
            return Collections.emptyList();
        }
        if (children.contains(this)) {
            throw new IllegalStateException();
        }
        return (List<Node>) (List<?>) children;
    }

    private int getDepth() {
        int depth = 0;
        for (Node current = this; current != null; current = current.getParent()) {
            depth++;
        }
        return depth;
    }

    public List<MctsNode> getMctsChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public int getVisits() {
        return visits;
    }

    public float getGoodness() {
        return goodness;
    }

    public float sumChildVisits() {
        float sum = 0;
        for (MctsNode child : children) {
            sum += (float) child.getVisits();
        }
        return sum;
    }

    public synchronized void addGoodness(float goodness) {
        this.goodness += goodness;
        this.visits++;
    }

    public boolean isRoot() {
        return parent == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((move == null) ? 0 : move.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
        MctsNode other = (MctsNode) obj;
        if (move == null) {
            if (other.move != null)
                return false;
        } else if (!move.equals(other.move))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
    }
}
