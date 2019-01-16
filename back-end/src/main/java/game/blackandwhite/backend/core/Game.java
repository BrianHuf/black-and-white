package game.blackandwhite.backend.core;

public interface Game {
    Move getLastMove();
    void playMove(Move move);
}
