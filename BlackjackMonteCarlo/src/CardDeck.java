import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by heshamsalman on 10/20/15.
 */

abstract class Deck {
    List<Card> cards;
    Random r;

    @Override
    public String toString() {
        return "Deck of " + cards.size() + " cards";
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        int randIndex = r.nextInt(cards.size());
        Card c = cards.remove(randIndex);

        return c;
    }
}

public class CardDeck extends  Deck {
    CardDeck() {
        cards = new ArrayList<>();
        r = new Random();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
    }
}

