import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pk.Dice;
import pk.Game;
import pk.Player;
import pk.Strategy;

import java.util.*;

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
        /*
        System.out.println(Arrays.toString(comboRoll));

        System.out.println(listOfNumbers);
        System.out.println();
        for (String i : listOfNumbers.keySet()){
            if (listOfNumbers.get(i) <= 2){
                //System.out.println(i);
                for (int j = 0; j < comboRoll.length; j++){
                    if (comboRoll[j] == i){
                        comboRoll[j] = String.valueOf(comboDice.roll());
                    }
                }
            }
        }

        System.out.println(Arrays.toString(comboRoll));
        System.out.println(Arrays.toString(comboPlayer.numberOfAKind(comboRoll)));

        */


        //Logger log = LogManager.getRootLogger();
        //log.debug("Test");




    }
    
}
