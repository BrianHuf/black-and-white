package game.blackandwhite.backend.tictactoe;

import java.util.Optional;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Player;
import game.blackandwhite.backend.core.Status;

public class TicTacToeMove implements Move {
    private final TicTacToeMove previous;
    private final int cell;
    private final int moveNumber;
    private TicTacToeState state = null;

    TicTacToeMove() {
        this.previous = null;
        this.cell = -1;
        this.moveNumber = 0;
    }

    TicTacToeMove(TicTacToeMove previous, int cell) {
        this.previous = previous;
        this.cell = cell;
        this.moveNumber = previous.moveNumber + 1;
    }

    @Override
    public Player getPlayer() {
        if (isBeginGame()) {
            return Player.NOBODY;
        }

        return moveNumber % 2 == 1 ? Player.P1 : Player.P2;
    }

    @Override
    public Optional<Move> getPreviousMove() {
        if (previous != null) {
            return Optional.of(previous);
        }

        return Optional.empty();
    }

    @Override
    public String getMoveString() {
        return isBeginGame() ? "" : Integer.toString(cell);
    }

    @Override
    public Move[] getNextMoves() {
        return getState().getNextMoves();
    }

    @Override
    public Status getStatus() {
        if (moveNumber < 5) {
            return Status.IN_PROGRESS;
        }

        return getState().getStatus();
    }

    @Override
    public String getBoard() {
        return getState().toString();
    }

    TicTacToeMove getPreviousT3Move() {
        return previous;
    }

    int getCell() {
        return cell;
    }

    int getMoveNumber() {
        return this.moveNumber;
    }

    boolean isBeginGame() {
        return moveNumber == 0;
    }

    TicTacToeState getState() {
        if (state == null) {
            state = new TicTacToeState(this);
        }
        return state;
    }

    public String toString() {
        if (isBeginGame()) {
            return "Begin Game";
        } else {
            return String.format("%s%d -- %s", getPlayer(), cell, getBoard());
        }
    }
}
