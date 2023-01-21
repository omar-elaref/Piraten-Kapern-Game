import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pk.Dice;
import pk.Game;
import pk.Player;
import pk.Strategy;

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
        System.out.printf("Simulation time: %d", end - start);





        //Logger log = LogManager.getRootLogger();
        //log.debug("Test");




    }
    
}
