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
        PlayResult result;
        //Deal initial cards
        dealStartingHands(dealer, player);

        // Game loops
        while (dealer.isPlaying && player.isPlaying) {
            playRound(dealer, player);
        }
        while (dealer.isPlaying) {
            Card c = cards.drawCard();
            dealer.hit(c);
        }
        while (player.isPlaying) {
            Card c = cards.drawCard();
            player.hit(c);
        }

        // Calculate game result
        int dealerScore = dealer.stand();
        int playerScore = player.stand();
        result = calculateResult(dealerScore, playerScore);

        // Clean up
        dealer.clearContents();
        player.clearContents();
        cards = new CardDeck();

        return result;
    }

    private PlayResult calculateResult(int dealerScore, int playerScore) {
        if (playerScore <= 21 && dealerScore <= 21) {
            if (playerScore > dealerScore) {
                return PlayResult.WIN;
            } else if (dealerScore == playerScore) {
                return PlayResult.DRAW;
            } else {
                return PlayResult.LOSE;
            }
        } else if (playerScore > 21 && dealerScore > 21) {
            return PlayResult.DRAW;
        } else {
            if (playerScore > 21) {
                return PlayResult.LOSE;
            }
            return PlayResult.WIN;
        }
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