import Strategies.Result;
import Strategies.Strategy;
import Strategies.TitForTat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        var recievedResult = tft.strategy(new ArrayList<>(), new ArrayList<>(), 0);
        assertEquals("TitForTat must cooperate at the beginning", expectedResult, recievedResult);
    }

    @Test
    public void shouldCooperateWhenOpponentCooperates() {
        // TitForTat soll immer das kopieren, was der Gegner zuletzt gemacht hat
        List<Result> opponentHistory = new ArrayList<>();
        opponentHistory.add(Result.COOPERATE);

        var expectedResult = Result.COOPERATE;
        var recievedResult = tft.strategy(new ArrayList<>(), opponentHistory, 1);
        assertEquals("TitForTat must cooperate when opponent cooperated", expectedResult, recievedResult);
    }

    @Test
    public void shouldDefectWhenOpponentDefects() {
        // TitForTat kopiert immer die letzte Wahl des Gegners
        List<Result> opponentHistory = new ArrayList<>();
        opponentHistory.add(Result.DEFECT);

        var expectedResult = Result.DEFECT;
        var recievedResult = tft.strategy(new ArrayList<>(), opponentHistory, 1);
        assertEquals("TitForTat must defect when opponent defected", expectedResult, recievedResult);
    }
}