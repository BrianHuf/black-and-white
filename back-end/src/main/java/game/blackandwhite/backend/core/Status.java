package game.blackandwhite.backend.core;

public enum Status {
    IN_PROGRESS(false), WINNER(true), LOSER(true), TIE(true);

    private final boolean isGameOver;

    private Status(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
