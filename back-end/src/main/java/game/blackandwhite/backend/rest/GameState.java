package game.blackandwhite.backend.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.core.Move;

public class GameState {
    private final String board;
    private final String status;
    private final String lastMove;
    private final List<String> nextMoves;

    public GameState(Game game) {
        this.board = game.getLastMove().getBoard();
        this.status = game.getLastMove().getStatus().toString();
        this.lastMove = game.getLastMove().getMoveString();
        this.nextMoves = new ArrayList<>();

        for (Move move : game.getLastMove().getNextMoves()) {
            nextMoves.add(move.toString());
        }
    }

    public String getState() {
        return board;
    }

    public String getStatus() {
        return status;
    }

    public String getLastMove() {
        return lastMove;
    }

    public List<String> getNextMoves() {
        return Collections.unmodifiableList(nextMoves);
    }
}