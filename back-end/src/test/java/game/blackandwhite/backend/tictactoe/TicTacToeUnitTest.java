package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.blackandwhite.backend.core.PlayerLogicMcts;
import game.blackandwhite.backend.core.PlayerLogicRandom;
import game.blackandwhite.backend.core.SelfPlay;

public class TicTacToeUnitTest {
    private static Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    @Test
    public void playFourMoves_typical_successful() {
        TicTacToe testThis = new TicTacToe();

        SelfPlay play = new SelfPlay(testThis);
        play.addPlayerLogic(new PlayerLogicRandom()).setNumberOfMoves(4).go();

        assertEquals(5, testThis.getState().getAvailableMoves().size());
    }

    @Test
    public void playOut_random_successful() {
        TicTacToe testThis = new TicTacToe();
        SelfPlay play = new SelfPlay(testThis);

        play.addPlayerLogic(new PlayerLogicRandom()).go();

        assertEquals(0, testThis.getState().getAvailableMoves().size());
        logger.info(play.getStatus());
    }

    @Test
    public void playOut_mcts_successful() {
        TicTacToe testThis = new TicTacToe();
        SelfPlay play = new SelfPlay(testThis);

        play.addPlayerLogic(new PlayerLogicMcts(1000)).go();

        assertEquals(0, testThis.getState().getAvailableMoves().size());
        logger.info(play.getStatus());
    }
}
