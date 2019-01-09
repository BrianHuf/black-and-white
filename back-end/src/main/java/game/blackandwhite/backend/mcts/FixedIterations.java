package game.blackandwhite.backend.mcts;

public class FixedIterations implements Coordinator {
    private final long numOfIterations;

    FixedIterations(long numOfIterations) {
        this.numOfIterations = numOfIterations;
    }

    @Override
    public void doRounds(Mcts mcts) {
        for (int iteration = 0; iteration < numOfIterations; iteration++) {
            mcts.doOneRound();
        }
    }
}
