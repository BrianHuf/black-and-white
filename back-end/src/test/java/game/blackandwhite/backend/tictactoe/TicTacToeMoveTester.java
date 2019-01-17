package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import game.blackandwhite.backend.core.Status;

public class TicTacToeMoveTester {
    @Test
    public void constructor() {
        TicTacToeMove m1 = new TicTacToeMove();
        assertTrue(m1.isBeginGame());

        TicTacToeMove m2 = new TicTacToeMove(m1, 0);
        assertFalse(m2.isBeginGame());
    }

    @Test
    public void getStatus_inProgress() {
        TicTacToe game = new TicTacToe("012345");        
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.IN_PROGRESS, move.getStatus());
    }

    @Test
    public void getStatus_tied() {
        TicTacToe game = new TicTacToe("021354687");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.TIE, move.getStatus());
    }
    
    @Test
    public void getStatus_winnerX() {
        TicTacToe game = new TicTacToe("03142");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.WINNER, move.getStatus());
        assertEquals(1, move.getPlayer().getIndex());
    }
    
    @Test
    public void getStatus_winnerY() {
        TicTacToe game = new TicTacToe("803142");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.WINNER, move.getStatus());
        assertEquals(2, move.getPlayer().getIndex());
    }
}
