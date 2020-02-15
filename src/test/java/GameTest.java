import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;
    private Player player1;


    @Before
    public void before(){
        game = new Game();
        player1 = new Player();
    }

//    @Test
//    public void game_has_a_dealer(){
//        assertEquals(true , game.getDealer());
//    }

    @Test
    public void game_starts_with_no_players(){
        assertEquals(0, game.getPlayerList().size());
    }

    @Test
    public void game_can_add_a_player(){
        game.addPlayer(player1);
        assertEquals(1, game.getPlayerList().size());
    }

    @Test
    public void dealer_can_deal_card_to_player(){
        game.getDealer().getDeck().populateDeck();
        game.getDealer().getDeck().shuffleDeck();
        Card card1 = game.getDealer().dealCard();
        game.addPlayer(player1);
        game.getPlayerList().get(0).getHand().takeCard(card1);
        assertEquals(51, game.getDealer().getDeck().getCards().size());
        assertEquals(1, game.getPlayerList().get(0).getHand().getCardsList().size());
        assertEquals(card1, game.getPlayerList().get(0).getHand().getCardsList().get(0));
    }

    @Test
    public void dealer_can_deal_card_to_self(){
        game.getDealer().getDeck().populateDeck();
        game.getDealer().getDeck().shuffleDeck();
        Card card1 = game.getDealer().dealCard();
        game.addPlayer(player1);
        game.getPlayerList().get(0).getHand().takeCard(card1);
        assertEquals(51, game.getDealer().getDeck().getCards().size());
        assertEquals(1, game.getPlayerList().get(0).getHand().getCardsList().size());
        assertEquals(card1, game.getPlayerList().get(0).getHand().getCardsList().get(0));
    }

    @Test
    public void player_can_go_BUST(){
        Card cardTen = new Card(SuitType.SPADES, FaceValueType.TEN);
        Card cardTwo = new Card(SuitType.SPADES, FaceValueType.TWO);
        Card cardQueen = new Card(SuitType.CLUBS, FaceValueType.QUEEN);
        game.addPlayer(player1);
        game.getPlayerList().get(0).takeACard(cardTen);
        game.getPlayerList().get(0).takeACard(cardTwo);
        game.getPlayerList().get(0).takeACard(cardQueen);
        assertEquals(22, game.getPlayerList().get(0).getHand().getValue());
        assertEquals("BUST", game.playerResult(player1));
    }

    @Test
    public void determine_winner_is_player(){
        Card cardTen = new Card(SuitType.SPADES, FaceValueType.TEN);
        Card cardTwo = new Card(SuitType.SPADES, FaceValueType.TWO);
        Card cardNine = new Card(SuitType.CLUBS, FaceValueType.NINE);
        game.addPlayer(player1);
        game.getPlayerList().get(0).takeACard(cardTen);
        game.getPlayerList().get(0).takeACard(cardTwo);
        game.getPlayerList().get(0).takeACard(cardNine);

        Card cardEight = new Card(SuitType.HEARTS, FaceValueType.EIGHT);
        Card cardThree = new Card(SuitType.CLUBS, FaceValueType.THREE);
        game.getDealer().takeCard(cardEight);
        game.getDealer().takeCard(cardEight);
        assertEquals("PLAYER WINS", game.getWinner(game.getPlayerList().get(0), game.getDealer()));
    }

    @Test
    public void determine_winner_is_dealer(){
        Card cardTen = new Card(SuitType.SPADES, FaceValueType.TEN);
        Card cardTwo = new Card(SuitType.SPADES, FaceValueType.TWO);
        Card cardSeven = new Card(SuitType.CLUBS, FaceValueType.SEVEN);
        game.addPlayer(player1);
        game.getPlayerList().get(0).takeACard(cardTen);
        game.getPlayerList().get(0).takeACard(cardTwo);
        game.getPlayerList().get(0).takeACard(cardSeven);

        Card cardJack = new Card(SuitType.HEARTS, FaceValueType.JACK);
        Card cardQueen= new Card(SuitType.CLUBS, FaceValueType.QUEEN);
        game.getDealer().takeCard(cardJack);
        game.getDealer().takeCard(cardQueen);

        assertEquals("DEALER WINS", game.getWinner(game.getPlayerList().get(0), game.getDealer()));
    }

    @Test
    public void dealer_twists_when_value_below_16(){
        Card cardJack = new Card(SuitType.HEARTS, FaceValueType.JACK);
        Card cardFive= new Card(SuitType.CLUBS, FaceValueType.FIVE);
        game.getDealer().takeCard(cardJack);
        game.getDealer().takeCard(cardFive);

        Card thirdCard = new Card(SuitType.SPADES, FaceValueType.SEVEN);
        game.shouldDealerTwistOrStick(thirdCard);
        assertEquals(3, game.getDealer().getHand().getCardsList().size());
    }

    @Test
    public void dealer_stick_when_hand_value_above_16(){
        Card cardJack = new Card(SuitType.HEARTS, FaceValueType.JACK);
        Card cardSix= new Card(SuitType.CLUBS, FaceValueType.SIX);
        game.getDealer().takeCard(cardJack);
        game.getDealer().takeCard(cardSix);

        Card thirdCard = new Card(SuitType.SPADES, FaceValueType.SEVEN);
        game.shouldDealerTwistOrStick(thirdCard);
        assertEquals(2, game.getDealer().getHand().getCardsList().size());
    }

    @Test public void player_can_stick_with_hand(){
        Card cardTen = new Card(SuitType.SPADES, FaceValueType.TEN);
        Card cardTwo = new Card(SuitType.SPADES, FaceValueType.TWO);
        Card cardSeven = new Card(SuitType.CLUBS, FaceValueType.SEVEN);
        game.addPlayer(player1);
        game.getPlayerList().get(0).takeACard(cardTen);
        game.getPlayerList().get(0).takeACard(cardTwo);
        game.shouldPlayerTwistOrStick(game.getPlayerList().get(0), cardSeven, 0);
        assertEquals(2, game.getPlayerList().get(0).getHand().getCardsList().size());
    }

    @Test public void player_can_twist_with_hand(){
        Card cardTen = new Card(SuitType.SPADES, FaceValueType.TEN);
        Card cardTwo = new Card(SuitType.SPADES, FaceValueType.TWO);
        Card cardSeven = new Card(SuitType.CLUBS, FaceValueType.SEVEN);
        game.addPlayer(player1);
        game.getPlayerList().get(0).takeACard(cardTen);
        game.getPlayerList().get(0).takeACard(cardTwo);
        game.shouldPlayerTwistOrStick(game.getPlayerList().get(0), cardSeven, 1);
        assertEquals(3, game.getPlayerList().get(0).getHand().getCardsList().size());
    }


}
