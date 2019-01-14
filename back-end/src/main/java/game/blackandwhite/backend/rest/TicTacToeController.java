package game.blackandwhite.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {
    @RequestMapping("/api/v1/tictactoe/movesToState/{moves}")
    public TicTacToeState greeting(String moves) {
        return new TicTacToeState(moves);
    }
}