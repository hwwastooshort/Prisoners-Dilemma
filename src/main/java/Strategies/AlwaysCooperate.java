package Strategies;

import java.util.List;

public class AlwaysCooperate implements Strategy {
    // Kooperiert immer, egal was passiert
    private final String name = "Always Cooperate";

    @Override
    public Result strategy(List<Result> myHistory, List<Result> opponentHistory, int indexOfInput) {
        return Result.COOPERATE;
    }

    @Override
    public String getName() {
        return name;
    }
}
