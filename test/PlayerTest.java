import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {

        Unodeck deck = new Unodeck();
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

        assertEquals(1, Player.playerNum);
        assertEquals("Player1", player.getName());
        assertEquals(5, player.getHandSize());

    }

    @Test
    public void testDisplayHand() {

        player.displayHand();
    }

    @Test
    public void testGetCardsInHand() {
        assertEquals(5, player.getCardsInHand().length);
        assertNotNull(player.getCardsInHand());
    }

    @Test
    public void testSendCardsInHand() {
        String[] cards = {"blue,1", "red,3", "yellow,reverse"};

        assertEquals("blue,1:red,3:yellow,reverse:", player.sendCardsInHand
            (cards));
    }

    @Test
    public void testUpdateHandAfterPlay() {
        player.updateHandAfterPlay(0);

        assertEquals(4, player.getHandSize());

    }

    @Test
    public void testUpdateHandAfterDraw() {
        Unocard card = new Unocard();

        player.updateHandAfterDraw(card);

        assertEquals(6, player.getHandSize());
        assertEquals("black,-1", player.getCardsInHand()[5]);
    }

    @Test
    public void testUpdateHandAfterDrawFull() {
        Unocard card = new Unocard();


    }

}