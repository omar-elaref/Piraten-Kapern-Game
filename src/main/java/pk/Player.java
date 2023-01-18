package pk;

public class Player {



    public int skullCount(String array[]){
        int skull2 = 0;
        for (int j = 0; j < array.length; j++){
            if (array[j] == "SKULL"){
                skull2 += 1;
            }
        }
        return skull2;
    }
    public int goldDiamond = 0;
    public int points(String array[]){
        for (String i : array){
            if (i == "GOLD" || i == "DIAMOND"){
                goldDiamond++;
            }
        }
        int roundPoints = goldDiamond * 100;
        System.out.println("Total points: " +  roundPoints);
        return roundPoints;

    }

}
