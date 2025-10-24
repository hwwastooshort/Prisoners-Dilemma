import Strategies.Result;
import Strategies.Strategy;
import Strategies.TitForTat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TitForTatTest {
    private Strategy tft;

    @Before
    public void setup() {
        tft = new TitForTat();
    }

    @Test
    public void shouldCooperateOnFirstMove() {
        // TitForTat soll in der ersten Runde immer kooperieren
        var expectedResult = Result.COOPERATE;
        var recievedResult = tft.strategy(Result.NONE, 0);
        assertEquals("TitForTat must cooperate at the beginning", recievedResult, expectedResult);
    }

    @Test
    public void shouldCooperateWhenOpponentCooperates() {
        // TitForTat soll immer das kopieren, was der Gegner zuletzt gemacht hat
        var expectedResult = Result.COOPERATE;
        var recievedResult = tft.strategy(Result.COOPERATE, 1);
        assertEquals("TitForTat must cooperate when opponent cooperated", recievedResult, expectedResult);
    }

    @Test
    public void shouldDefectWhenOpponentDefects() {
        // TitForTat kopiert immer die letzte Wahl des Gegners
        var expectedResult = Result.DEFECT;
        var recievedResult = tft.strategy(Result.DEFECT, 1);
        assertEquals("TitForTat must defect when opponent defected", recievedResult, expectedResult);
    }
}