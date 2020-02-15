import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;
    private Card card;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.HEARTS, FaceValueType.ACE);
    }

    @Test
    public void deck_starts_empty(){
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void can_add_single_card_to_deck(){
        deck.addCard(card);
        assertEquals(1, deck.getCards().size());
    }

    @Test
    public void populate_full_deck(){
        deck.populateDeck();
        assertEquals(52, deck.getCards().size());
    }

//    @Test
//    public void can_deal_a_card(){
//        deck.populateDeck();
//        deck.shuffleDeck();
//        deck.dealCard();
//        assertEquals(51, deck.getCards().size());
//    }

}
