package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void getStatusInProgress() {
        final String[] inProgress = { "42051" };

        for (String gameStr : inProgress) {
            TicTacToe game = new TicTacToe(gameStr);
            TicTacToeMove move = game.getLastTicTacToeMove();
            assertEquals("Game still in progress " + gameStr, Status.IN_PROGRESS, move.getStatus());
        }
    }

    @Test
    public void getStatus_winnerX() {
        final String[] winnerX = { "03142", "30415", "60718", "01346", "12457", "21538", "01468", "21456" };

        for (String gameStr : winnerX) {
            TicTacToe game = new TicTacToe(gameStr);
            TicTacToeMove move = game.getLastTicTacToeMove();
            assertEquals("Last move win game " + gameStr, Status.WINNER, move.getStatus());
            assertEquals("X should be the winning player", 1, move.getPlayer().getIndex());
        }
    }

    @Test
    public void getStatus_winnerY() {
        final String[] winnerX = { "803142", "830415", "360718", "801346", "812457", "721538", "701468", "821456" };

        for (String gameStr : winnerX) {
            TicTacToe game = new TicTacToe(gameStr);
            TicTacToeMove move = game.getLastTicTacToeMove();
            assertEquals("Last move win game " + gameStr, Status.WINNER, move.getStatus());
            assertEquals("Y should be the winning player", 2, move.getPlayer().getIndex());
        }
    }
}
