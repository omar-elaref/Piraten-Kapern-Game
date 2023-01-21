package pk;

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

    public int[] pointList = new int [42];
    public int totalPoints = 0;

    public int points(String array[]){
        int roundPoints = 0;
        for (String i : array){

            if (skullCount(array) >= 3){
                continue;
            }
            else if (i == "GOLD" || i == "DIAMOND"){
                roundPoints++;
            }
        }


        System.out.println("Round points: " +  roundPoints * 100);
        return roundPoints * 100;

    }


}
