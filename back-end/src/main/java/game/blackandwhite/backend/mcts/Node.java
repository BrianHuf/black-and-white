package game.blackandwhite.backend.mcts;

import game.blackandwhite.backend.core.Move;

import java.util.ArrayList;
import java.util.List;

class Node {
    private final Node parent;
    private final List<Node> children = new ArrayList<>();
    private final Move move;
    private int visits = 0;
    private float goodness = 0;

    public Node(Move startingMove) {
        parent = null;
        move = null;

        for (Move move : startingMove.getNextMoves()) {
            addNode(move);
        }
    }

    private Node(Node parent, Move move) {
        parent.children.add(this);
        this.parent = parent;
        this.move = move;
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

    public Node addNode(Move move) {
        return new Node(this, move);
    }

    @Override
    public String toString() {
        return String.format("Stats=%s, Move=%s", getStatusString(), move == null ? "root" : move.toString());
    }

    private String getStatusString() {
        return String.format("%4.3f/%d", goodness / visits, visits);
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
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
        for (Node child : children) {
            sum += (float) child.getVisits();
        }
        return sum;
    }

    public void addGoodness(float goodness) {
        this.goodness += goodness;
        this.visits++;
    }

    public boolean isRoot() {
        return parent == null;
    }
}
