package game.blackandwhite.backend.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Status;

public class TicTacToeState {
    private static final char[] PIECES = new char[] { '_', 'X', 'O' };
    private final int[] board;
    private final TicTacToeMove move;

    Status status;
    Move[] nextMoves;

    TicTacToeState(TicTacToeMove move) {
        this.move = move;

        if (move.isBeginGame()) {
            board = new int[9];
        } else {
            board = Arrays.copyOf(move.getPreviousT3Move().getState().board, 9);
            board[move.getCell()] = move.getPlayer().getIndex();
        }
    }

    public Status getStatus() {
        if (status == null) {
            status = calcStatus();
        }

        return status;
    }

    private Status calcStatus() {
        int lookFor = move.getPlayer().getIndex();
        if (check(lookFor, 0) && (check(lookFor, 1, 2) || check(lookFor, 3, 6) || check(lookFor, 4, 8))) {
            return Status.WINNER;
        }

        if (check(lookFor, 2) && (check(lookFor, 5, 8) || check(lookFor, 4, 6))) {
            return Status.WINNER;
        }

        if (check(lookFor, 4) && (check(lookFor, 1, 4) || check(lookFor, 3, 5))) {
            return Status.WINNER;
        }

        if (check(lookFor, 6, 7, 8)) {
            return Status.WINNER;
        }

        if (move.getMoveNumber() == 9) {
            return Status.TIE;
        }

        return Status.IN_PROGRESS;
    }

    private boolean check(int lookFor, int index) {
        return lookFor == board[index];
    }

    private boolean check(int lookFor, int index1, int index2) {
        return lookFor == board[index1] && lookFor == board[index2];
    }

    private boolean check(int lookFor, int index1, int index2, int index3) {
        return lookFor == board[index1] && lookFor == board[index2] && lookFor == board[index3];
    }

    synchronized public Move[] getNextMoves() {
        if (nextMoves == null) {
            nextMoves = calcNextMoves();
        }

        return nextMoves;
    }

    public Move[] calcNextMoves() {
        List<Move> moves = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            checkToAddMove(moves, i);
        }

        return moves.toArray(new Move[moves.size()]);
    }

    private void checkToAddMove(List<Move> moves, int i) {
        if (board[i] == 0) {
            moves.add(new TicTacToeMove(move, i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int cell : board) {
            sb.append(PIECES[cell]);
        }

        return sb.toString();
    }
}
