import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    private Hand hand;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private Card card7;

    @Before
    public void before(){
        hand = new Hand();
        card1 = new Card(SuitType.HEARTS, FaceValueType.ACE);
        card2 = new Card(SuitType.HEARTS, FaceValueType.FOUR);
        card3 = new Card(SuitType.CLUBS , FaceValueType.ACE);
        card4 = new Card(SuitType.DIAMONDS , FaceValueType.ACE);
        card5 = new Card(SuitType.DIAMONDS , FaceValueType.TEN);
        card6 = new Card(SuitType.SPADES , FaceValueType.EIGHT);
        card7 = new Card(SuitType.SPADES , FaceValueType.NINE);

    }

    @Test
    public void hand_size_starts_empty(){
        assertEquals(0, hand.getCardsList().size());
    }

    @Test
    public void hand_value_starts_at_0_points(){
        assertEquals(0,hand.getCardsList().size());
    }

    @Test
    public void hand_can_take_in_single_card(){
        hand.takeCard(card1);
        assertEquals(true, hand.getCardsList().contains(card1));
        assertEquals(1, hand.getCardsList().size());
        assertEquals(11, hand.getValue());
    }

    @Test
    public void hand_can_take_in_multiple_cards(){
        hand.takeCard(card1);
        hand.takeCard(card2);
        assertEquals(true, hand.getCardsList().contains(card1));
        assertEquals(true, hand.getCardsList().contains(card2));
        assertEquals(2, hand.getCardsList().size());
        assertEquals(15, hand.getValue());
    }

    @Test
    public void hand_can_take_2_aces(){
        hand.takeCard(card1);
        hand.takeCard(card3);
        assertEquals(12, hand.getValue());
        assertEquals(0, hand.getNormalCardValue());
    }

    @Test
    public void hand_can_take_EIGHT_TEN_ACE_ACE_ACE(){
        hand.takeCard(card1);
        hand.takeCard(card3);
        hand.takeCard(card4);
        hand.takeCard(card5);
        hand.takeCard(card6);
        assertEquals(21, hand.getValue());
    }

    @Test
    public void hand_can_take_ACE_ACE_TWO(){
        Card twoCard = new Card(SuitType.SPADES, FaceValueType.TWO);
        hand.takeCard(card1);
        hand.takeCard(card3);
        hand.takeCard(twoCard);
        assertEquals(14, hand.getValue());
    }


    @Test
    public void hand_can_take_take_ACE_ACE_SEVEN(){
        Card sevenCard = new Card(SuitType.SPADES, FaceValueType.SEVEN);
        hand.takeCard(card1);
        hand.takeCard(card3);
        hand.takeCard(sevenCard);
        assertEquals(19, hand.getValue());
    }

    @Test
    public void hand_can_take_take_ACE_ACE_EIGHT(){
        Card eightCard = new Card(SuitType.SPADES, FaceValueType.EIGHT);
        hand.takeCard(card1);
        hand.takeCard(card3);
        hand.takeCard(eightCard);
        assertEquals(20, hand.getValue());
    }

    @Test
    public void hand_can_take_ACE_ACE_NINE(){
        hand.takeCard(card1);
        hand.takeCard(card3);
        hand.takeCard(card7);
        assertEquals(21, hand.getValue());
    }
}
