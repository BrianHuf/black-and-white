package game.blackandwhite.backend.core;

public interface Game {
    State getState();

    void playMove(Move move);
}
