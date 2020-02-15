import java.util.ArrayList;

public class Player {
    private Hand hand;

    public Player(){
        this.hand = new Hand();
    }

//    public void takeACard(Card card){
//        this.card = card;
//    }
//
//    public Card giveBackCard(){
//        Card cardycard = this.card;
//        this.card = null;
//        return cardycard;
//    }
//
//    public int getCardValue(){
//        return this.card.getFaceValue();
//    }

    public Hand getHand() {
        return this.hand;
    }
}
