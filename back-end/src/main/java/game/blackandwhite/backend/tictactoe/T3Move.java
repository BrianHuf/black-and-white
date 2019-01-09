package game.blackandwhite.backend.tictactoe;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.square.Square;

public class T3Move implements Move {
    private final T3State fromState;
    private T3State appliedToState;
    private Square<T3Piece> square;

    T3Move(T3State fromState, Square<T3Piece> square) {
        this.fromState = fromState;
        this.square = square;
    }

    @Override
    public T3State getCreatingState() {
        return fromState;
    }

    @Override
    public T3State getCreatedState() {
        return appliedToState;
    }

    @Override
    public T3State duplicateStateAndApply() {
        return fromState.duplicateAndApply(this);
    }

    @Override
    public T3State applyToCreatingState() {
        fromState.apply(this);
        appliedToState = fromState;
        appliedToState.nextPlayer();
        return fromState;
    }

    @Override
    public float goodness() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s -> [%d, %d]", getPiece(), square.x(), square.y());
    }

    void setAppliedToState(T3State applyToState) {
        this.appliedToState = applyToState;
    }

    public Square<T3Piece> getSquare() {
        return square;
    }

    public T3Piece getPiece() {
        return fromState.currentPlayer.getPiece();
    }
}
