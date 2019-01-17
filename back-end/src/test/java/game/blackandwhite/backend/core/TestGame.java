package game.blackandwhite.backend.core;

import java.util.function.Function;

public class TestGame implements Game {
    public static Function<TestMove, Integer> getNumMoves = TestGame::exampleGetNumMoves;
    public static Function<TestMove, Status> getMoveStatus = TestGame::exampleGetMoveStatus;

    Move lastMove = new TestMove();

    @Override
    public Move getLastMove() {
        return lastMove;
    }

    @Override
    public Game playMove(Move move) {
        lastMove = move;
        return this;
    }

    public static Status exampleGetMoveStatus(TestMove m) {
        if (m.moveNumber < 5) {
            return Status.IN_PROGRESS;
        }
    
        int[] moves = m.getAllMoveCells();
        return moves[0] == 0 ? Status.WINNER : Status.TIE;
    }

    public static Integer exampleGetNumMoves(TestMove m) {
        return 10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        TestMove current = (TestMove)lastMove;
        while(current.getPreviousMove().isPresent()) {
            sb.insert(0, Integer.toString(current.cell));
            current = (TestMove)current.getPreviousMove().get();
        }
        return sb.toString();
    }
}