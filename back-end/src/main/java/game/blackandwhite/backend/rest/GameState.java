package game.blackandwhite.backend.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.core.Move;

public class GameState {
    private final String state;
    private final String status;
    private final String lastMove;
    private final List<String> availableMoves;
    private final String lastPlayer;
    private final String nextPlayer;

    public GameState(Game game) {
        Move move = game.getLastMove();
        this.state = move.getBoard();
        this.status = move.getStatus().toString();
        this.lastPlayer = move.getPlayer().toString();
        this.lastMove = move.getMoveString();

        this.availableMoves = new ArrayList<>();

        Move[] nextMoveObjs = move.getNextMoves();
        for (Move nextMove : nextMoveObjs) {
            availableMoves.add(nextMove.getMoveString());
        }

        if (availableMoves.isEmpty()) {
            nextPlayer = move.getPlayer().toString();
        } else {
            nextPlayer = nextMoveObjs[0].getPlayer().toString();
        }
    }

    public String getState() {
        return state;
    }

    public String getStatus() {
        return status;
    }

    public String getLastPlayer() {
        return lastPlayer;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    public String getLastMove() {
        return lastMove;
    }

    public List<String> getAvailableMoves() {
        return Collections.unmodifiableList(availableMoves);
    }
}