package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

public class Strategy {
    //Implementing the random strategy
    public static String[] randomStrategy(){
        Logger log = LogManager.getRootLogger();

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
                        log.trace(Arrays.toString(roundRoll));
                    }

                }

            }



        }
        System.out.println(Arrays.toString(roundRoll));


        return roundRoll;
    }

    public static String[] comboStrategy(){
        Logger log = LogManager.getRootLogger();

        Player comboPlayer = new Player();
        Dice comboDice = new Dice();
        String[] comboRoll = comboDice.numberOfRolls();
        int[] numberOfFaces = comboPlayer.numberOfAKind(comboRoll);

        HashMap<String, Integer> listOfNumbers = new HashMap<>();
        //(Face,number of the face)
        listOfNumbers.put("PARROT",numberOfFaces[0]);
        listOfNumbers.put("MONKEY", numberOfFaces[1]);
        listOfNumbers.put("GOLD", numberOfFaces[2]);
        listOfNumbers.put("DIAMOND", numberOfFaces[3]);
        listOfNumbers.put("SABER", numberOfFaces[4]);


        for (String i : listOfNumbers.keySet()){
            if (listOfNumbers.get(i) <= 2){
                //System.out.println(i);
                for (int j = 0; j < comboRoll.length; j++){
                    if (comboRoll[j] == i){
                        if (comboPlayer.skullCount(comboRoll) >= 3){
                            continue;
                        }
                        comboRoll[j] = String.valueOf(comboDice.roll());
                        log.trace(Arrays.toString(comboRoll));
                    }
                }
            }
        }



        System.out.println(Arrays.toString(comboRoll));

        return comboRoll;

    }
}
