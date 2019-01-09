package game.blackandwhite.backend.tictactoe;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Moves;
import game.blackandwhite.backend.core.State;
import game.blackandwhite.backend.square.Board2d;
import game.blackandwhite.backend.square.Square;

import java.util.HashMap;
import java.util.Map;

public class T3State implements State {
    final static Map<Character, T3Piece> CHAR_TO_PIECE = new HashMap<>();
    final T3Move creatingMove;
    final Board2d<T3Piece> board;
    final Moves appliedMoves = new Moves();
    T3Player currentPlayer;
    EndGameState endGameState = EndGameState.UNKNOWN;

    {
        CHAR_TO_PIECE.put(T3Piece.P1.getChar(), T3Piece.P1);
        CHAR_TO_PIECE.put(T3Piece.P2.getChar(), T3Piece.P2);
    }

    T3State() {
        creatingMove = null;
        board = new Board2d<>(3, 3);
        currentPlayer = T3Player.P1;
    }

    T3State(String boardStr) {
        creatingMove = null;
        board = new Board2d<>(3, 3);

        int count = board.set(boardStr, CHAR_TO_PIECE);
        currentPlayer = count % 2 == 0 ? T3Player.P1 : T3Player.P2;
    }

    T3State(T3State copyFrom, T3Move move) {
        creatingMove = move;
        board = new Board2d<T3Piece>(copyFrom.board);
        currentPlayer = copyFrom.currentPlayer.next();
        apply(move);
    }

    @Override
    public boolean isActive() {
        getWinner();
        return EndGameState.UNKNOWN.equals(endGameState);
    }

    @Override
    public T3Player getWinner() {
        if (endGameState == EndGameState.UNKNOWN) {
            T3Player winner = calculateWinner();
            if (T3Player.P1.equals(winner)) {
                endGameState = EndGameState.P1;
            } else if (T3Player.P2.equals(winner)) {
                endGameState = EndGameState.P2;
            } else if (board.getPlayedPieces() == 9) {
                endGameState = EndGameState.TIE;
            }
            return winner;
        } else if (EndGameState.TIE.equals(endGameState)) {
            return null;
        } else if (endGameState == EndGameState.P1) {
            return T3Player.P1;
        } else if (endGameState == EndGameState.P2) {
            return T3Player.P2;
        } else {
            throw new IllegalStateException();
        }
    }

    private T3Player calculateWinner() {
        T3Player lastMoved = currentPlayer.next();
        T3Piece checkFor = lastMoved.getPiece();
        T3Piece p1 = board.get(0, 0);
        if (checkFor.equals(p1)) {
            if (p1.equals(board.get(0, 1)) && p1.equals(board.get(0, 2))
                    || p1.equals(board.get(1, 0)) && p1.equals(board.get(2, 0))
                    || p1.equals(board.get(1, 1)) && p1.equals(board.get(2, 2))) {
                return lastMoved;
            }
        }

        T3Piece p2 = board.get(1, 0);
        if (checkFor.equals(p2)) {
            if (p2.equals(board.get(1, 1)) && p2.equals(board.get(1, 2))) {
                return lastMoved;
            }
        }

        T3Piece p3 = board.get(0, 1);
        if (checkFor.equals(p3)) {
            if (p3.equals(board.get(1, 1)) && p3.equals(board.get(2, 1))) {
                return lastMoved;
            }
        }

        T3Piece p4 = board.get(2, 0);
        if (checkFor.equals(p4)) {
            if (p4.equals(board.get(2, 1)) && p4.equals(board.get(2, 2))
                    || p4.equals(board.get(1, 1)) && p4.equals(board.get(0, 2))) {
                return lastMoved;
            }
        }

        T3Piece p5 = board.get(0, 2);
        if (checkFor.equals(p5)) {
            if (p5.equals(board.get(1, 2)) && p5.equals(board.get(2, 2))) {
                return lastMoved;
            }
        }

        return null;
    }

    @Override
    public T3Player getPlayersTurn() {
        return currentPlayer;
    }

    @Override
    public Move getCreatingMove() {
        return creatingMove;
    }

    @Override
    public Moves getAvailableMoves() {
        Moves ret = new Moves();
        if (isActive()) {
            for (Square<T3Piece> square : board.toList()) {
                if (square.isEmpty()) {
                    ret.add(new T3Move(this, square));
                }
            }
        }

        return ret;
    }

    @Override
    public Moves getAppliedMoves() {
        return appliedMoves;
    }

    @Override
    public String toText() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                sb.append(board.toString(x, y, " "));
                if (y < 2) {
                    sb.append("|");
                }
            }
            sb.append("\n");

            if (x < 2) {
                sb.append("-----\n");
            }

        }
        return sb.toString();
    }

    @Override
    public String toJson() {
        return null;
    }

    T3State duplicateAndApply(T3Move move) {
        T3State newState = new T3State(this, move);
        move.setAppliedToState(newState);
        appliedMoves.add(move);
        return newState;
    }

    void apply(T3Move move) {
        endGameState = EndGameState.UNKNOWN;
        board.set(move.getSquare(), move.getPiece());
    }

    public String toString() {
        return board.toString();
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer.next();
    }

    enum EndGameState {
        UNKNOWN, IN_PLAY, TIE, P1, P2
    }

}
