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

        int round = 0;
        Logger log = LogManager.getRootLogger();

        while (round < 42) {
            System.out.println();
            System.out.println("ROUND " + (round + 1));

            System.out.println("Player 1 turn:");
            player1.totalPoints += player1.points(firstStrategy.randomStrategy());


            log.debug("Player 1 total points updated");


            if (player2.totalPoints >= 6000){
                break;
            }

            System.out.println("Player 2 turn:");
            player2.totalPoints += player2.points(firstStrategy.randomStrategy());

            log.debug("Player 2 total points updated\n");


            if (player1.totalPoints >= 6000){
                break;
            }

            round++;
        }

        System.out.println("Player 1 total points: " + player1.totalPoints);
        System.out.println("Player 2 list: " + player2.totalPoints);

        return round;
    }
}
