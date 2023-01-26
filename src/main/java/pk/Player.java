package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
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
        Logger log = LogManager.getRootLogger();
        int PARROT = 0;
        int MONKEY = 0;
        int GOLD = 0;
        int DIAMOND = 0;
        int SABER = 0;

        for (String i : array){
            if (i == "PARROT"){
                PARROT++;
            }else if (i == "MONKEY"){
                MONKEY++;
            }else if (i == "GOLD"){
                GOLD++;
            }else if (i == "DIAMOND"){
                DIAMOND++;
            }else if (i == "SABER"){
                SABER++;
            }
        }
        log.trace("Number of parrots, monkeys, gold, diamonds, sabers: \n" + Arrays.toString(new int[] {PARROT, MONKEY, GOLD, DIAMOND, SABER}));
        return new int[] {PARROT, MONKEY, GOLD, DIAMOND, SABER};
    }


    public int totalPoints = 0;
    public int roundPoints = 0;

    public int points(String array[], Player player){

        Deck cards = new Deck();

        cards.deckContents();

        cards.shuffle();
        Card saber = cards.drawCard();




        roundPoints = 0;
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
        saber.playCard(saber, player, array);

        System.out.println("Round points: " +  roundPoints * 100);


        return roundPoints * 100;

    }


}
