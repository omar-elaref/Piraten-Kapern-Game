package pk;

public class SeaBattle implements Card{
    public String name;
    public int value;
    public int sabers;

    public SeaBattle(String name, int value, int sabers){
        this.name = name;
        this.value = value;
        this.sabers = sabers;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue(){ return value;}

    @Override
    public int getSabers(){return sabers;}

    @Override
    public void playCard(Card saber, Player player, String[] array) {
        if (saber.getSabers() == 2){
            if (player.numberOfAKind(array)[4] < 2){
                player.roundPoints =  -3;
            }
            else{
                player.roundPoints += 3;
            }

        }else if (saber.getSabers() == 3){
            if (player.numberOfAKind(array)[4] < 3){ player.roundPoints = -5;}
            else{ player.roundPoints += 5;}
        }else if (saber.getSabers() == 4){
            if (player.numberOfAKind(array)[4] < 4){ player.roundPoints = -10;}
            else{ player.roundPoints += 10;}
        }

    }
}
