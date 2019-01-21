package game.blackandwhite.backend.core;

import java.util.Optional;

public interface Move {
    Player getPlayer();

    Optional<Move> getPreviousMove();

    Move[] getNextMoves();

    Status getStatus();

    String getMoveString();

    String getBoard();
}
