import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;

public class MainGame {

    public enum Suit {
        HEART,
        SPADE,
        DIAMOND,
        CLUB
    }

    public enum Rank {
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
        KING(13),
        ACE(14);

        // https://www.baeldung.com/java-enum-values
//        private static final Map<Integer, Rank> BY_CARD_VALUE = new HashMap<>();
//
//        static {
//            for (Rank r : values()) {
//                BY_CARD_VALUE.put(r.cardValue, r);
//            }
//        }

        public final int cardValue;

        // constructor
        private Rank(int cardValue) {
            this.cardValue = cardValue;
        }

//        public static Stream<Rank> stream() {
//            return Arrays.stream(Rank.values());
//        }

        protected int getCardValue(){
            return cardValue;
        }
    }

    public static void main(String[] args) {

        // setup
        int SUITS = Suit.values().length;
        int RANKS = Rank.values().length;
        int NUMOFCARDS = SUITS * RANKS;
        int hands = 0, game = 0;


        // user inputs
        do {

            Scanner userInput = new Scanner(System.in);

            System.out.println("Number of hands to deal?");
            try {
                hands = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            System.out.println("Number of cards per hand?  Note:  Winning hand methods only works with 5 cards at the moment.");
            try {
                game = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (hands * game > NUMOFCARDS) {
                System.out.println("Can't play this game with the number of hands!  Reduce hands or change game.");
            }
        } while (hands * game > NUMOFCARDS);

        // create a deck of cards
        // https://stackoverflow.com/questions/23329132/building-a-deck-of-cards-in-java-using-2-different-enums
        List<Card> cards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card nextCard = new Card(r, s);
                cards.add(nextCard);
            }
        }

        // shuffle deck of cards
        Collections.shuffle(cards);
        System.out.println(cards.toString());

        // deal deck of cards to players for a given game
        List<Player> playerList = new ArrayList<>();

//        System.out.println("Hands = " + hands);
//        System.out.println("Game = " + game);

        for (int p = 1; p < hands + 1; p++) {
//            System.out.println("first loop ran");
            Player player = new Player();
            playerList.add(player);
        }

//        Iterator playerListIterator = playerList.iterator();
//            while(playerListIterator.hasNext()) {
//
//            }

        for (int c = 1; c < game + 1; c++) {
//            System.out.println("second loop ran");
            playerList.forEach(player -> {
                Card nextCardInDeck = cards.get(0);
                player.setHand(nextCardInDeck);
                cards.remove(0);
            });
        }
        // check for winning hands
//        playerList.forEach(player -> {
//            System.out.println(player.isFourOfAKind(player.getHand()));
//            System.out.println(player.isFullHouse(player.getHand()));
//            System.out.println(player.isFlush(player.getHand()));
//            System.out.println(player.isStraight(player.getHand()));
//        });

        for (int p = 0; p < playerList.size(); p++) {
            System.out.println("Player " + (p+1) + playerList.get(p).getHand());
            System.out.println(playerList.get(p).isRoyalFlush(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isStraightFlush(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isFourOfAKind(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isFullHouse(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isFlush(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isStraight(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isThreeOfAKind(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isTwoPair(playerList.get(p).getHand()));
            System.out.println(playerList.get(p).isOnePair(playerList.get(p).getHand()));
        }

//        playerList.forEach(player -> {
//            System.out.println(player.getHand());
//        });

//        ** My Code Playground **
//        Using stream to print card values
//        Rank.stream()
//            .filter(v -> v.cardValue > 5)
//            .forEach(System.out::println);

    }


}

