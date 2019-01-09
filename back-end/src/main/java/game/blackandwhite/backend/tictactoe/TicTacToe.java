package game.blackandwhite.backend.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.State;

public class TicTacToe implements Game {
    private static Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    State currentState;

    public TicTacToe() {
        currentState = new T3State();
    }

    @Override
    public State getState() {
        return currentState;
    }

    @Override
    public void playMove(Move move) {
        logger.info("play move {}", move);
        currentState = move.duplicateStateAndApply();
        logger.info("play move {} done");
    }

    public String toString() {
        return currentState.toString();
    }
}
