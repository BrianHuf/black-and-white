package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.blackandwhite.backend.core.Moves;

public class TicTacToeTester {
    private static Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    @Test
    public void constructor_begin_successful() {
        logger.info("TEST");
        TicTacToe sut = new TicTacToe();
        assertEquals("_________", sut.toString());
    }

    @Test
    public void constructor_midPlay_successful() {
        TicTacToe sut = new TicTacToe("012345");
        assertEquals("O5 -- XOXOXO___", sut.toString());

        Moves moves = sut.lastMove.getNextMoves();
        assertEquals(3, moves.size());
    }

    @Test
    public void getStatus_midPlay_successful() {
        TicTacToe sut = new TicTacToe("012345");
        assertEquals("O5 -- XOXOXO___", sut.toString());

        Moves moves = sut.lastMove.getNextMoves();
        assertEquals(3, moves.size());
    }
}
