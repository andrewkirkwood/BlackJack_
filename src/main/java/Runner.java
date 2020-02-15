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

        Card thirdCard = game.getDealer().dealCard();
        game.getDealer().getHand().takeCard(thirdCard);


        Card fourthCard = game.getDealer().dealCard();
        game.getPlayerList().get(0).getHand().takeCard(fourthCard);
        String playerSecondCard = String.format("Player second card = %s", fourthCard.getFaceValue());
        System.out.println(playerSecondCard);

        String dealerSecondCard = String.format("Dealer second card = %s", thirdCard.getFaceValue());

        System.out.println("1 for twist or 0 for stick?");
        int instruction1 = parseInt(scanner.next());

        Card fifthCard = game.getDealer().dealCard();
        game.shouldPlayerTwistOrStick(game.getPlayerList().get(0), fifthCard, instruction1);

        if (game.getPlayerList().get(0).getHand().getCardsList().size() > 2){
            String thirdCardAnnouncement = String.format("Player third card = %s", fourthCard.getFaceValue());
            System.out.println(thirdCardAnnouncement);
        }

        System.out.println(dealerSecondCard);




//        game.shouldDealerTwistOrStick(fifthCard);

        String result = game.getWinner(game.getPlayerList().get(0), game.getDealer());

        System.out.println(result);

    }
}
