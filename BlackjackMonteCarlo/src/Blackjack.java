import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 */

class Blackjack {
    private final List<BlackjackHand> players;
    private final BlackjackHand dealer;
    private Deck cards;

    private HandState[] results;

    Blackjack(int playerCount) {
        results = new HandState[playerCount];
        cards = new CardDeck();
        players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new PlayerHand());
        }
        dealer = new DealerHand();
    }

    /**
     * Plays one round of blackjack. Cleans up after self.
     *
     * @return
     */
    HandState[] playGame() {
        results = new HandState[players.size()];
        //Deal initial cards
        dealStartingHand(dealer);

        players.forEach(this::dealStartingHand);

        //In casinos, the game is played such that all players must stand or bust before the dealer plays his turn.
        playersRound();
        dealersRound();
        evaluatePlayers();
        prepareForNextGame();

        return results;
    }

    private void evaluatePlayers() {
        for (int i = 0; i < players.size(); i ++) {
            BlackjackHand player = players.get(i);
            HandState result = player.evaluateHandAgainstDealer(dealer);
            results[i] = result;
        }
    }

    private void dealersRound() {
        while (dealer.isPlaying) {
            Card c = cards.drawCard();
            dealer.hit(c);
        }
    }

    private void playersRound() {
        players.stream().filter(p -> p.isPlaying).forEach(p -> {
            Card c = cards.drawCard();
            p.hit(c);
        });
    }

    private void prepareForNextGame() {
        dealer.clear();
        players.forEach(BlackjackHand::clear);
        cards = new CardDeck();
    }

    private void playRound(BlackjackHand hand) {
        if (hand.isPlaying) {
            Card c = cards.drawCard();
            hand.hit(c);
        }
    }

    private void dealStartingHand(BlackjackHand hand) {
        for (int i = 0; i < 2; i++) {
            Card c1 = cards.drawCard();
            hand.hit(c1);
        }
    }
}