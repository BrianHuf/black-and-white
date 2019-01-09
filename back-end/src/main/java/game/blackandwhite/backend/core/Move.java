package game.blackandwhite.backend.core;

/**
 * Represent a single move by a particular player. Applying a move is the only
 * way to change the state of a game
 */
public interface Move {
    /**
     * @return state from which this move can be applied
     */
    State getCreatingState();

    /**
     * @return the state that results from applying this move
     */
    State getCreatedState();

    /**
     * Make a new state and make the move. This method is used during normal game
     * play
     *
     * @return new state
     */
    State duplicateStateAndApply();

    /**
     * Apply move to existing state. This method is used during game exploration
     * (e.g. mcts). It is much faster than always creating a new state after each
     * move
     *
     * @return existing state
     */
    State applyToCreatingState();

    /**
     * A judgement of how good a move is. Zero is worst. One is best.
     *
     * @return a value between [0.0, 1.0]
     */
    float goodness();
}
