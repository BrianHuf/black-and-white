package game.blackandwhite.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {
    @RequestMapping("/api/v1/tictactoe/movesToState")
    public TicTacToeState greeting(@RequestParam(value = "moves", defaultValue = "") String moves) {
        return new TicTacToeState(moves);
    }
}