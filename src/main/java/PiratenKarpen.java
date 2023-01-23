import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pk.Dice;
import pk.Game;
import pk.Player;
import pk.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");


        Game firstTry = new Game();
        long start = System.currentTimeMillis();
        firstTry.game();
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.printf("Simulation time: %d", end - start);


        //ArrayList<Integer> dice = new ArrayList<Integer>(Collections.nCopies(5, 0));

        //dice.set(0,2);
        //System.out.println(dice);




        //Logger log = LogManager.getRootLogger();
        //log.debug("Test");




    }
    
}
