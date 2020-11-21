import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


class PlayerTest {

    //@org.junit.jupiter.api.Test
    @Test
    void isFlush() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.SIX, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.SEVEN, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.QUEEN, MainGame.Suit.HEART));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isFlush(playerList.get(0).getHand()));
    }

    @Test
    void isStraight() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.THREE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.FOUR, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.FIVE, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isStraight(playerList.get(0).getHand()));
    }

    @Test
    void isFullHouse() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isFullHouse(playerList.get(0).getHand()));
    }

    @Test
    void isFourOfAKind() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isFourOfAKind(playerList.get(0).getHand()));
    }

    @Test
    void isThreeOfAKind() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isFourOfAKind(playerList.get(0).getHand()));
    }

    @Test
    void isTwoPair() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isTwoPair(playerList.get(0).getHand()));
    }

    @Test
    void isOnePair() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.FOUR, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.THREE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isOnePair(playerList.get(0).getHand()));
    }

    @Test
    void isHighCard() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.FOUR, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.THREE, MainGame.Suit.SPADE));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.CLUB));
        player.setHand(new Card(MainGame.Rank.QUEEN, MainGame.Suit.DIAMOND));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.CLUB));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isHighCard(playerList.get(0).getHand()));
    }

    @Test
    void isStraightFlush() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.FOUR, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.THREE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.TWO, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.FIVE, MainGame.Suit.HEART));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isStraightFlush(playerList.get(0).getHand()));
    }

    @Test
    void isRoyalFlush() {
        Player player = new Player();

        player.setHand(new Card(MainGame.Rank.QUEEN, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.JACK, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.TEN, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.KING, MainGame.Suit.HEART));
        player.setHand(new Card(MainGame.Rank.ACE, MainGame.Suit.HEART));

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertTrue(playerList.get(0).isRoyalFlush(playerList.get(0).getHand()));
    }
}