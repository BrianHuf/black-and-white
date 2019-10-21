package game.blackandwhite.backend.core;

public interface AI {
    public Move findBestMove(Move lastMove);
    
    public Node getRootNode();
}
