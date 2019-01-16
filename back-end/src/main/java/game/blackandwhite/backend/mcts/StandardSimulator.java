package game.blackandwhite.backend.mcts;

// import game.blackandwhite.backend.core.Move;
// import game.blackandwhite.backend.core.Moves;
// import game.blackandwhite.backend.core.Player;

// import java.util.List;

// import static game.blackandwhite.backend.core.RandomSelector.randomSelect;

class StandardSimulator implements Simulator {
    // private static float WINNER = 1.0f;
    // private static float LOSER = 0.0f;
    // private static float TIE = 0.5f;

    // Player startingPlayer;

    @Override
    public float playout(Node node) {
        // State originalState = node.getMove().getCreatingState();
        // startingPlayer = originalState.getPlayersTurn();

        // Move move = randomSelect((List<Move>) originalState.getAvailableMoves());
        // State mutableState = move.duplicateStateAndApply();
        // while (mutableState.isActive()) {
        //     selectRandomMove(mutableState).applyToCreatingState();
        // }

        // return calculateGoodness(mutableState);
        return 0.5f;
    }

    // private float calculateGoodness(State mutableState) {
    //     Player winningPlayer = mutableState.getWinner();
    //     if (winningPlayer == null) {
    //         return TIE;
    //     } else if (startingPlayer.equals(winningPlayer)) {
    //         return WINNER;
    //     } else {
    //         return LOSER;
    //     }
    // }

    // private Move selectRandomMove(State state) {
    //     Moves moves = state.getAvailableMoves();
    //     return randomSelect((List<Move>) moves);
    // }
}

