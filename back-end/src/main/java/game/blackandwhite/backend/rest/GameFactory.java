package game.blackandwhite.backend.rest;

import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.tictactoe.TicTacToe;

public class GameFactory {
    public static Game create(String gameType, String state) {
        switch (gameType) {
        case "tictactoe":
            return new TicTacToe(state);
        default:
            throw new IllegalArgumentException("Only tictactoe accepted currently");
        }
    }
}