import Strategies.GrimTrigger;
import Strategies.Result;
import Strategies.Strategy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GrimTriggerTest {
    private Strategy gt;

    @Before
    public void setup() {
        gt = new GrimTrigger();
    }

    @Test
    public void shouldCooperateOnFirstTurn() {
        // Grimm Trigger soll am Anfang immer Kooperieren
        var expectedResult = Result.COOPERATE;
        var recievedResult = gt.strategy(new ArrayList<>(), new ArrayList<>(), 0);
        assertEquals("GrimmTrigger must cooperate on first turn", expectedResult, recievedResult);
    }

    @Test
    public void shouldAlwaysDefectAfterBeingDefected() {
        // Grimm Trigger soll immer Ablehnen, sobald er auch nur einmal abgelehnt wurde
        List<Result> myHistory = new ArrayList<>();
        List<Result> opponentHistory = new ArrayList<>();

        // Runde 0: Beide kooperieren (Annahme)
        myHistory.add(Result.COOPERATE);
        opponentHistory.add(Result.COOPERATE);

        // Runde 1: Gegner verrät
        opponentHistory.add(Result.DEFECT);

        // Simuliere den Zug in Runde 1, um den Trigger auszulösen
        gt.strategy(myHistory, opponentHistory, 1);

        // Ab Runde 2 muss GrimTrigger immer verraten
        for (int i = 2; i < 20; i++) {
            var expectedResult = Result.DEFECT;
            // Der Gegner versucht jetzt zu kooperieren, um zu sehen, ob GrimTrigger verzeiht
            opponentHistory.add(Result.COOPERATE);
            var recievedResult = gt.strategy(myHistory, opponentHistory, i);
            assertEquals("Grimm Trigger must always defect after being defected once", expectedResult, recievedResult);
            // Füge den Zug zur eigenen Historie hinzu für die nächste Iteration
            myHistory.add(recievedResult);
        }
    }

    @Test
    public void shouldContinueToCooperateWhenOpponentCooperates() {
        List<Result> myHistory = new ArrayList<>();
        List<Result> opponentHistory = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            var expectedResult = Result.COOPERATE;
            // Gegner kooperiert immer
            opponentHistory.add(Result.COOPERATE);
            var recievedResult = gt.strategy(myHistory, opponentHistory, i);
            assertEquals("Grimm Trigger must always cooperate as long as it's opponent is cooperating", expectedResult, recievedResult);
            // Füge den eigenen kooperativen Zug zur Historie hinzu
            myHistory.add(recievedResult);
        }
    }
}