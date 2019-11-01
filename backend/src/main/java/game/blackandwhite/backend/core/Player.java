package game.blackandwhite.backend.core;

public enum Player {
    NOBODY(' ', 0), P1('X', 1), P2('O', 2);

    private final Character token;

    private final int index;

    private Player(Character token, int index) {
        this.token = token;
        this.index = index;
    }

    public String toString() {
        return token.toString();
    }

    public int getIndex() {
        return index;
    }
}
