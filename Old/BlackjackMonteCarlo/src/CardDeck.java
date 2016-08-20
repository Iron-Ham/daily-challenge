import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 *
 * A Deck is a collection of cards. A CardDeck is an implementation of Card, wherein one card of each rank and suit
 * is present.
 */

abstract class Deck {
    List<Card> cards;

    @Override
    public String toString() {
        return "Deck of " + cards.size() + " cards";
    }

    void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() > 0) {
            return cards.remove(0);
        }
        return null;
    }
}

class CardDeck extends Deck {
    CardDeck() {
        cards = new ArrayList<>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
        shuffle();
    }
}

