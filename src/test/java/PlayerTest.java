import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player();
        card = new Card(SuitType.HEARTS, FaceValueType.ACE);
    }


    @Test
    public void starts_with_empty_hand(){
        assertEquals(0, player.getHand().getCardsList().size());
    }
//
    @Test
    public void can_take_a_card(){
        player.takeACard(card);
        assertEquals(card, player.getHand().getCardsList().get(0));
    }
//
//    @Test
//    public void can_give_back_card(){
//        player.takeACard(card);
//        assertEquals(card, player.giveBackCard());
//    }
//
//    @Test
//    public void can_get_card_value_back(){
//        player.takeACard(card);
//        assertEquals(3, player.getCardValue());
//    }
}
