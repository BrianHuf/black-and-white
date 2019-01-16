package game.blackandwhite.backend.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import game.blackandwhite.backend.core.Status;

public class TicTacToeMoveTester {
    @Test
    public void constructor_begin_successful() {
        TicTacToeMove m1 = new TicTacToeMove();
        TicTacToeMove m2 = new TicTacToeMove(m1, 0);
    }

    @Test
    public void getStatus_inProgress_successful() {
        TicTacToe game = new TicTacToe("012345");        
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.IN_PROGRESS, move.getStatus());
    }

    @Test
    public void getStatus_tied_successful() {
        TicTacToe game = new TicTacToe("021354687");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.TIE, move.getStatus());
    }
    
    @Test
    public void getStatus_winnerX_successful() {
        TicTacToe game = new TicTacToe("03142");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.WINNER, move.getStatus());
        assertEquals(1, move.getPlayer());
    }
    
    @Test
    public void getStatus_winnerY_successful() {
        TicTacToe game = new TicTacToe("803142");
        TicTacToeMove move = game.getLastTicTacToeMove();
        assertEquals(Status.WINNER, move.getStatus());
        assertEquals(2, move.getPlayer());
    }
}
