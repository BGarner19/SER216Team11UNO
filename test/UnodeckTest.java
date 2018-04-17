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

        assertTrue(newDeck.deckSize == 74);
        assertTrue(newDeck.deck[73] != null);

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

        assertTrue(newDeck.deck[0].equals(card));

    }

    @Test
    public void testPushFull() {
        Unocard card = new Unocard();

        assertFalse(deck.pushCard(card));
    }

    @Test
    public void testPop() {

        assertTrue(deck.popCard().equals(deck.deck[73]));
        assertTrue(deck.deckSize == 73);
    }

    @Test
    public void testPeekFull() {
        assertTrue(deck.peekCard().equals(deck.deck[73]));
        assertTrue(deck.deckSize == 74);
    }

    @Test
    public void testPeekEmpty() {
        Unodeck unodeck = new Unodeck();

        assertTrue(unodeck.peekCard() == null);
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

        assertTrue(unodeck.peekCard().equals(card2));
    }
}