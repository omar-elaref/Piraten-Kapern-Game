package pk;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game {
    //2 Players play the game

    public int[] game(int plays, String playerOne, String playerTwo) {
        Logger log = LogManager.getRootLogger();
        Strategy firstStrategy = new Strategy();
        Player player1 = new Player();
        Player player2 = new Player();

        Deck cards = new Deck();

        cards.deckContents();

        cards.shuffle();




        int player1Wins = 0;
        int player2Wins = 0;

        int round = 0;

        if (playerOne.equals("random")){
            log.trace("Player 1 random");
            System.out.println("Player 1 random");
        }else{
            log.trace("Player 1 is combo");
            System.out.println("Player 1 is combo");
        }

        if (playerTwo.equals("random")){
            log.trace("Player 2 is random");
            System.out.println("Player 2 random");
        }else{
            log.trace("Player 2 is combo");
            System.out.println("Player 2 is combo");
        }


        int ties = 0;

        while (round < plays) {
            //System.out.println();
            Card cardDrawn1 = cards.drawCard();


            Card cardDrawn2 = cards.drawCard();


            //System.out.println("ROUND " + (round + 1));
            log.trace("ROUND: " + (round +1 ) + "\n");

            //System.out.println("Player 1 turn:");
            log.trace("Player 1 turn");
            log.trace("The card drawn is : " + cardDrawn1.getName() + " " + cardDrawn1.getSabers());
            //System.out.println("The card drawn is : " + cardDrawn1.getName() + " " + cardDrawn1.getSabers());

            int roundPointsP1 = 0;
            int roundPointsP2 = 0;



            if (cardDrawn1.getName() == "Saber"){
                roundPointsP1 = player1.points(firstStrategy.saberStrategy(cardDrawn1),player1,cardDrawn1 );
            }else {

                if (playerOne.equals("random")) {
                    roundPointsP1 = player1.points(firstStrategy.randomStrategy(), player1, cardDrawn1);
                    player1.totalPoints += roundPointsP1;
                } else if (playerOne.equals("combo")) {
                    roundPointsP1 = player1.points(firstStrategy.comboStrategy(cardDrawn1), player1, cardDrawn1);
                    player1.totalPoints += roundPointsP1;
                }
            }

            log.trace("Player 1 total points: " + player1.totalPoints + "\n");





            if (player2.totalPoints >= 6000){
                break;
            }

            //System.out.println("Player 2 turn:");
            log.trace("Player 2 Turn");
            log.trace("The card drawn is: " + cardDrawn2.getName() + " " + cardDrawn2.getSabers());
            //System.out.println("The card drawn is: " + cardDrawn2.getName() + " " + cardDrawn2.getSabers());

            if (cardDrawn2.getName() == "Saber"){
                roundPointsP2 = player2.points(firstStrategy.saberStrategy(cardDrawn2), player2, cardDrawn2 );
            }else {

                if (playerTwo.equals("random")) {
                    roundPointsP2 = player2.points(firstStrategy.randomStrategy(), player2, cardDrawn2);
                    player2.totalPoints += roundPointsP2;
                } else if (playerTwo.equals("combo")) {
                    roundPointsP2 = player2.points(firstStrategy.comboStrategy(cardDrawn2), player2, cardDrawn2);
                    player2.totalPoints += roundPointsP2;

                }
            }


            log.trace("Player 2 total points: " + player2.totalPoints);


            if (roundPointsP2 == roundPointsP1){
                ties++;
                log.trace("It is a ties this round");
            }else if (roundPointsP2 > roundPointsP1){
                player2Wins++;
                log.trace("Player 2 wins this round");
            }else if (roundPointsP2 < roundPointsP1){
                player1Wins++;
                log.trace("Player 1 wins this round");
            }

            if (player1.totalPoints >= 6000){
                break;
            }






            round++;
        }

        System.out.println();
        System.out.println("Player 1 total points: " + player1.totalPoints + "\n");
        System.out.println("Player 2 total points: " + player2.totalPoints + "\n");



        if (player1.totalPoints < player2.totalPoints){
            System.out.println("Player 2 wins!");
            log.trace("Player 2 wins!");
        }else if (player1.totalPoints > player2.totalPoints){
            System.out.println("Player 1 wins!");
            log.trace("Player 1 wins!");
        }

        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);

        if (ties < 0){
            ties = 0;
        }
        System.out.println("Ties: " + ties);

        log.trace("Total player 1 wins: " + player1Wins);
        log.trace("Total player 2 wins: " + player2Wins);
        log.trace("Ties: " + ties);

        log.info("Total player 1 wins: " + player1Wins);
        log.info("Total player 2 wins: " + player2Wins);
        log.info("Ties: " + ties);

        double player1WinPercentage = (((double) player1Wins)/(((double)round)+1)) * 100;
        double player2WinPercentage = (((double) player2Wins)/(((double)round)+1)) * 100;
        String roundedWin1 = String.format("%.2f",player1WinPercentage);
        String roundedWin2 = String.format("%.2f",player2WinPercentage);



        System.out.println("Player 1 win percentage: " + roundedWin1);
        System.out.println("Player 2 win percentage: " + roundedWin2);


        log.info("Player 1 win percentage: " +  roundedWin1);
        log.info("Player 2 win percentage: " + roundedWin2 + "\n");
        return new int[] {player1Wins, player2Wins};
    }
}
