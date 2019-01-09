package game.blackandwhite.backend.tictactoe;

import game.blackandwhite.backend.core.Player;

public class T3Player implements Player {
    static final T3Player P1 = new T3Player(0);
    static final T3Player P2 = new T3Player(1);

    final int index;

    T3Player(int index) {
        this.index = index;
    }

    public T3Piece getPiece() {
        return index == 0 ? T3Piece.P1 : T3Piece.P2;
    }

    public T3Player next() {
        return equals(P1) ? T3Player.P2 : T3Player.P1;
    }

    public String toString() {
        return "Player " + Integer.toString(index+1);
    }
}
