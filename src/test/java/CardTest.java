import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, FaceValueType.ACE);
    }

    @Test
    public void card_has_correct_suit_and_value(){
        assertEquals(SuitType.HEARTS, card.getSuit());
        assertEquals(11, card.getFaceValue());
    }
}
