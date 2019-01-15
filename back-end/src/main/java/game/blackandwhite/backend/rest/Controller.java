package game.blackandwhite.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/api/v1/movesToState")
    public TicTacToeState movesToState(@RequestParam(value="game", defaultValue="tictactoe") String game, @RequestParam(value = "moves", defaultValue = "") String moves) {
        return new TicTacToeState(moves);
    }
}