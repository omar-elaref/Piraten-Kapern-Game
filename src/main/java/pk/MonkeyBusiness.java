package pk;

public class MonkeyBusiness implements Card{
    public String name;

    public MonkeyBusiness(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int getSabers() {
        return 0;
    }

    @Override
    public void playCard(Card card, Player player, String[] array) {




    }
}


