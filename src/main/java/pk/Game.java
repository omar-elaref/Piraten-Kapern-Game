package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game {
    //2 Players play the game
    public int[] game(int plays) {
        Logger log = LogManager.getRootLogger();
        Strategy firstStrategy = new Strategy();
        Player player1 = new Player();
        Player player2 = new Player();

        int player1Wins = 0;
        int player2Wins = 0;

        int round = 0;


        while (round < plays) {
            System.out.println();
            System.out.println("ROUND " + (round + 1));
            log.trace("ROUND\n" + (round +1 ));

            System.out.println("Player 1 turn:");
            log.trace("Player 1 turn");
            int roundPointsP1 = player1.points(firstStrategy.comboStrategy());
            player1.totalPoints += roundPointsP1;
            log.trace("Player 1 total points: " + player1.totalPoints);





            if (player2.totalPoints >= 6000){
                break;
            }

            System.out.println("Player 2 turn:");
            int roundPointsP2 = player2.points(firstStrategy.randomStrategy());
            player2.totalPoints += roundPointsP2;


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




        return new int[] {player1Wins, player2Wins};
    }
}
