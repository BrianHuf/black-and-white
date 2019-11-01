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

    public boolean isInProgress() {
        return !isGameOver();
    }

	public boolean isTie() {
		return equals(TIE);
    }
    
	public boolean isWinner() {
		return equals(WINNER);
    }
    
	public boolean isLoser() {
		return equals(LOSER);
	}
}
