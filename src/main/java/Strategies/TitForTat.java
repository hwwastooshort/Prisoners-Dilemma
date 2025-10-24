package Strategies;

public class TitForTat implements Strategy {
    private final String name = "Tit for Tat";

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        if (indexOfInput == 0) {
            return Result.COOPERATE;
        }
        return lastInput;
    }

    @Override
    public String getName() {
        return name;
    }
}
