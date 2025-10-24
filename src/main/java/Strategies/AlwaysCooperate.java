package Strategies;

public class AlwaysCooperate implements Strategy {
    private final String name = "Always Cooperate";

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        return Result.COOPERATE;
    }

    @Override
    public String getName() {
        return name;
    }
}
