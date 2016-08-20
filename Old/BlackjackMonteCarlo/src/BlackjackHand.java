import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 *
 * A BlackjackHand is a hand of cards. It is also a representation of a player or dealer. The hand can be active
 * (isPlaying) or inactive (!isPlaying). By default, a BlackjackHand will hold at 17.
 *
 * DealerHand is an implementation of BlackjackHand. It has no custom parameters or changes.
 *
 * PlayerHand is an implementation of BlackjackHand which sets a custom hold-value parameter.
 *
 * HandState is an enumerable that defines whether a particular hand has won, drawn, or lost.
 */
enum HandState {
    WIN(1),
    DRAW(2),
    LOSE(3);

    private String description;

    HandState(int value) {
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

abstract class BlackjackHand {
    List<Card> cards;
    int value;
    boolean isPlaying;
    private HandState state;
    int holdValue = 17;

    HandState getState() {
        return this.state;
    }

    @Override
    public String toString() {
        String description = "";
        for (Card c : cards) {
            description += c.toString() + "\n";
        }
        return description;
    }

    /**
     * Evaluates the score/value of a given list of cards
     *
     * @param cards a list of cards to evaluate
     * @return value of given cards
     */
    private int evaluateHandValue(List<Card> cards) {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            Rank r = card.getRank();
            switch (r) {
                case ACE:
                    // Deal with aces after the value for remaining cards has been determined.
                    aceCount++;
                    break;
                case JACK:
                case QUEEN:
                case KING:
                    value += 10;
                    break;
                default:
                    value += Integer.parseInt(r.toString());
            }
        }

        // Evaluate aces
        // Aces are counted as 11 if it is advantageous to count them as 1.
        // Otherwise, they are counted as 1.
        for (int i = 0; i < aceCount; i++) {
            if (value + 11 + (aceCount - i - 1) <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        if (value == 21 && cards.size() == 2) {
            this.isPlaying = false;
        }

        if (value > 21) {
            this.isPlaying = false;
        }
        return value;
    }

    /**
     * Sets the hand-state by comparing the current hand to the dealer's.
     * @param dealer
     * @return
     */
    public HandState evaluateHandAgainstDealer(BlackjackHand dealer) {
        // Check for blackjack
        if (this.value == 21 && cards.size() == 2) {
            this.state = HandState.WIN;
        }
        // Check for bust
        else if (this.value > 21) {
            this.state = HandState.LOSE;
        }
        // Check for dealer bust
        else if (dealer.value > 21) {
            this.state = HandState.WIN;
        }
        // Check for draw
        else if (this.value == dealer.value) {
            this.state = HandState.DRAW;
        }
        else if (this.value > dealer.value) {
            this.state = HandState.WIN;
        } else {
            this.state = HandState.LOSE;
        }

        return this.state;
    }

    private void stand() {
        this.isPlaying = false;
    }

    public int getValue() {
        return value;
    }

    /**
     * Add a specified card to the hand
     *
     * @param card
     */
    public void hit(Card card) {
        if (isPlaying) {
            cards.add(card);
            this.value = evaluateHandValue(cards);
            if (this.value >= holdValue) {
                stand();
            }
        }
    }

    /**
     * Used to re-initialize self for a new game.
     */
    public void clear() {
        cards.clear();
        isPlaying = true;
    }
}

class DealerHand extends BlackjackHand {
    DealerHand() {
        cards = new ArrayList<>();
        value = 0;
        isPlaying = true;
    }
}

class PlayerHand extends BlackjackHand {
    PlayerHand(int holdValue) {
        cards = new ArrayList<>();
        value = 0;
        isPlaying = true;
        this.holdValue = holdValue;
    }
}