import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    }

    @Test
    public void testCreation() {
        
    }

}