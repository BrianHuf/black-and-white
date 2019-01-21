package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import game.blackandwhite.backend.core.Move;

public class TicTacToeTester {
    private static Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    @Test
    public void constructor_begin_successful() {
        logger.info("TEST");
        TicTacToe sut = new TicTacToe();
        assertEquals("_________", sut.getLastMove().getBoard());
    }

    @Test
    public void constructor_midPlay_successful() {
        TicTacToe sut = new TicTacToe("012345");
        assertEquals("O5 -- XOXOXO___", sut.getLastMove().toString());

        Move[] moves = sut.lastMove.getNextMoves();
        assertEquals(3, moves.length);
    }

    @Test
    public void getStatus_midPlay_successful() {
        TicTacToe sut = new TicTacToe("012345");
        assertEquals("O5 -- XOXOXO___", sut.getLastMove().toString());

        Move[] moves = sut.lastMove.getNextMoves();
        assertEquals(3, moves.length);
    }
}
