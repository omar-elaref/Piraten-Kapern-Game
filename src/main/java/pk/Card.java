package pk;

public interface Card {
    public String getName();
    public int getValue();
    public int getSabers();
    public void playCard(Card saber, Player player, String[] array);

}
