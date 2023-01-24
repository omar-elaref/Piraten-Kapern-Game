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


        firstTry.game(42);





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
