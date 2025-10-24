package Strategies;

public class TitForTat implements Strategy {

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        if (indexOfInput == 0) {
            return Result.COOPERATE;
        }
        return lastInput;
    }
}
