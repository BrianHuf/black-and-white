package game.blackandwhite.backend.mcts;

import java.util.stream.LongStream;

public class FixedIterations implements Coordinator {
    private final long numOfIterations;

    FixedIterations(long numOfIterations) {
        this.numOfIterations = numOfIterations;
    }

    @Override
    public void doRounds(Mcts mcts) {
        LongStream.range(0, numOfIterations).forEach(i -> mcts.doOneRound());
        // FIXME fix java.util.ConcurrentModificationException
         //LongStream.range(0, numOfIterations).parallel().forEach(i -> mcts.doOneRound());
    }
}
