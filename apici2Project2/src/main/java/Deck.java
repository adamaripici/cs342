import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

    //create a new deck of 52 cards that are sorted in random order constructor
    Deck() {

        char[] suits = {'C','D','S','H'};
        for (int i = 0; i < suits.length; i ++) {
            for (int j = 2; j <= 14; j++) {
                this.add(new Card(suits[i],j));
            }
        }
        //shuffle
        Collections.shuffle(this);
    }

    //clear all the cards and create a brand new deck of 52 cards sorted in random order method
    public void newDeck() {
        this.clear();
        new Deck();
    }
}
