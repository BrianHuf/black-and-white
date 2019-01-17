package game.blackandwhite.backend.mcts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.blackandwhite.backend.core.AI;
import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.tictactoe.TicTacToe;

public class MctsTester {
    @Test
    public void findBestMove_center() {
        TicTacToe sut = new TicTacToe();
        AI ai = new Mcts(10000);
        
        Move best1 = ai.findBestMove(sut.getLastMove());        
        assertEquals("Center is best" + best1.toString(), "X4 -- ____X____", best1.toString());
        
        Move best2 = ai.findBestMove(best1);
        assertTrue("Corner is best second move " + best2.toString(), isCornerO(best2.toString()));

        Move currentMove = best2;
        while(currentMove.getStatus().isInProgress()) {
            currentMove = ai.findBestMove(currentMove);
        }

        assertTrue("Thoughtful games end in tie " + currentMove.toString(), currentMove.getStatus().isTie());
    }

    private boolean isCornerO(String move) {
        return move.startsWith("O1") || move.startsWith("O3") || move.startsWith("O5") || move.startsWith("O7");
    }
}
