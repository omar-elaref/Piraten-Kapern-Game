package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Strategy {
    //Implementing the random strategy
    public static String[] randomStrategy(){

        Dice die = new Dice();
        Player roll = new Player();

        String [] roundRoll = die.numberOfRolls();

        boolean run = true;
        while(run){
            int random = (int) Math.round(Math.random() * 6);

            int stopGo = (int) Math.round(Math.random() * 2);

            if (stopGo == 1){
                run = false;
                continue;
            }else{
                if (roll.skullCount(roundRoll) >= 3){
                    run = false;
                    continue;
                }

                int change = 8 - random;

                for (int i = 0; i < change; i++){

                    if (roll.skullCount(roundRoll) >= 3){
                        run = false;
                        continue;
                    }

                    if (roundRoll[i] == "SKULL"){
                        continue;
                    }else{
                        String newRoll = String.valueOf(die.roll());
                        roundRoll[i]  = newRoll;
                    }

                }
            }



        }
        System.out.println(Arrays.toString(roundRoll));
        Logger log = LogManager.getRootLogger();
        log.debug("The players turn has ended");

        return roundRoll;
    }
}
