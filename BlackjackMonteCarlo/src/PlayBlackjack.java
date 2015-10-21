/**
 * Created by heshamsalman on 10/20/15.
 */
public class PlayBlackjack {

    private static int winCount = 0;
    private static int loseCount = 0;
    private static int drawCount = 0;
    private static final int MAX_ITERATIONS = 1000;

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        PlayResult[] playResults = new PlayResult[MAX_ITERATIONS];
        // Monte Carlo runs 1000 simulations
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            PlayResult playResult = blackjack.playGame();
            playResults[i] = playResult;

            switch (playResult) {
                case WIN:
                    winCount++;
                    break;
                case LOSE:
                    loseCount++;
                    break;
                case DRAW:
                    drawCount++;
                    break;
            }
        }
        System.out.println("Win Rate: " + (double) winCount / playResults.length * 100 + "%");
        System.out.println("Draw Rate: " + (double) drawCount / playResults.length * 100 + "%");
        System.out.println("Lose Rate: " + (double) loseCount / playResults.length * 100 + "%");
    }
}
