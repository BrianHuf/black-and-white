package game.blackandwhite.backend.core;

import java.util.Optional;

public interface Move {
    Optional<Move> getPreviousMove();
    Moves getNextMoves();
    Status getStatus();
}
