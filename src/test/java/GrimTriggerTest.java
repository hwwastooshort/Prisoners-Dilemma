import Strategies.GrimTrigger;
import Strategies.Result;
import Strategies.Strategy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class GrimTriggerTest {
    private Strategy gt;
    private Random random;

    @Before
    public void setup() {
        gt = new GrimTrigger();
    }

    @Test
    public void shouldCooperateOnFirstTurn() {
        // Grimm Trigger soll am Anfang immer Kooperieren
        var expectedResult = Result.COOPERATE;
        var recievedResult = gt.strategy(Result.NONE, 0);
        assertEquals("GrimmTrigger must cooperate on first turn", expectedResult, recievedResult);
    }

    @Test
    public void shouldAlwaysDefectAfterBeingDefected() {
        // Grimm Trigger soll immer Ablehnen, sobald er auch nur einmal abgelehnt wurde
        gt.strategy(Result.DEFECT, 1);
        for (int i = 2; i < 20; i++) {
            var expectedResult = Result.DEFECT;
            var recievedResult = gt.strategy(getRandomResult(), i);
            assertEquals("Grimm Trigger must always defect after being defected once", expectedResult, recievedResult);
        }
    }

    @Test
    public void shouldContinueToCooperateWhenOpponentCooperates() {
        for (int i = 1; i < 20; i++) {
            var expectedResult = Result.COOPERATE;
            var recievedResult = gt.strategy(Result.COOPERATE, i);
            assertEquals("Grimm Trigger must always cooperate as long as it's opponent is cooperating", expectedResult, recievedResult);
        }
    }

    private Result getRandomResult() {
        random = new Random();
        int randomNumber = random.nextInt(Result.values().length - 1);
        return Result.values()[randomNumber];
    }
}
