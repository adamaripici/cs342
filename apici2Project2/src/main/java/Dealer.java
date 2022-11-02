import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    Deck theDeck;
    ArrayList<Card> dealersHand; //hold the dealers hand in each game

    //constructor will initialize the deck
    Dealer() {
        theDeck = new Deck();
    }

    //return an ArrayList<Card> of 3 cards removed from theDeck.
    // before each game starts, the dealer class must check to see if there
    // are more than 34 cards left in the deck
    // if not, theDeck must be reshuffled with a new set of 52 cards in random order
    public ArrayList<Card> dealHand() {
        Random rand = new Random();
        if(theDeck.size() < 34) {
            theDeck.newDeck(); //reshuffle with a new set of 52 cards
        }
        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < 3; i ++) {
            int randomIndex = (rand.nextInt(theDeck.size()));
            cards.add(theDeck.remove(randomIndex));
        }
        return cards;
    }

}
