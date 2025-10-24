package Strategies;

import java.util.List;

public class TitForTat implements Strategy {
    private final String name = "Tit for Tat";

    @Override
    public Result strategy(List<Result> myHistory, List<Result> opponentHistory, int indexOfInput) {
        // Beginnt immer mit Kooperation und kopiert dann, was
        // der Gegner als letztes genommen hab
        if (indexOfInput == 0) {
            return Result.COOPERATE;
        }
        return opponentHistory.get(opponentHistory.size() - 1);
    }

    @Override
    public String getName() {
        return name;
    }
}
