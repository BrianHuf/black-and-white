package game.blackandwhite.backend.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import game.blackandwhite.backend.core.AI;
import game.blackandwhite.backend.core.Game;
import game.blackandwhite.backend.mcts.Mcts;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class Controller {

    @RequestMapping("movesToState")
    public GameState movesToState(@RequestParam(value = "game", defaultValue = "tictactoe") String gameType,
            @RequestParam(value = "moves", defaultValue = "") String moves) {

        return new GameState(GameFactory.create(gameType, moves));
    }

    @RequestMapping("movesTree")
    public NodeState movesTree(
            @RequestParam(value = "game", defaultValue = "tictactoe") String gameType,
            @RequestParam(value = "moves", defaultValue = "") String moves,
            @RequestParam(value = "depth", defaultValue = "4") Integer depth) {
        AI ai = new Mcts(1000);
        Game game = GameFactory.create(gameType, moves);
        ai.findBestMove(game.getLastMove());
        return new NodeState(ai.getRootNode(),depth);
    }
}