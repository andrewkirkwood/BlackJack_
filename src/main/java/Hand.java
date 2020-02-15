import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private ArrayList<Card> aceList;
    private ArrayList<Card> temporaryNormalCards;
    private int aceDeduction;

    public Hand(){
        this.cards = new ArrayList<Card>();
        this.aceList = new ArrayList<Card>();
        this.aceDeduction = 0;
        this.temporaryNormalCards = new ArrayList<Card>();
    }

    public int getValue() {
        int count = 0;
        for (Card card : this.cards){
            count += card.getFaceValue();
        }
        if (this.aceList.size() > 2){
            this.aceDeduction = 0;
        }
        return count - this.aceDeduction;
    }

    public ArrayList<Card> getCardsList() {
        return this.cards;
    }

    public void takeCard(Card card) {
        if (card.getFaceValue() == 11){
            this.aceList.add(card);
            if (aceList.size() == 1){
                this.aceDeduction += 10;
            }
            this.cards.add(card);
        }
        else if (card.getFaceValue() != 11){
            this.cards.add(card);
            this.temporaryNormalCards.add(card);
        }
    }
}

