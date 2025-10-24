package Game;

import Strategies.AlwaysDefect;
import Strategies.Result;
import Strategies.Strategy;
import Strategies.TitForTat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Hier kann man die beiden Strategien auswählen
        var player1 = new TitForTat();
        var player2 = new TitForTat();

        Game game = new Game(player1, player2);
        var winner = game.run();

        int scoreP1 = game.getScorePlayer1();
        int scoreP2 = game.getScorePlayer2();

        var moveListP1 = game.getPlayer1Choices();
        var moveListP2 = game.getPlayer2Choices();

        switch (winner) {
            case null -> System.out.printf("Unentschieden! Endstand: %d zu %d\n", scoreP1, scoreP2);
            case Strategy s when s == player1 -> System.out.printf("Spieler 1 (%s) gewinnt! Endstand: %d zu %d\n", player1.getName(), scoreP1, scoreP2);
            case Strategy s when s == player2 -> System.out.printf("Spieler 2 (%s) gewinnt! Endstand: %d zu %d\n", player2.getName(), scoreP2, scoreP1); // Korrigierte Reihenfolge für P2
            default -> System.out.println("Ein unerwartetes Ergebnis ist aufgetreten.");
        }

        printGameHistory(player1, player2, moveListP1, moveListP2);
    }

    private static void printGameHistory(Strategy p1, Strategy p2, List<Result> movesP1, List<Result> movesP2) {
        System.out.println("\n--- Detaillierter Spielverlauf ---");

        String headerFormat = "| %-5s | %-18s | %-18s |%n";
        String rowFormat = "| %-5d | %-18s | %-18s |%n";
        String separator = "+-------+--------------------+--------------------+";

        System.out.println(separator);
        System.out.printf(headerFormat, "Runde", "P1: " + p1.getName(), "P2: " + p2.getName());
        System.out.println(separator);

        for (int i = 0; i < movesP1.size(); i++) {
            System.out.printf(rowFormat, i + 1, movesP1.get(i), movesP2.get(i));
        }

        System.out.println(separator);
    }
}