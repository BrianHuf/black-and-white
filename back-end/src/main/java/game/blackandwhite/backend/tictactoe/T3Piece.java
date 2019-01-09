package game.blackandwhite.backend.tictactoe;

import game.blackandwhite.backend.core.Piece;

public class T3Piece implements Piece {
    public static final T3Piece P1 = new T3Piece('X');
    public static final T3Piece P2 = new T3Piece('O');

    private final char label;

    T3Piece(char label) {
        this.label = label;
    }

    char getChar() {
        return label;
    }

    public String toString() {
        return Character.toString(label);
    }
}
