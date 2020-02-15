import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Dealer dealer;

    public Game(){
        this.players = new ArrayList<Player>();
        this.dealer = new Dealer();
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public ArrayList<Player> getPlayerList() {
        return this.players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }


    public String playerResult(Player player) {
        if (player.getHand().getValue() > 21){
            return "BUST";
        }
        else if (player.getHand().getValue() < 21){
            return "STILL IN THE GAME";
        }
        else {
            return "ERROR";
        }
    }

    public String getWinner(Player player, Dealer dealer) {
        if (player.getHand().getValue() > dealer.getHand().getValue() && player.getHand().getValue() <= 21){
            return "PLAYER WINS";
        }
        else if (dealer.getHand().getValue() > player.getHand().getValue() && dealer.getHand().getValue() <= 21){
            return "DEALER WINS";
        }

        else {
            return "ERROR";
        }
    }

    public void shouldDealerTwistOrStick(Card card) {
        if (getDealer().getHand().getValue() < 16) {
            getDealer().getHand().takeCard(card);
        }
        else if (getDealer().getHand().getValue() >= 16){
            return;
        }
    }

    public void shouldPlayerTwistOrStick(Player player, Card card, int instruction) {
        if (instruction == 0){
            return;
        }
        else if(instruction == 1){
            this.getPlayerList().get(0).getHand().takeCard(card);
        }
    }
}
