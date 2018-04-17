import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Unodeck deck;

    @Before
    public void setUp() {

        deck = new Unodeck();
        deck.fillDeck();
        deck.shuffleDeck();
        player = new Player(deck);

    }

    @After
    public void tearDown() {
        player = null;
        Player.playerNum--;

    }

    @Test
    public void testCreation() {

        assertTrue(Player.playerNum == 1);
        assertTrue(player.getName().equals("Player1"));
        assertTrue(player.getHandSize() == 5);

    }

    @Test
    public void testDisplayHand() {

        player.displayHand();
    }

    @Test
    public void testGetCardsInHand() {
        assertTrue(player.getCardsInHand().length == 5);
        assertTrue(player.getCardsInHand() != null);
    }

    @Test
    public void testSendCardsInHand() {
        String[] cards = {"blue,1", "red,3", "yellow,reverse"};

        assertTrue(player.sendCardsInHand(cards).equals("blue,1:red,3:yellow,reverse:"));
    }

    @Test
    public void testUpdateHandAfterPlay() {
        player.updateHandAfterPlay(0);

        assertTrue(player.getHandSize() == 4);

    }

    @Test
    public void testUpdateHandAfterDraw() {
        Unocard card = new Unocard();

        player.updateHandAfterDraw(card);

        assertTrue(player.getHandSize() == 6);
        assertTrue(player.getCardsInHand()[5].equals("black,-1"));
    }

    @Test
    public void testUpdateHandAfterDrawFull() {
        Unocard card = new Unocard();


    }

}