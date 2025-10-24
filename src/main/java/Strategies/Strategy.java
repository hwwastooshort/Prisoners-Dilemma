package Strategies;

import java.util.List;

public interface Strategy {
    Result strategy(List<Result> myHistory, List<Result> opponentHistory, int indexOfInput);
    String getName();
}
