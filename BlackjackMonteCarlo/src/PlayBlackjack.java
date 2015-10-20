/**
 * Created by heshamsalman on 10/20/15.
 */
public class PlayBlackjack {
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        PlayResult[] playResults = new PlayResult[1000];

        int winCount = 0;
        int loseCount = 0;
        int drawCount = 0;

        // Monte Carlo runs 1000 simulations
        for (int i = 0; i < 1000; i++) {
            PlayResult playResult = blackjack.playGame();
            playResults[i] = playResult;

            switch(playResult) {
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
                    System.out.println("Something's wrong!");
                    break;
            }
        }
        System.out.println("Win Rate: " + (double) winCount/playResults.length * 100 + "%");
        System.out.println("Draw Rate: " + (double) drawCount/playResults.length * 100 + "%");
        System.out.println("Lose Rate: " + (double) loseCount/playResults.length * 100 + "%");
    }
}
