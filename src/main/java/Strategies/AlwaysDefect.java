package Strategies;

import java.util.List;

public class AlwaysDefect implements Strategy {
    private final String name = "Always Defect";

    @Override
    public Result strategy(List<Result> myHistory, List<Result> opponentHistory, int indexOfInput) {
        return Result.DEFECT;
    }

    @Override
    public String getName() {
        return name;
    }
}
