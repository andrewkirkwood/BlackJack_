import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
    private Deck deck;
    private Hand hand;

    public Dealer(){
        this.deck = new Deck();
        this.hand = new Hand();
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Hand getHand() {
        return this.hand;
    }


    public void shuffleDeck(){
        Collections.shuffle(this.deck.getCards());
    }

    public Card dealCard(){
        Card dealtCard = this.deck.getCards().remove(0);
        return dealtCard;
    }

    public void takeCard(Card card) {
        this.hand.getCardsList().add(card);
    }
}

