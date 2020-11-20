import java.util.Comparator;

public class Card implements Comparable<Card> {

    private MainGame.Rank rank;
    private MainGame.Suit suit;


    public Card(MainGame.Rank rank, MainGame.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public MainGame.Rank getRank() {
        return rank;
    }

    public MainGame.Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }

    // https://stackoverflow.com/questions/36919284/sorting-card-objects-inside-of-the-hand-object
    // this will help with evaluating straights, but not sure how to execute
    @Override
    public int compareTo(Card c) {
        if (this.rank.getCardValue() < c.rank.getCardValue()) {
            return -1;
        } else if (c.rank.getCardValue() < this.rank.getCardValue()) {
            return 1;
        }
        return 0;
    }
}

// https://stackoverflow.com/questions/4262029/can-an-object-have-multiple-compare-methods-for-ordering-based-on-different-valu
// https://www.geeksforgeeks.org/comparator-interface-java/

// comparator for sorting by suits
class SortBySuit implements Comparator<Card> {
    public int compare(Card a, Card b) {
        return a.getSuit().compareTo(b.getSuit());
    }
}

// comparator for sorting by card rank value
class SortByCardValue implements Comparator<Card> {
    public int compare(Card a, Card b) {
        return a.getRank().cardValue - b.getRank().cardValue;
    }
}


