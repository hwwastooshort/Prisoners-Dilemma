package Strategies;

public class GrimTrigger implements Strategy {
    private boolean hasBeenDefected = false;

    @Override
    public Result strategy(Result lastInput, int indexOfInput) {
        // Grim Trigger kooperiert von Start aus und macht das so lange, bis der Gegner auch nur einmal Ablehnt.
        // Danach lehnt Grim Trigger immer ab, egal was noch vom Gegner kommt.
        if (indexOfInput == 0) {
            return Result.COOPERATE;
        }
        if (lastInput == Result.DEFECT) {
            hasBeenDefected = true;
        }

        if (hasBeenDefected) {
            return Result.DEFECT;
        }

        return Result.COOPERATE;
    }
}
