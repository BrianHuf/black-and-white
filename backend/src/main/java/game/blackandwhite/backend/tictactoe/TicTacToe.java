package game.blackandwhite.backend.tictactoe;

import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.core.Move;

public class TicTacToe implements Game {
    TicTacToeMove lastMove;

    public TicTacToe(String moves) {
        this();
        playMoves(moves);
    }

    public TicTacToe() {
        lastMove = new TicTacToeMove();
    }

    private void playMoves(String moves) {
        for (byte moveChar : moves.getBytes()) {
            int cell = moveChar - 48;
            if (cell < 0 || cell > 8) {
                throw new IllegalStateException("bad moves char " + moveChar + " " + moves);
            }
            playMoveChar(moveChar - 48);
        }
    }

    private void playMoveChar(int cell) {
        lastMove = new TicTacToeMove(lastMove, cell);
    }

    @Override
    public Game playMove(Move move) {
        if (!(move instanceof TicTacToeMove)) {
            throw new IllegalArgumentException("Expecting only a TicTacToeMove");
        }

        lastMove = (TicTacToeMove) move;
        return this;
    }

    @Override
    public Move getLastMove() {
        return lastMove;
    }

    public TicTacToeMove getLastTicTacToeMove() {
        return lastMove;
    }

    @Override
    public String getPlayedMoves() {
        StringBuilder sb = new StringBuilder();
        TicTacToeMove current = lastMove;
        while (current.getPreviousMove().isPresent()) {
            sb.insert(0, Integer.toString(current.getCell()));
            current = current.getPreviousT3Move();
        }
        return sb.toString();
    }

    public String toString() {
        return getLastMove().toString();
    }
}
