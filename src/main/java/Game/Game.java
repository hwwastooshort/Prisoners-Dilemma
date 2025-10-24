package Game;

import Strategies.Result;
import Strategies.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Strategy player1;
    private final Strategy player2;

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    private final List<Result> player1Choices = new ArrayList<>();
    private final List<Result> player2Choices = new ArrayList<>();

    private static final int NUMBER_OF_TURNS = 100;

    public Game(Strategy player1, Strategy player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Strategy run() {
        Result lastMoveP1 = Result.NONE;
        Result lastMoveP2 = Result.NONE;

        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            Result currentMoveP1 = player1.strategy(player1Choices, player2Choices, i);
            Result currentMoveP2 = player2.strategy(player2Choices, player1Choices, i);

            calculateScores(currentMoveP1, currentMoveP2);

            lastMoveP1 = currentMoveP1;
            lastMoveP2 = currentMoveP2;

            player1Choices.add(lastMoveP1);
            player2Choices.add(lastMoveP2);
        }

        if (scorePlayer1 > scorePlayer2) {
            return player1;
        } else if (scorePlayer2 > scorePlayer1) {
            return player2;
        } else {
            return null;
        }
    }

    private void calculateScores(Result moveP1, Result moveP2) {
        if (moveP1 == Result.COOPERATE && moveP2 == Result.COOPERATE) {
            scorePlayer1 += 3;
            scorePlayer2 += 3;
        } else if (moveP1 == Result.COOPERATE && moveP2 == Result.DEFECT) {
            scorePlayer2 += 5;
        } else if (moveP1 == Result.DEFECT && moveP2 == Result.COOPERATE) {
            scorePlayer1 += 5;
        } else if (moveP1 == Result.DEFECT && moveP2 == Result.DEFECT) {
            scorePlayer1 += 1;
            scorePlayer2 += 1;
        }
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public List<Result> getPlayer1Choices() {
        return player1Choices;
    }

    public List<Result> getPlayer2Choices() {
        return player2Choices;
    }
}