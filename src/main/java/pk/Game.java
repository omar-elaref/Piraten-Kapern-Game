package pk;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game {
    //2 Players play the game
    public int game() {
        Strategy firstStrategy = new Strategy();
        Player player1 = new Player();
        Player player2 = new Player();

        int round = 0;

        while (round < 42) {
            System.out.println();
            System.out.println("ROUND " + (round + 1));

            System.out.println("Player 1 turn:");
            player1.pointList[round] = player1.points(firstStrategy.randomStrategy());

            System.out.println("Player 2 turn:");
            player2.pointList[round] = player2.points(firstStrategy.randomStrategy());


            round++;
        }
        for (int p : player1.pointList){
            player1.totalPoints += p;
        }

        for (int pp : player2.pointList){
            player2.totalPoints += pp;
        }
        System.out.println("Player 1 total points: " + player1.totalPoints);
        System.out.println("Player 2 list: " + player2.totalPoints);

        return round;
    }
}
