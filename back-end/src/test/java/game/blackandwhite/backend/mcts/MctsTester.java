package game.blackandwhite.backend.mcts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.blackandwhite.backend.core.AI;
import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Status;
import game.blackandwhite.backend.tictactoe.TicTacToe;

import game.blackandwhite.backend.core.TestGame;

public class MctsTester {
    @Test
    public void testGame1() {
        TestGame game = new TestGame();
        Mcts mcts = new Mcts(1000);
        
        Move best1 = mcts.findBestMove(game.getLastMove());        
        assertEquals("Step 1 / Move 0", best1.toString());
    }

    @Test
    public void testGame2() {
        TestGame.getMoveStatus = move -> {
            if (move.moveNumber < 5) {
                return Status.IN_PROGRESS;
            }
        
            int[] moves = move.getAllMoveCells();
            return moves[0] == 0 && moves[1] != 0 ? Status.WINNER : Status.TIE;
        };

        TestGame game = new TestGame();
        
        Mcts mcts = new Mcts(10000);
        
        Move best1 = mcts.findBestMove(game.getLastMove());        
        assertEquals("Step 1 / Move 0", best1.toString());

        Move best2 = mcts.findBestMove(best1);        
        assertEquals("Step 2 / Move 0", best2.toString());

        game.playMove(best2);
        assertFinalTie(mcts, game);
    }

    @Test
    public void ticTacToe() {
        TicTacToe game = new TicTacToe();
        Mcts mcts = new Mcts(10000);
        
        Move best1 = mcts.findBestMove(game.getLastMove());        
        assertEquals("Center is best to start, but this was the selected " + best1.toString(), "X4 -- ____X____", best1.toString());
        
        Move best2 = mcts.findBestMove(best1);
        assertTrue("Corner is best second move, but this was the selected " + best2.toString(), isCornerO(best2.toString()));

        game.playMove(best2);
        //assertFinalTie(mcts, game);
    }

    @Test
    public void ticTacToeTakeWinning() {
        TicTacToe game = new TicTacToe("0314");
        Mcts mcts = new Mcts(100);
        
        Move best1 = mcts.findBestMove(game.getLastMove());        
        assertEquals("Take a winning move is best, but something else was selected " + best1.toString(), "X2 -- XXXOO____", best1.toString());
    }

    @Test
    public void ticTacToeBlockWinning() {
        TicTacToe game = new TicTacToe("031");
        Mcts mcts = new Mcts(10000);
        
        Move best1 = mcts.findBestMove(game.getLastMove());        
        assertEquals("Blocking a winner is best, but something else was selected " + best1.toString(), "O2 -- XXOO_____", best1.toString());
    }

    private void assertFinalTie(AI ai, Game game) {
        Move finalMove = playout(ai, game.getLastMove());
        game.playMove(finalMove);
        assertTrue("Thoughtful games end in tie, but this move won... " + finalMove.toString() + " -- " + game.toString(), finalMove.getStatus().isTie());
    }
    
    private Move playout(AI ai, Move move) {
        Move currentMove = move;
        while(currentMove.getStatus().isInProgress()) {
            currentMove = ai.findBestMove(currentMove);
        }

        return currentMove;
    }

    private boolean isCornerO(String move) {
        return move.startsWith("O0") || move.startsWith("O2") || move.startsWith("O6") || move.startsWith("O8");
    }
}
