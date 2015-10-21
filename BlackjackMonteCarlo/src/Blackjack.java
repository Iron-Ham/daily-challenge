enum PlayResult {
    WIN(1),
    DRAW(2),
    LOSE(3);

    private String description;

    PlayResult(int value) {
        switch (value) {
            case 1:
                description = "Player wins";
                break;
            case 2:
                description = "Draw";
                break;
            case 3:
                description = "House wins";
                break;
        }
    }

    public String toString() {
        return description;
    }
}

/**
 * Created by heshamsalman on 10/20/15.
 */
class Blackjack {
    private final BlackjackHand player;
    private final BlackjackHand dealer;
    private Deck cards;

    Blackjack() {
        cards = new CardDeck();
        player = new PlayerHand();
        dealer = new DealerHand();
    }

    /**
     * Plays one round of blackjack. Cleans up after self.
     *
     * @return
     */
    PlayResult playGame() {
        roundCount++;
        PlayResult result = null;
        //Deal initial cards
        dealStartingHands(dealer, player);

        // Game loops
        while (result == null) {
            playRound(dealer, player);
            result = evaluateHands(dealer, player);
        }
        printHand(result);
        prepareForNextGame();
        return result;

    }

    private PlayResult evaluateHands(BlackjackHand dealer, BlackjackHand player) {
        //Dealer has stood or busted. This condition must be checked before the reverse of it because of the showdown rule.
        if (!dealer.isPlaying && player.isPlaying) {
            //If dealer has busted
            if (dealer.stand() > 21) {
                if (player.getValue() <= 21) {
                    return PlayResult.WIN;
                }
            }
            //We cannot evaluate the game if the dealer is standing and the player is still playing.
            return null;
        }
        //Immature evaluation of the game.
        else if (dealer.isPlaying && player.isPlaying) {
            return null;
        }
        //The player has stood or busted
        else if (!player.isPlaying && dealer.isPlaying) {
            if (player.stand() > 21) {
                return PlayResult.LOSE;
            }
            //We cannot evaluate the game if the dealer is still playing and the player has stood.
            return null;
        }
        //The player and the dealer are both not playing
        else {
            int dealerScore = dealer.stand();
            int playerScore = player.stand();

            if (playerScore <= 21 && dealerScore <= 21) {
                if (playerScore == dealerScore) return PlayResult.DRAW;
                else return playerScore > dealerScore? PlayResult.WIN : PlayResult.LOSE;
            } else if (playerScore > 21 && dealerScore > 21) {
                return PlayResult.DRAW;
            } else if (playerScore <= 21) {
                return PlayResult.WIN;
            } else {
                return PlayResult.LOSE;
            }
        }
    }

    private int roundCount = 0;
    private void printHand(PlayResult result) {
        System.out.println("ROUND: " + roundCount);
        System.out.println("Dealer:");
        dealer.cards.forEach(System.out::println);
        System.out.println("Player:");
        player.cards.forEach(System.out::println);
        System.out.println(result + "\n");
    }

    private void prepareForNextGame() {
        dealer.clearContents();
        player.clearContents();
        cards = new CardDeck();
    }

    private void playRound(BlackjackHand dealerHand, BlackjackHand playerHand) {
        if (dealerHand.isPlaying) {
            Card c = cards.drawCard();
            dealerHand.hit(c);
        }
        if (playerHand.isPlaying) {
            Card c = cards.drawCard();
            playerHand.hit(c);
        }
    }

    private void dealStartingHands(BlackjackHand dealerHand, BlackjackHand playerHand) {
        for (int i = 0; i < 2; i++) {
            Card c1 = cards.drawCard();
            Card c2 = cards.drawCard();

            dealerHand.hit(c1);
            playerHand.hit(c2);
        }
    }
}