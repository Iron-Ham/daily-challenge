/**
 * Created by heshamsalman on 10/20/15.
 */
public class Blackjack {
    Deck cards;

    Blackjack() {
        cards = new CardDeck();
    }

    PlayResult playGame() {
        PlayResult result = PlayResult.NONE;

        // Game loop
        while (result == PlayResult.NONE) {
            //TODO: Game Logic
        }

        return result;
    }
}

enum PlayResult {
    NONE(0),
    WIN(1),
    DRAW(2),
    LOSE(3);

    private String description;

    private PlayResult(int value) {
        switch (value) {
            case 0:
                description = "Error -- No Result Recorded!";
                break;
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