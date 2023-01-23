package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game {
    //2 Players play the game
    public int game() {
        Strategy firstStrategy = new Strategy();
        Player player1 = new Player();
        Player player2 = new Player();

        int player1Wins = 0;
        int player2Wins = 0;

        int round = 0;
        Logger log = LogManager.getRootLogger();

        while (round < 3) {
            System.out.println();
            System.out.println("ROUND " + (round + 1));

            System.out.println("Player 1 turn:");
            int roundPointsP1 = player1.points(firstStrategy.randomStrategy());
            player1.totalPoints += roundPointsP1;


            log.debug("Player 1 total points updated");


            if (player2.totalPoints >= 6000){
                break;
            }

            System.out.println("Player 2 turn:");
            int roundPointsP2 = player2.points(firstStrategy.randomStrategy());
            player2.totalPoints += roundPointsP2;

            log.debug("Player 2 total points updated\n");

            if (roundPointsP2 < roundPointsP1){
                player1Wins++;
            }else if (roundPointsP2 > roundPointsP1){
                player2Wins++;
            }

            if (player1.totalPoints >= 6000){
                break;
            }






            round++;
        }

        System.out.println();
        System.out.println("Player 1 total points: " + player1.totalPoints);
        System.out.println("Player 2 total points: " + player2.totalPoints);
        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);




        return round;
    }
}
