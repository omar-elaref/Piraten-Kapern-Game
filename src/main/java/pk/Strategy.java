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
            log.trace(Arrays.toString(roundRoll));
            int random = (int) Math.round(Math.random() * 6);

            int stopGo = (int) Math.round(Math.random() * 2);

            if (stopGo == 1){
                log.trace("Random player decides to stop");
                run = false;
                continue;
            }else{
                log.trace("Random player decides to keep rolling");

                if (roll.skullCount(roundRoll) >= 3){
                    run = false;
                    continue;
                }

                int change = 8 - random;
                log.trace(Arrays.toString(roundRoll));

                for (int i = 0; i < change; i++){
                    log.trace("Number of skulls: " + roll.skullCount(roundRoll));

                    if (roll.skullCount(roundRoll) >= 3){
                        run = false;
                        log.trace(Arrays.toString(roundRoll));
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




        int x = 0;
        while (x < 7) {

            log.trace(Arrays.toString(comboRoll));

            int y = 0;

            for (String i : listOfNumbers.keySet()){
                if (listOfNumbers.get(i) == 1){
                    y++;
                }
            }

            for (String i : listOfNumbers.keySet()){
                if (listOfNumbers.get(i) == 2){
                    y += 2;
                }
            }




            if(y == 1){
                break;
            }


            if (comboPlayer.skullCount(comboRoll) == 2) {
                break;

            }

            for (String i : listOfNumbers.keySet()) {
                if (listOfNumbers.get(i) <= 2 && listOfNumbers.get(i) != 0) {
                    log.trace("ReRolling: " + i);
                    //System.out.println(i);

                    if (comboPlayer.skullCount(comboRoll) >= 3) {
                        break;

                    }

                    for (int j = 0; j < comboRoll.length; j++) {


                        if (comboRoll[j] == i) {

                            if (comboPlayer.skullCount(comboRoll) >= 3) {
                                break;

                            }


                            comboRoll[j] = String.valueOf(comboDice.roll());


                            log.trace("Number of skulls: " + comboPlayer.skullCount(comboRoll));
                        }
                    }
                }
            }
            comboPlayer.numberOfAKind(comboRoll);
            listOfNumbers.put("PARROT", comboPlayer.numberOfAKind(comboRoll)[0]);
            listOfNumbers.put("MONKEY", comboPlayer.numberOfAKind(comboRoll)[1]);
            listOfNumbers.put("GOLD", comboPlayer.numberOfAKind(comboRoll)[2]);
            listOfNumbers.put("DIAMOND", comboPlayer.numberOfAKind(comboRoll)[3]);
            listOfNumbers.put("SABER", comboPlayer.numberOfAKind(comboRoll)[4]);
            log.trace(Arrays.toString(comboRoll));

            x++;
        }




        log.trace("Final roll: " + Arrays.toString(comboRoll));
        log.trace("blah");
        System.out.println(Arrays.toString(comboRoll));


        return comboRoll;

    }
}
