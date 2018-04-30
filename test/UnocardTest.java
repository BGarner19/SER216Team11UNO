import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnocardTest {

    Unocard card;

    @Before
    public void setUp() {
        card = new Unocard();
    }

    @After
    public void tearDown() {
        card = null;
    }

    @Test
    public void testGeneralConstructor() {
        assertTrue(card.getColor().equals("black"));
        assertTrue(card.getAction().equals("default"));
        assertTrue(card.getValue() == -1);
    }

    @Test
    public void testGettersAndSetters() {
        card.setAction("reverse");
        card.setColor("blue");
        card.setValue(6);

        assertTrue(card.getAction().equals("reverse"));
        assertTrue(card.getColor().equals("blue"));
        assertTrue(card.getValue() == 6);
    }

    @Test
    public void testToStringNumberCard() {

        assertEquals("black,-1", card.toString());
    }

    @Test
    public void testToStringActionCard() {
        card.setAction("reverse");
        card.setValue(6);
        card.setColor("blue");

        assertEquals("blue,reverse", card.toString());
    }

    @Test
    public void testDisplayCard() {
        card.displayCard();
    }


}