package Strategies;

public class AlwaysCooperate implements Strategy {

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        return Result.COOPERATE;
    }
}
