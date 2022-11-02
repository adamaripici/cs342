public class Card {
    char suit; //capitalized char representing the suit of the card(clubs, diamonds, spades, or hearts)
    int value; // integer value between 2-14

    //getter and setters
    public char getSuit() {
        return suit;
    }

    public void setSuit(char newSuit) {
        this.suit = newSuit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }
}
