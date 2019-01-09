package game.blackandwhite.backend.core;

/**
 * The state of a game at any particular point in time. Normally, this
 * represents the state of the game board, but it could be more
 */
public interface State {
    /**
     * @return true when no winner or tie has been decided. More moves are left to
     *         play
     */
    boolean isActive();

    /**
     * @return null if no winner and game is still active. Otherwise, return the
     *         winning player
     */
    Player getWinner();

    /**
     * @return the player that should move next. An IllegalStateException will be
     *         thrown if called when a winner exists
     */
    Player getPlayersTurn();

    /**
     * @return the move that created this state. An IllegalStateException will be
     *         thrown if called from a game's initial state
     */
    Move getCreatingMove();

    /**
     * @return the moves available to the current user
     */
    Moves getAvailableMoves();

    /**
     * @return the moves that have been applied to this state. The list may be empty
     *         if the current state is most recent. The list may contain multiple if
     *         game play has been "forked"
     */
    Moves getAppliedMoves();

    /**
     * @return a string version of the state that's good for console output
     */
    String toText();

    /**
     * @return a json string of the state that's good for UI integration
     */
    String toJson();
}
