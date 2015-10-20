import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 */

abstract class Deck {
    List<Card> cards;

    @Override
    public String toString() {
        return "Deck of " + cards.size() + " cards";
    }
}

public class CardDeck extends  Deck {
    CardDeck() {
        cards = new ArrayList<>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
    }
}

