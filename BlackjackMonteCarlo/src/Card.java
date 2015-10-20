/**
 * Created by heshamsalman on 10/20/15.
 */

public class Card {

    private Rank rank;
    private Suit suit;

    Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}

enum Suit {
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠"),
    CLUBS("♠");

    private final String text;

    private Suit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    static int maxRank = 13;

    private String description;

    private Rank(int value) {
        switch (value) {
            case 1:
                description = "A";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                description = Integer.toString(value);
                break;
            case 11:
                description = "J";
                break;
            case 12:
                description = "Q";
                break;
            case 13:
                description = "K";
                break;
            default:
                description = null;
        }
    }

    @Override
    public String toString() {
        return description;
    }
}