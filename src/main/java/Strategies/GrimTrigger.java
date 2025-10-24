package Strategies;

import java.util.List;

public class GrimTrigger implements Strategy {
    private boolean hasBeenDefected = false;
    private final String name = "Grimm Trigger";

    @Override
    public Result strategy(List<Result> myHistory, List<Result> opponentHistory, int indexOfInput) {
        // Grim Trigger kooperiert von Start aus und macht das so lange, bis der Gegner auch nur einmal ablehnt.
        // Danach lehnt Grim Trigger immer ab, egal was noch vom Gegner kommt.
        if (indexOfInput == 0) {
            return Result.COOPERATE;
        }
        if (opponentHistory.get(opponentHistory.size() - 1)== Result.DEFECT) {
            hasBeenDefected = true;
        }

        if (hasBeenDefected) {
            return Result.DEFECT;
        }

        return Result.COOPERATE;
    }

    @Override
    public String getName() {
        return name;
    }
}
