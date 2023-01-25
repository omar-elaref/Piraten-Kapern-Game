import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.*;
import pk.*;

import java.util.*;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");

        Game firstTry = new Game();

        Tracer tracer = new Tracer();

        if (args.length == 1 && args[0].equals("trace")){
            tracer.useTracer(true);
        }else{
            tracer.useTracer(false);
        }

        if (args.length == 2 && args[0].equals("combo") && args[1].equals("combo")){

            firstTry.game(42, "combo", "combo");

        }else if (args.length == 2 && args[0].equals("random") && args[1].equals("combo")){

            firstTry.game(42, "random", "combo");

        }else if (args.length == 2 && args[0].equals("combo") && args[1].equals("random")){

            firstTry.game(42, "combo", "random");

        }else if (args.length == 2 && args[0].equals("random") && args[1].equals("random")){

            firstTry.game(42, "random", "random");

        }







//        Configurator.setRootLevel(Level.TRACE);
//
//
//
//        Logger log = LogManager.getRootLogger();
//        log.trace("Trace");
        //log.debug("Test");


//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        System.out.printf("Simulation time: %d", end - start);




    }
    
}
