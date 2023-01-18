package pk;

import java.util.Arrays;

public class Strategy {
    public static String[] randomStrategy(){

        Dice die = new Dice();
        Player roll = new Player();

        String [] roundRoll = die.numberOfRolls();

        boolean run = true;
        while(run){
            int random = (int) Math.round(Math.random() * 6);

            if (roll.skullCount(roundRoll) >= 3){
                run = false;
                continue;
            }

            int change = 8 - random;

            for (int i = 0; i < roundRoll.length; i++){

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
        System.out.println(Arrays.toString(roundRoll));
        return roundRoll;
    }
}
