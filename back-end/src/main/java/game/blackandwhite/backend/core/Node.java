package game.blackandwhite.backend.core;

import java.util.List;

public interface Node {

    public Move getMove();

    public Node getParent();

    public List<Node> getChildren(int toDepth);

    public float getGoodness();

    public int getVisits();
}
