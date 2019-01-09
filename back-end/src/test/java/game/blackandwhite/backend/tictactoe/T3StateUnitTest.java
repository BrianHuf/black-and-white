package game.blackandwhite.backend.tictactoe;

import org.junit.Test;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.State;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class T3StateUnitTest {
    static final String BOARD_EMPTY = "   " + "   " + "   ";
    static final String BOARD_WINNER_X_1 = "XO " + "OX " + "  X";

    @Test
    public void isActive_empty_true() {
        T3State testThis = new T3State(BOARD_EMPTY);
        assertTrue(testThis.isActive());
    }

    @Test
    public void isActive_winner_x_false() {
        T3State testThis = new T3State(BOARD_WINNER_X_1);
        assertFalse(testThis.isActive());
    }

    @Test
    public void getWinner_empty_null() {
        T3State testThis = new T3State(BOARD_EMPTY);
        assertNull(testThis.getWinner());
    }

    @Test
    public void getWinner_winner_P1() {
        T3State testThis = new T3State(BOARD_WINNER_X_1);
        assertEquals(T3Player.P1, testThis.getWinner());
    }

    @Test
    public void playerToMoveNext() {
        T3State testThis = new T3State(BOARD_EMPTY);
        assertEquals(T3Player.P1, testThis.getPlayersTurn());
    }

    @Test
    public void getCreatingMove_empty_null() {
        T3State testThis = new T3State(BOARD_EMPTY);
        assertNull(testThis.getCreatingMove());
    }

    @Test
    public void getCreatingMove_oneMove_P2() {
        State state0 = new T3State(BOARD_EMPTY);
        Move move = state0.getAvailableMoves().get(0);
        State state1 = move.duplicateStateAndApply();
        assertEquals(move, state1.getCreatingMove());
    }

    @Test
    public void getAvailableMoves() {
        T3State testThis = new T3State(BOARD_EMPTY);
        assertEquals(9, testThis.getAvailableMoves().size());
    }

    @Test
    public void getAppliedMoves() {
        State state0 = new T3State(BOARD_EMPTY);
        Move move = state0.getAvailableMoves().get(0);
        State state1 = move.duplicateStateAndApply();
        assertEquals(move, state0.getAppliedMoves().get(0));
        assertEquals(1, state0.getAppliedMoves().size());
        assertTrue(state1.getAppliedMoves().isEmpty());
    }

    @Test
    public void toText() {
        T3State testThis = new T3State(BOARD_WINNER_X_1);
        assertEquals("X|O| \n-----\nO|X| \n-----\n | |X\n", testThis.toText());
    }

    @Test
    public void toJson() {
    }

    @Test
    public void duplicateAndApply() {
    }

    @Test
    public void apply() {
    }
}