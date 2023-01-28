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
        log.trace(Arrays.toString(roundRoll));
        System.out.println(Arrays.toString(roundRoll));


        return roundRoll;
    }

    public static String[] comboStrategy(Card card){
        Logger log = LogManager.getRootLogger();

        Player comboPlayer = new Player();
        Dice comboDice = new Dice();
        String[] comboRoll = comboDice.numberOfRolls();
        int[] numberOfFaces = comboPlayer.numberOfAKind(comboRoll, card);

        HashMap<String, Integer> listOfNumbers = new HashMap<>();
        //(Face,number of the face)
        listOfNumbers.put("PARROT",numberOfFaces[0]);
        listOfNumbers.put("MONKEY", numberOfFaces[1]);
        listOfNumbers.put("GOLD", numberOfFaces[2]);
        listOfNumbers.put("DIAMOND", numberOfFaces[3]);
        listOfNumbers.put("SABER", numberOfFaces[4]);




        int x = 0;
        while (x < 7) {
            log.trace("\n");
            log.trace("Player will keep going for a higher combo");
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



                    if (comboPlayer.skullCount(comboRoll) >= 3) {
                        break;

                    }

                    for (int j = 0; j < comboRoll.length; j++) {


                        if (comboRoll[j] == i) {

                            if (comboPlayer.skullCount(comboRoll) >= 3) {
                                break;

                            }


                            comboRoll[j] = String.valueOf(comboDice.roll());



                        }
                    }
                }
            }
            comboPlayer.numberOfAKind(comboRoll, card);
            listOfNumbers.put("PARROT", comboPlayer.numberOfAKind(comboRoll, card)[0]);
            listOfNumbers.put("MONKEY", comboPlayer.numberOfAKind(comboRoll, card)[1]);
            listOfNumbers.put("GOLD", comboPlayer.numberOfAKind(comboRoll, card)[2]);
            listOfNumbers.put("DIAMOND", comboPlayer.numberOfAKind(comboRoll, card)[3]);
            listOfNumbers.put("SABER", comboPlayer.numberOfAKind(comboRoll, card)[4]);


            x++;
        }



        log.trace("Player decides to stop rolling");
        log.trace(Arrays.toString(comboRoll));
        System.out.println(Arrays.toString(comboRoll));


        return comboRoll;

    }

    public String[] saberStrategy(Card saberCard){
        Dice saberDice = new Dice();
        String[] saberRoll = saberDice.numberOfRolls();
        Player saberPlayer = new Player();

        Logger log = LogManager.getRootLogger();
        log.trace("Player will decide to use the saber strategy");



        int saberCount = saberPlayer.numberOfAKind(saberRoll, saberCard)[4];
        int saber = 0;

        while (true) {

            if (saberPlayer.skullCount(saberRoll) >= 3) {
                break;
            }

            int y = 0;

            for (int j = 0; j < saberPlayer.numberOfAKind(saberRoll, saberCard).length; j++){
                if (saberPlayer.numberOfAKind(saberRoll, saberCard)[j] == 1){
                    y++;
                }
            }

            for (int j = 0; j < saberPlayer.numberOfAKind(saberRoll, saberCard).length; j++){
                if (saberPlayer.numberOfAKind(saberRoll, saberCard)[j] == 2){
                    y += 2;
                }
            }

            if(y == 1){
                break;
            }



            if (saberCount < saberCard.getSabers()) {
                log.trace(Arrays.toString(saberRoll));
                log.trace("Not enough sabers so player will keep rolling");
                for (int i = 0; i < saberRoll.length; i++) {


                    if (saberCount >= saberCard.getSabers()){
                        continue;
                    }


                    if (saberPlayer.skullCount(saberRoll) >= 3) {
                        log.trace("Enough sabers");
                        break;
                    }



                    if (saberRoll[i] == "SKULL" || saberRoll[i] == "SABER") {

                    } else {
                        saberRoll[i] = String.valueOf(saberDice.roll());
                    }
                    saberCount = saberPlayer.numberOfAKind(saberRoll, saberCard)[4];


                }
            }else{
                break;
            }
        }
        log.trace(Arrays.toString(saberRoll));
        System.out.println(Arrays.toString(saberRoll));

        return saberRoll;
    }
}
