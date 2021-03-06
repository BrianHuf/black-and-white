package game.blackandwhite.backend.mcts;

import java.util.Collection;

public class WeightedRandomSelector<T> {
    final Class<T> tClass = null;
    final T[] objects;
    final float[] weights;
    final float total;

    WeightedRandomSelector(Collection<T> list, WeightGetter<T> weightGetter) {
        objects = toArray(list);
        weights = new float[list.size()];
        total = populateWeights(list, weightGetter);
    }

    private static <T> T[] toArray(Collection<T> list) {
        @SuppressWarnings("unchecked")
        T[] ret = (T[]) list.toArray(new Object[list.size()]);
        return ret;
    }

    public static <T> T weightedSelect(Collection<T> items, WeightGetter<T> computer) {
        WeightedRandomSelector<T> selector = new WeightedRandomSelector<T>(items, computer);
        return selector.select();
    }

    private float populateWeights(Collection<T> list, WeightGetter<T> weightGetter) {
        int index = 0;
        float sum = 0;
        for (T item : list) {
            float weight = weightGetter.getWeight(item);
            sum += weight;
            weights[index++] = weight;
            if (weights.length == index) {
                // due to concurrency
                break;
            }
        }
        return sum;
    }

    public T select() {
        float value = total * RandomSelector.rand.nextFloat();
        for (int i = 0; i < objects.length; i++) {
            value -= weights[i];
            if (value < 0) {
                return objects[i];
            }
        }
        
        return objects[objects.length-1];
    }
}
