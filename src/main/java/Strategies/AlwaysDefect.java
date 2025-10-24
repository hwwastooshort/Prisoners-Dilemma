package Strategies;

public class AlwaysDefect implements Strategy {
    private final String name = "Always Defect";

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        return Result.DEFECT;
    }

    @Override
    public String getName() {
        return name;
    }
}
