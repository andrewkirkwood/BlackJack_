import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DealerTest {
    private Dealer dealer;
    private Card card;

    @Before
    public void before(){
        this.dealer = new Dealer();
        card = new Card(SuitType.HEARTS, FaceValueType.ACE);
    }
    /////
    @Test
    public void dealer_has_full_deck(){
        dealer.getDeck().populateDeck();
        assertEquals(52, dealer.getDeck().getCards().size());
    }

    @Test
    public void dealer_hand_starts_empty(){
        assertEquals(0, dealer.getHand().getCardsList().size());
        assertEquals(0, dealer.getHand().getValue());
    }

    @Test
    public void can_deal_a_card(){
        dealer.getDeck().populateDeck();
        dealer.shuffleDeck();
        dealer.dealCard();
        assertEquals(51, dealer.getDeck().getCards().size());
    }

    @Test
    public void can_take_a_card_into_hand(){
        dealer.takeCard(card);
        assertEquals(1, dealer.getHand().getCardsList().size());
    }
}
