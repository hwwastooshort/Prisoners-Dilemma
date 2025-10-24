package Strategies;

public interface Strategy {
    Result strategy(Result lastInput, int indexOfInput);
    String getName();
}
