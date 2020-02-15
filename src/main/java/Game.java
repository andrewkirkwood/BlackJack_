import java.util.ArrayList;
import java.util.BitSet;

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

}
