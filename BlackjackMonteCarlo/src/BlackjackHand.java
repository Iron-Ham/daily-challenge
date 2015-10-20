import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 */
abstract class BlackjackHand {
    protected List<Card> cards;
    protected int value;
    boolean isPlaying;

    protected int evaluateHandValue(List<Card> cards) {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            switch (card.getRank()) {
                case ACE:
                    // Deal with aces after the value for remaining cards has been determined.
                    aceCount++;
                    break;
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                    value += 10;
                    break;
                case JACK:
                    value += 10;
                    break;
                case QUEEN:
                    value += 10;
                    break;
                case KING:
                    value += 10;
                    break;
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
        if (value > 21) {
            isPlaying = false;
        }
        return value;
    }

    public int stand() {
        isPlaying = false;
        return value;
    }

    public int getValue() {
        return value;
    }

    public void hit(Card card) {
        cards.add(card);
        this.value = evaluateHandValue(cards);
    }
}


class DealerHand extends BlackjackHand {
    DealerHand() {
        cards = new ArrayList<>();
        value = 0;
        isPlaying = true;
    }

    /**
     * Dealer has one face-down card
     * @return value of visible cards
     */
    @Override
    public int getValue() {
        List<Card> visibleCards = cards;
        visibleCards.remove(0);
        int value = evaluateHandValue(visibleCards);
        return value;
    }

    /**
     * Dealer must stand at 17 or higher
     * @param card the card to be put into the hand
     */
    @Override
    public void hit(Card card) {
        super.hit(card);
        if (this.value >= 17) {
            stand();
        }
    }
}

class PlayerHand extends BlackjackHand {
    PlayerHand() {
        cards = new ArrayList<>();
        value = 0;
        isPlaying = true;
    }

    /**
     * Player must stand at 20 or higher
     * @param card the card to be put into the hand
     */
    @Override
    public void hit(Card card) {
        super.hit(card);
        if (this.value >= 20) {
            stand();
        }
    }
}