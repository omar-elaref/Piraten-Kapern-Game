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
    public void playCard() {

    }
}
