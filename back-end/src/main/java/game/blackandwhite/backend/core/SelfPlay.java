package game.blackandwhite.backend.core;

import java.util.ArrayList;
import java.util.List;

public class SelfPlay {
    private final Game game;
    private List<PlayerLogic> playerLogicList = new ArrayList<>();
    private int maxMoves = 0;

    public SelfPlay(Game game) {
        this.game = game;
    }

    public SelfPlay addPlayerLogic(PlayerLogic playerLogic) {
        playerLogicList.add(playerLogic);
        return this;
    }

    public SelfPlay setNumberOfMoves(int maxMoves) {
        this.maxMoves = maxMoves;
        return this;
    }

    public SelfPlay go() {
        int moveCount = 0;
        while (shouldPlayAnotherMove(moveCount)) {
            playOneMove(getLogic(moveCount));
            moveCount++;
        }
        return this;
    }

    public boolean shouldPlayAnotherMove(int moveCount) {
        return !isMaxMovesReached(moveCount) && game.getState().isActive();
    }

    private PlayerLogic getLogic(int moves) {
        return playerLogicList.get(moves % playerLogicList.size());
    }

    private boolean isMaxMovesReached(int moves) {
        return maxMoves > 0 && moves >= maxMoves;
    }

    public void playOneMove(PlayerLogic playerLogic) {
        Move selectedMove = playerLogic.select(game.getState());
        game.playMove(selectedMove);
    }

    public String getStatus() {
        State s = game.getState();
        if (s.isActive()) {
            return "Game in play";
        }

        Player winner = s.getWinner();
        if (winner == null) {
            return "Game Tied";
        }

        return "Winner is " + winner.toString();
    }
}
