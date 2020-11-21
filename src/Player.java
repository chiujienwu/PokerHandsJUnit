import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Player instantiated to hold cards dealt to players
 * Contains class methods to check for winning hands
 *
 * */
public class Player {

    private List<Card> hand = new ArrayList<>();

    public Player() {
    }

    public Player(Card card) {

        this.hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }


    // winning hands methods
    // http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/pokerCheck.html
    public boolean isFlush(@NotNull List<Card> hand) {
        System.out.println("checking for flushes...");
//        Card[] cardsArray = new Card[hand.size()];
//        cardsArray = hand.toArray(cardsArray);

        // used Comparator Interface for sorting
        // https://www.geeksforgeeks.org/comparator-interface-java/
        Collections.sort(hand, new SortBySuit());

//        MainGame.Suit[] suitHand = new MainGame.Suit[hand.size()];

//        boolean sameSuit = true;

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        return (hand.size() == 5 && hand.get(0).getSuit() == hand.get(4).getSuit());
    }

    public boolean isStraight(@NotNull List<Card> hand) {
        System.out.println("checking for straights...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        // if the highest card is ace, if yes, check if other cards are (k,q,j,10) or (2,3,4,5)
        if (hand.get(4).getRank().cardValue == 14 && hand.size() == 5) {
            boolean conditionA =
                    hand.get(0).getRank().cardValue == 2 &&
                            hand.get(1).getRank().cardValue == 3 &&
                            hand.get(2).getRank().cardValue == 4 &&
                            hand.get(3).getRank().cardValue == 5;
            boolean conditionB =
                    hand.get(0).getRank().cardValue == 10 &&
                            hand.get(1).getRank().cardValue == 11 &&
                            hand.get(2).getRank().cardValue == 12 &&
                            hand.get(3).getRank().cardValue == 13;
            return (conditionA || conditionB);
        } else if (hand.size() == 5) {
            // check if cardvalues are consecutive
            int testRank = hand.get(0).getRank().cardValue + 1;

            for (int c = 1; c < hand.size(); c++) {
                if (hand.get(c).getRank().cardValue != testRank) {
                    return (false);  // did not pass the consecutive rank cardvalue condition
                }
                testRank++;
            }
            return (true);  // passed the consecutive rank cardvalue condition
        }
        return false;
    }

    public boolean isFullHouse (@NotNull List<Card> hand) {
        System.out.println("checking for fullhouse...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA, conditionB;

        if (hand.size() == 5) {
//            check for xxx-yy pattern
            conditionA =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;
//            check for xx-yyy pattern
            conditionB =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;

            return (conditionA || conditionB);
        }
        return false;
    }

    public boolean isFourOfAKind (@NotNull List<Card> hand) {
        System.out.println("checking for four of a kind...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA, conditionB;

        if (hand.size() == 5) {
//            check for xxxx-y pattern
            conditionA =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue;
//            check for x-yyyy pattern
            conditionB =
                    hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;

            return (conditionA || conditionB);
        }
        return false;
    }

    public boolean isThreeOfAKind (@NotNull List<Card> hand) {
        System.out.println("checking for three of a kind...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA, conditionB, conditionC;

        if (hand.size() == 5) {
//            check for xxx-y-z pattern
            conditionA =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;
//            check for x-yyy-z pattern
            conditionB =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;
//            check for x-y-zzz pattern
            conditionC =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;

            return (conditionA || conditionB || conditionC);
        }
        return false;
    }
    public boolean isTwoPair (@NotNull List<Card> hand) {
        System.out.println("checking for two pairs...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA, conditionB, conditionC;

        if (hand.size() == 5) {
//            check for xx-yy-z pattern
            conditionA =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;
//            check for xx-y-zz pattern
            conditionB =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;
//            check for x-yy-zz pattern
            conditionC =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;

            return (conditionA || conditionB || conditionC);
        }
        return false;
    }

    public boolean isOnePair (@NotNull List<Card> hand) {
        System.out.println("checking for one pair...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA, conditionB, conditionC, conditionD;

        if (hand.size() == 5) {
//            check for vv-x-y-z pattern
            conditionA =
                    hand.get(0).getRank().cardValue == hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;
//            check for v-xx-y-z pattern
            conditionB =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue == hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;
//            check for v-x-yy-z pattern
            conditionC =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue == hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;

//            check for v-x-y-zz pattern
            conditionD =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue == hand.get(4).getRank().cardValue;


            return (conditionA || conditionB || conditionC || conditionD);
        }
        return false;
    }

    public boolean isHighCard (@NotNull List<Card> hand) {
        System.out.println("checking for high card...");

        Collections.sort(hand, new SortByCardValue());

        for (int c = 0; c < hand.size(); c++) {

            System.out.print(hand.get(c).getRank());
            System.out.print("-");
            System.out.println(hand.get(c).getSuit());
        }

        boolean conditionA;

        if (hand.size() == 5) {
//            check for u-v-x-y-z pattern
            conditionA =
                    hand.get(0).getRank().cardValue != hand.get(1).getRank().cardValue &&
                            hand.get(1).getRank().cardValue != hand.get(2).getRank().cardValue &&
                            hand.get(2).getRank().cardValue != hand.get(3).getRank().cardValue &&
                            hand.get(3).getRank().cardValue != hand.get(4).getRank().cardValue;

            return (conditionA);
        }
        return false;
    }

    public boolean isStraightFlush (@NotNull List<Card> hand) {
        System.out.println("checking for straight flush...");

        boolean conditionA, conditionB;

        if (hand.size() == 5) {
//            check for both straight and flush conditions
            conditionA = isFlush(hand);
            conditionB = isStraight(hand);

            return (conditionA && conditionB);
        }
        return false;
    }

    public boolean isRoyalFlush (@NotNull List<Card> hand) {
        System.out.println("checking for royal flush...");

        boolean conditionA, conditionB, conditionC;

        if (hand.size() == 5) {
//            check for both straight flush and high card is an ace
            conditionA = isFlush(hand);
            conditionB = isStraight(hand);
            conditionC = hand.get(4).getRank().cardValue == 14;

            return (conditionA && conditionB && conditionC);
        }
        return false;
    }

}


