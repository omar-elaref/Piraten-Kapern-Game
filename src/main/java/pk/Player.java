package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class Player {


    //keeping count of the skulls
    public int skullCount(String array[]){
        int skull2 = 0;
        for (int j = 0; j < array.length; j++){
            if (array[j] == "SKULL"){
                skull2 += 1;
            }
        }
        return skull2;
    }
    //point tracker for each player

    //parrot, monkey, gold, diamond, saber



    public int [] numberOfAKind(String array[]){
        int parrot = 0;
        int monkey = 0;
        int gold = 0;
        int diamond = 0;
        int saber = 0;

        for (String i : array){
            if (i == "PARROT"){
                parrot++;
            }else if (i == "MONKEY"){
                monkey++;
            }else if (i == "GOLD"){
                gold++;
            }else if (i == "DIAMOND"){
                diamond++;
            }else if (i == "SABER"){
                saber++;
            }
        }

        return new int[] {parrot, monkey, gold, diamond, saber};
    }


    public int totalPoints = 0;

    public int points(String array[]){

        int roundPoints = 0;
        for (int i : numberOfAKind(array)){

            if (skullCount(array) >= 3){
                continue;
            }
            else if (i == 3){
                roundPoints++;
            }else if (i == 4){
                roundPoints += 2;
            }else if (i == 5){
                roundPoints += 5;
            }else if (i == 6){
                roundPoints += 10;
            }else if (i == 7){
                roundPoints += 20;
            }else if (i == 8){
                roundPoints += 40;
            }
        }
        for (String i : array){
            if (skullCount(array) >= 3){
                continue;
            }else if (i == "GOLD" || i == "DIAMOND"){
                roundPoints++;
            }

        }



        if (skullCount(array) > 0){

        }else if (numberOfAKind(array)[0] == 0 || numberOfAKind(array)[0] > 2){
            if (numberOfAKind(array)[1] == 0 || numberOfAKind(array)[1] > 2){
                if (numberOfAKind(array)[4] == 0 || numberOfAKind(array)[4] > 2) {
                    roundPoints += 5;
                }
            }
        }

        System.out.println("Round points: " +  roundPoints * 100);
        Logger log = LogManager.getRootLogger();
        log.debug("Player points per round updated");

        return roundPoints * 100;

    }


}
