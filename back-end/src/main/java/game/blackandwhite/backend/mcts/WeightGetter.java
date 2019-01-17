package game.blackandwhite.backend.mcts;

public interface WeightGetter<T> {
    float getWeight(T item);
}
