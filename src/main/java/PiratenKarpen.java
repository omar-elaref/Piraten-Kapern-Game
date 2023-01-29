import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.*;
import pk.*;

import java.util.*;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        //System.out.println("I'm rolling a dice");
        //Dice myDice = new Dice();
        //System.out.println(myDice.roll());
        //System.out.println("That's all folks!");

        Game firstTry = new Game();

        Tracer tracer = new Tracer();

        if (args.length == 1 && args[0].equals("trace")){
            tracer.useTracer(true);
            firstTry.game(42,"random","random");

        }else if (args.length == 1){
            tracer.useTracer(false);
            firstTry.game(42,"random","random");

        }


        if (args.length == 2 && args[0].equals("combo") && args[1].equals("combo")){

            tracer.useTracer(false);
            firstTry.game(42, "combo", "combo");

        }else if (args.length == 2 && args[0].equals("random") && args[1].equals("combo")){


            tracer.useTracer(false);
            firstTry.game(42, "random", "combo");



        }else if (args.length == 2 && args[0].equals("combo") && args[1].equals("random")){

            tracer.useTracer(false);
            firstTry.game(42, "combo", "random");

        }else if (args.length == 2 && args[0].equals("random") && args[1].equals("random")){

            tracer.useTracer(false);
            firstTry.game(42, "random", "random");

        }


        if (args.length == 3 && args[0].equals("trace")){
            tracer.useTracer(true);
            if (args[1].equals("combo") && args[2].equals("combo")){

                firstTry.game(42, "combo", "combo");

            }else if (args[1].equals("random") && args[2].equals("combo")){

                firstTry.game(42, "random", "combo");

            }else if (args[1].equals("combo") && args[2].equals("random")){

                firstTry.game(42, "combo", "random");

            }else if (args[1].equals("random") && args[2].equals("random")){

                firstTry.game(42, "random", "random");

            }


        }else if (args.length == 3) {
            tracer.useTracer(false);

            if (args[1].equals("combo") && args[2].equals("combo")) {

                firstTry.game(42, "combo", "combo");

            } else if (args[1].equals("random") && args[2].equals("combo")) {

                firstTry.game(42, "random", "combo");

            } else if (args[1].equals("combo") && args[2].equals("random")) {

                firstTry.game(42, "combo", "random");

            } else if (args[1].equals("random") && args[2].equals("random")) {

                firstTry.game(42, "random", "random");

            }
        }



    }
    
}
