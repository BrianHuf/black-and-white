package game.blackandwhite.backend.rest;

public class TicTacToeState {
    private final String state;

    public TicTacToeState(String moves) {
        this.state = "X__OXO_XO";
    }

    public String getState() {
        return state;
    }
}