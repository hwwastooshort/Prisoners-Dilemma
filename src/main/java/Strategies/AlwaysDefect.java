package Strategies;

public class AlwaysDefect implements Strategy {

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        return Result.DEFECT;
    }
}
