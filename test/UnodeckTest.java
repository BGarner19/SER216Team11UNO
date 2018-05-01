import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class UnodeckTest {

    Unodeck deck;

    @Before
    public void setUp() {
        deck = new Unodeck();
        deck.fillDeck();
    }

    @After
    public void tearDown() {
        deck = null;
    }

    @Test
    public void testCreation() {
        assertTrue(deck.deck != null);
    }

    @Test
    public void testFillDeck() {
        Unodeck newDeck = new Unodeck();

        newDeck.fillDeck();

        assertEquals(74, newDeck.deckSize);
        assertNotNull(newDeck.deck[73]);

    }

    @Test
    public void testShuffle() {

        Unodeck newDeck = new Unodeck();
        newDeck.fillDeck();
        deck.shuffleDeck();

        assertFalse(Arrays.equals(newDeck.deck, deck.deck));
    }

    @Test
    public void testPushEmpty() {
        Unocard card = new Unocard();
        Unodeck newDeck = new Unodeck();

        newDeck.pushCard(card);

        assertEquals(newDeck.deck[0], card);

    }

    @Test
    public void testPushFull() {
        Unocard card = new Unocard();

        assertFalse(deck.pushCard(card));
    }

    @Test
    public void testPop() {

        assertEquals(deck.popCard(), deck.deck[73]);
        assertEquals(73, deck.deckSize);
    }

    @Test
    public void testPeekFull() {
        assertEquals(deck.peekCard(), deck.deck[73]);
        assertEquals(74, deck.deckSize);
    }

    @Test
    public void testPeekEmpty() {
        Unodeck unodeck = new Unodeck();

        assertNull(unodeck.peekCard());
    }

    @Test
    public void testDisplayDeck() {
        deck.displayDeck();
    }

    @Test
    public void testPeek() {
        Unodeck unodeck = new Unodeck();
        Unocard card1 = new Unocard();
        Unocard card2 = new Unocard();

        unodeck.deck[0] = card1;
        unodeck.deck[1] = card2;

        unodeck.deckSize = 2;

        assertEquals(unodeck.peekCard(), card2);
    }
}