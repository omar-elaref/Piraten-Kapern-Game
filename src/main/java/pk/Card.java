package pk;

public interface Card {
    public String getName();
    public int getValue();
    public int getSabers();
    public void playCard(Card card, Player player, String[] array);

}
