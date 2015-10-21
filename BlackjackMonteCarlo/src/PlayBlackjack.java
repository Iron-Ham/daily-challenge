import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 */
public class PlayBlackjack {
    private static final int MAX_ITERATIONS = 1000;
    private static final int NUMBER_OF_PLAYERS = 5; // in addition to the dealer

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack(NUMBER_OF_PLAYERS);
        List<HandState[]> simulationResults = new ArrayList<>();
        // Monte Carlo runs 1000 simulations
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            HandState[] gameResults = blackjack.playGame();
            simulationResults.add(gameResults);
        }

        printPlayerRatings(simulationResults);
    }

    private static void printPlayerRatings(List<HandState[]> simulationResults) {
        //Evaluate Each Player's Wins, Losses, and Ties
        for (int player = 0; player < NUMBER_OF_PLAYERS; player++) {
            System.out.printf("Player %d:\n", player+1);
            int winCount = 0;
            int loseCount = 0;
            int drawCount = 0;

            for (HandState[] gameResults : simulationResults) {
                HandState state = gameResults[player];
                switch (state) {
                    case WIN:
                        winCount++;
                        break;
                    case LOSE:
                        loseCount++;
                        break;
                    case DRAW:
                        drawCount++;
                        break;
                    case NONE:
                        System.out.println("Fatal Error 1: No game state detected");
                        System.exit(1);
                }
            }

            double winRate = (double) winCount / MAX_ITERATIONS * 100;
            double loseRate = (double) loseCount / MAX_ITERATIONS * 100;
            double drawRate = (double) drawCount / MAX_ITERATIONS * 100;

            System.out.printf("Win Rate: %.2f\n", winRate);
            System.out.printf("Draw Rate: %.2f\n", drawRate);
            System.out.printf("Lose Rate: %.2f\n", loseRate);
            System.out.println();
        }
    }
}
