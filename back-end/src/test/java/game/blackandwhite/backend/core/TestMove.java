package game.blackandwhite.backend.core;

import java.util.Optional;

public class TestMove implements Move {
    public final TestMove previous;
    public final int cell;
    public final int moveNumber;

    TestMove() {
        this.previous = null;
        this.cell = -1;
        this.moveNumber = 0;
    }

    TestMove(TestMove previous, int cell) {
        this.previous = previous;
        this.cell = cell;
        this.moveNumber = previous.moveNumber + 1;
    }
    
    @Override
    public Player getPlayer() {
        if (previous == null) { 
            return Player.NOBODY;
        }

        return moveNumber % 2 == 1 ? Player.P1 : Player.P2;
    }

    @Override
    public Optional<Move> getPreviousMove() {
        if (previous != null) {
            return Optional.of(previous);            
        }

        return Optional.empty();
    }

    @Override
    public Move[] getNextMoves() {
        TestMove[] moves = new TestMove[TestGame.getNumMoves.apply(this)];
        for(int i=0;i<moves.length;i++) {
            moves[i] = new TestMove(this, i);
        }

        return moves;
    }

	@Override
	public Status getStatus() {
        return TestGame.getMoveStatus.apply(this);        
    }

    public int[] getAllMoveCells() {
        int[] moves = new int[moveNumber];

        TestMove check = this;
        int index = 1;
        while(check.previous != null) {
            moves[moveNumber-index] = check.cell;
            check = check.previous;
            index++;
        }

        return moves;
    }

    private TestMove getFirstMove() {
        TestMove check = this;
        while(check.previous.previous != null) {
            check = check.previous;
        }

        return check;
    }

    public String toString() {
        if (previous == null) {
            return "begin test game";
        }
        
        return String.format("Step %d / Move %d", moveNumber, cell);
    }
}