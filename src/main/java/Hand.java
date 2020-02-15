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
        int dumbValue = 0;
        for (Card card : this.cards){
            dumbValue += card.getFaceValue();
        }
        if (getNormalCardValue() > 2 && getNormalCardValue() < 19){
            int deduction = 0;
            for (Card card : getAceList()){
                deduction += 10;
            }
            if (getNormalCardValue() <= 9){
                deduction -= 10;
            }
            dumbValue -= deduction;
        }
//        if (getAceList().size() == 1 && getNormalCardValue() < 10)

        else
        {
            int deductionFor2Aces = 0;
            for(Card card : getAceList()){
                deductionFor2Aces += 10;
            }
            deductionFor2Aces -= 10;
            dumbValue -= deductionFor2Aces;
        }

        return dumbValue;
    }

    public ArrayList<Card> getCardsList() {
        return this.cards;
    }

    public void takeCard(Card card) {
        if (card.getFaceValue() == 11){
            this.aceList.add(card);
//            if (aceList.size() == 1 && getValue() < 18 && getValue() > 1){
//                int deduction = 0;
//                for (Card i : getAceList()){
//                    deduction += 10;
//                }
//                this.aceDeduction += deduction;
//            }
//            this.cards.add(card);
        }
        else if (card.getFaceValue() != 11){
            this.temporaryNormalCards.add(card);
        }
        this.cards.add(card);

    }

    public ArrayList<Card> getAceList(){
        return this.aceList;
    }

    public int getNormalCardValue(){
        int value = 0;
        for (Card card : this.temporaryNormalCards){
            value += card.getFaceValue();
        }
        return value;
    }

}

