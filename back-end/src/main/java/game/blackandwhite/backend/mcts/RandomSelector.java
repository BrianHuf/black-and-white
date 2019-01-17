package game.blackandwhite.backend.mcts;

import java.util.List;
import java.util.Random;

public class RandomSelector {
    static final Random rand = new Random();

    public static <T> T randomSelect(T[] items) {
        if (items.length == 0) {
            throw new IllegalArgumentException("items must not be empty");
        }

        int index = rand.nextInt(items.length);
        return items[index];
    }

    public static <T> T randomSelect(List<T> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("items must not be empty");
        }

        int index = rand.nextInt(items.size());
        return items.get(index);
    }
}
