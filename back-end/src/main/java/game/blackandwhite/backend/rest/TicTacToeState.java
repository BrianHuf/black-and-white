package game.blackandwhite.backend.rest;

public class TicTacToeState {
    private final String state;

    public TicTacToeState(String moves) {
        this.state = toString(moves);
    }

    private String toString(String moves) {
        StringBuilder sb = new StringBuilder("_________");        

        int index = 0;
        for(Character c : moves.toCharArray()) {
            Character piece = index % 2 == 0 ? 'X' : 'O';
            sb.setCharAt(c-48, piece);
            index++;
        }

        return sb.toString();
    }

    public String getState() {
        return state;
    }
}