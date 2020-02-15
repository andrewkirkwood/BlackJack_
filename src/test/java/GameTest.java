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
}
