package game.blackandwhite.backend.core;

import java.util.List;
import java.util.Random;

public class RandomSelector {
    static final Random rand = new Random();

    public static <T> T randomSelect(List<T> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("item must not be empty");
        }

        int index = rand.nextInt(items.size());
        return items.get(index);
    }
}
