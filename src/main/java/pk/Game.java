package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        //cards.addCard(new SeaBattle("Saber",300,2));
        cards.shuffle();
        Card saber = cards.drawCard();





        int player1Wins = 0;
        int player2Wins = 0;

        int round = 0;

        if (playerOne.equals("random")){
            System.out.println("Player 1 random");
        }else{
            System.out.println("Player 1 is combo");
        }

        if (playerTwo.equals("random")){
            System.out.println("Player 2 random");
        }else{
            System.out.println("Player 2 is combo");
        }




        while (round < plays) {
            System.out.println();
            System.out.println("ROUND " + (round + 1));
            log.trace("\nROUND: " + (round +1 ));

            System.out.println("Player 1 turn:");
            log.trace("Player 1 turn");

            int roundPointsP1 = 0;
            int roundPointsP2 = 0;

            if (playerOne.equals("random")){
                roundPointsP1 = player1.points(firstStrategy.randomStrategy());
                player1.totalPoints += roundPointsP1;
            }else if (playerOne.equals("combo")){
                roundPointsP1 = player1.points(firstStrategy.comboStrategy());
                player1.totalPoints += roundPointsP1;
            }

            log.trace("Player 1 total points: " + player1.totalPoints + "\n");





            if (player2.totalPoints >= 6000){
                break;
            }

            System.out.println("Player 2 turn:");
            log.trace("Player 2 Turn");

            if (playerTwo.equals("random")){
                roundPointsP2 = player2.points(firstStrategy.randomStrategy());
                player2.totalPoints += roundPointsP2;
            }else if (playerTwo.equals("combo")){
                roundPointsP2 = player2.points(firstStrategy.comboStrategy());
                player2.totalPoints += roundPointsP2;

            }


            log.trace("Player 2 total points: " + player2.totalPoints);


            if (roundPointsP2 < roundPointsP1){
                player1Wins++;
                log.trace("Player 1 wins this round");
            }else if (roundPointsP2 > roundPointsP1){
                player2Wins++;
                log.trace("Player 2 wins this round");
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
        int ties = round - player1Wins - player2Wins;
        System.out.println("Ties: " + ties);

        log.trace("Total player 1 wins: " + player1Wins);
        log.trace("Total player 2 wins: " + player2Wins);
        log.trace("Ties: " + ties);

        log.info("Total player 1 wins: " + player1Wins);
        log.info("Total player 2 wins: " + player2Wins);
        log.info("Ties: " + ties);

        double player1WinPercentage = (((double) player1Wins)/((double)round)) * 100;
        double player2WinPercentage = (((double) player2Wins)/((double)round)) * 100;
        double roundedWin1 = Math.round(player1WinPercentage*100)/100;
        double roundedWin2 = Math.round(player2WinPercentage*100)/100;


        System.out.println("Player 1 win percentage: " + roundedWin1);
        System.out.printf("Player 2 win percentage: " + roundedWin2);
        log.info("Player 1 win percentage: " +  roundedWin1);
        log.info("Player 2 win percentage: " + roundedWin2);
        return new int[] {player1Wins, player2Wins};
    }
}
