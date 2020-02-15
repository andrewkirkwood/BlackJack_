import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Player player = new Player();

        game.addPlayer(player);
        System.out.println("player added");
        game.getDealer().getDeck().populateDeck();
        game.getDealer().getDeck().shuffleDeck();

        Card firstCard = game.getDealer().dealCard();
        game.getDealer().getHand().takeCard(firstCard);
        String firstCardResult = String.format("Dealer first card = %s", firstCard.getFaceValue());
        System.out.println(firstCardResult);

        Card secondCard = game.getDealer().dealCard();
        game.getPlayerList().get(0).getHand().takeCard(secondCard);
        String playerFirstCard = String.format("Player first card = %s", secondCard.getFaceValue());
        System.out.println(playerFirstCard);

        game.getDealer().getHand().takeCard(game.getDealer().dealCard());

        Card fourthCard = game.getDealer().dealCard();
        game.getPlayerList().get(0).getHand().takeCard(fourthCard);
        String playerSecondCard = String.format("Player hand total = %s", game.getPlayerList().get(0).getHand().getValue());
        System.out.println(playerSecondCard);
        System.out.println();

        System.out.println("1 for twist or 0 for stick?");
        int instruction1 = parseInt(scanner.next());
        Card fifthCard = game.getDealer().dealCard();
        game.shouldPlayerTwistOrStick(game.getPlayerList().get(0), fifthCard, instruction1);

        if (game.getPlayerList().get(0).getHand().getCardsList().size() > 2){
            System.out.println(String.format("player hand total = %s", game.getPlayerList().get(0).getHand().getValue()));
            System.out.println(String.format("player is : %s", game.playerResult(game.getPlayerList().get(0))));
            if (game.playerResult(game.getPlayerList().get(0)) == "BUST"){
                System.out.println(game.getWinner(game.getPlayerList().get(0), game.getDealer()));
            }
            else {
                System.out.println("1 for twist or 0 for stick?");
                int instruction2 = parseInt(scanner.next());

                Card sixthCard = game.getDealer().dealCard();
                game.shouldPlayerTwistOrStick(game.getPlayerList().get(0), sixthCard, instruction2);
                System.out.println(String.format("player hand total = %s", game.getPlayerList().get(0).getHand().getValue()));
                System.out.println(String.format("player is : %s", game.playerResult(game.getPlayerList().get(0))));

                if (game.playerResult(game.getPlayerList().get(0)) == "BUST"){
                    System.out.println(game.getWinner(game.getPlayerList().get(0), game.getDealer()));
                }
                else if (instruction2 == 1){
                    System.out.println(String.format("player is : %s", game.playerResult(game.getPlayerList().get(0))));
                    game.getPlayerList().get(0).getHand().takeCard(game.getDealer().dealCard());

                }
            }



        }

        else if (game.getPlayerList().get(0).getHand().getCardsList().size() == 2 || game.playerResult(game.getPlayerList().get(0)) == "BUST"){
            String result = game.getWinner(game.getPlayerList().get(0), game.getDealer());
            System.out.println(result);
        }


    }
}
