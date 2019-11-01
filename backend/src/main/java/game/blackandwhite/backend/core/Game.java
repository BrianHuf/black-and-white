package game.blackandwhite.backend.core;

public interface Game {
    Move getLastMove();

    Game playMove(Move move);

    String getPlayedMoves();
}
