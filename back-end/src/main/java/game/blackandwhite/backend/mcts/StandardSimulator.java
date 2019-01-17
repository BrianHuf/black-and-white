package game.blackandwhite.backend.mcts;

import game.blackandwhite.backend.core.Move;
import game.blackandwhite.backend.core.Player;
import static game.blackandwhite.backend.mcts.RandomSelector.randomSelect;

class StandardSimulator implements Simulator {
    private static float WINNER = 1.0f;
    private static float LOSER = -1.0f;
    private static float TIE = 0.0f;

    @Override
    public float playout(Node node) {
        Move startingMove = node.getMove();
        Player startingPlayer = startingMove.getPlayer();
        Move finalMove = playout(startingMove);
        float ret = goodness(finalMove, startingPlayer);
        return ret;
    }

    private Move playout(Move startingMove) {
        Move currentMove = startingMove;
        while(currentMove.getStatus().isInProgress()) {
            currentMove = randomSelect(currentMove.getNextMoves());
        }
        
        return currentMove;
    }

    private float goodness(Move finalMove, Player startingPlayer) {
        Player finalPlayer = finalMove.getPlayer();
        switch(finalMove.getStatus()) {
            case WINNER:
                return finalPlayer.equals(startingPlayer) ? WINNER : LOSER;
            case LOSER:
                return finalPlayer.equals(startingPlayer) ? LOSER : WINNER;
            case TIE:
                return TIE;
            default:
                throw new IllegalStateException();
        }
    }
}

