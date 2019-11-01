package game.blackandwhite.backend.mcts;

import java.util.stream.LongStream;

public class FixedConcurrentIterations implements Coordinator {
    private final long numOfIterations;

    FixedConcurrentIterations(long numOfIterations) {
        this.numOfIterations = numOfIterations;
    }

    @Override
    public void doRounds(Mcts mcts) {
        LongStream.range(0, numOfIterations).parallel().forEach(i -> mcts.doOneRound());
    }
}
