package Strategies;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStrategy implements Strategy {

    private static final List<Result> PLAYABLE_RESULTS =
            Arrays.stream(Result.values())
                    .filter(result -> result != Result.NONE)
                    .toList();

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        int randomIndex = ThreadLocalRandom.current().nextInt(PLAYABLE_RESULTS.size());
        return PLAYABLE_RESULTS.get(randomIndex);
    }
}