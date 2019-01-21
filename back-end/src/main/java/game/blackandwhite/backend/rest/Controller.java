package game.blackandwhite.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/api/v1/movesToState")
    public GameState movesToState(@RequestParam(value = "game", defaultValue = "tictactoe") String gameType,
            @RequestParam(value = "moves", defaultValue = "") String moves) {

        return new GameState(GameFactory.create(gameType, moves));
    }
}