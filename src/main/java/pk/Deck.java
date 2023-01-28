package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    public List<Card> cards;


    public Deck(){
        cards = new ArrayList<>();
    }


    public void addCard(Card card){
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() > 0) {


            Card drawnCard = cards.remove(0);

            cards.add(drawnCard);
            return drawnCard;
        } else {
            return null;
        }
    }

    public int size() {
        return cards.size();
    }

    public  List<Card>  deckContents(){
        SeaBattle sea2 = new SeaBattle("Saber",300,2);
        SeaBattle sea3 = new SeaBattle("Saber", 500, 3);
        SeaBattle sea4 = new SeaBattle("Saber", 1000, 4);
        SeaBattle nothing = new SeaBattle("nope",0,0);

        MonkeyBusiness monkeyParrotCard = new MonkeyBusiness("Monkey Card");

        Deck deck = new Deck();

        int i = 0;

        while (i < 24){
            cards.add(nothing);
            i++;
        }

        for(int j = 0; j < 3; j++){
            cards.add(monkeyParrotCard);
        }


        cards.add(sea2);
        cards.add(sea2);
        cards.add(sea3);
        cards.add(sea3);
        cards.add(sea4);
        cards.add(sea4);

        //deck.addCard(sea4);
        //deck.shuffle();
        return cards;
    }

}
