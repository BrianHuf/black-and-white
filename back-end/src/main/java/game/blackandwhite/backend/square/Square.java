package game.blackandwhite.backend.square;

import game.blackandwhite.backend.core.Piece;

public class Square<T extends Piece> {
    final int x;
    final int y;
    final T piece;
    final Board2d<T> board;

    public Square(int x, int y, T piece, Board2d<T> board) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.board = board;
    }

    public int x() {
        return x;
    }

    public int y() { return y; }

    public T piece() {
        return piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean isCorner() {
        return isEdgeX() && isEdgeY();
    }

    boolean isEdgeX() {
        return x == 0 || x == board.size[0] - 1;
    }

    boolean isEdgeY() {
        return y == 0 || y == board.size[1] - 1;
    }

    @Override
    public String toString() {
        return String.format("%s [%d, %d]", piece == null ? " " : piece.toString(), x(), y());
    }
}
