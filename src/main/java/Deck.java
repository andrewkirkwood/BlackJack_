import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
    }

    public Deck(ArrayList<Card> cards){
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void populateDeck() {
        SuitType suits[] = SuitType.values();
        FaceValueType faceValues[] = FaceValueType.values();
        for (SuitType suit : suits){
            for (FaceValueType faceValue : faceValues){
                Card card = new Card(suit, faceValue);
                this.cards.add(card);
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(){
        Card dealtCard = this.cards.remove(0);
        return dealtCard;
    }

}
