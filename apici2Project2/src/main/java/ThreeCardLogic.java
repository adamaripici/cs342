import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

import static java.util.Collections.swap;


public class ThreeCardLogic {

    //returns true if hand is a straight flush
    public static boolean isStraightFlush(ArrayList<Card> hand) {

        if (isFlush(hand)) {

            //sort by value
            if (hand.get(0).getValue() < hand.get(1).getValue()) {
                Collections.swap(hand, 0,1);
            }
            if (hand.get(0).getValue() < hand.get(2).getValue()) {
                Collections.swap(hand, 0,2);
            }
            if (hand.get(1).getValue() < hand.get(2).getValue()) {
                Collections.swap(hand, 1,2);
            }
            int difference1 = hand.get(0).getValue() - hand.get(1).getValue();
            int difference2 = hand.get(1).getValue() - hand.get(2).getValue();
            int difference3 = hand.get(0).getValue() - hand.get(2).getValue();
            if (difference1 == 1 && difference2 == 1 && difference3 == 2) {
                return true;
            }
        }
        return false;
    }

    // returns true if hand is three of a kind
    public static boolean isThreeOfAKind(ArrayList<Card> hand) {
        if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue() == hand.get(2).getValue()) {
            return true;
        }
        return false;
    }

    // returns true if hand is straight
    public static boolean isStraight(ArrayList<Card> hand) {
        //sort by value
        if (hand.get(0).getValue() < hand.get(1).getValue()) {
            Collections.swap(hand, 0,1);
        }
        if (hand.get(0).getValue() < hand.get(2).getValue()) {
            Collections.swap(hand, 0,2);
        }
        if (hand.get(1).getValue() < hand.get(2).getValue()) {
            Collections.swap(hand, 1,2);
        }
        int difference1 = hand.get(0).getValue() - hand.get(1).getValue();
        int difference2 = hand.get(1).getValue() - hand.get(2).getValue();
        int difference3 = hand.get(0).getValue() - hand.get(2).getValue();
        if (difference1 == 1 && difference2 == 1 && difference3 == 2) {
            return true;
        }
        return false;
    }

    // returns true if hand is flush
    public static boolean isFlush(ArrayList<Card> hand) {
        if (hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit()) {
            return true;
        }
        return false;
    }

    // returns true if hand is pair
    public static boolean isPair(ArrayList<Card> hand) {
        if (hand.get(0).getValue() == hand.get(1).getValue() ||
                hand.get(0).getValue() == hand.get(2).getValue() || hand.get(1).getValue() == hand.get(2).getValue() ) {
            return true;
        }
        return false;
    }
    // will return an integer representing the value of the hand passed in.
    // will return 0 if the hand just has a high card
    // will return 1 for a straight flush
    // will return 2 for three of a kind
    // will return 3 for a straight
    // will return 4 for a flush
    // will return 5 for a pair
    public static int evalHand(ArrayList<Card> hand) {
        int value = 0;
        if (isStraightFlush(hand)) {
            value = 1;
        } else if (isThreeOfAKind(hand)) {
            value = 2;
        } else if (isStraight(hand)) {
            value = 3;
        } else if (isFlush(hand)) {
            value = 4;
        } else if (isPair(hand)) {
            value = 5;
        } else {
            value = 0;
        }
        return value;
    }

    // this method will return the amount won for the pairPlus bet.
    // it will evaluate the hand and then evaluate the winnings and return the amount won
    // if the player lost the pair plus bet, it will return 0
    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
        int result = 0;
        //evaluate the hand
        int handResult = evalHand(hand);
        if (handResult == 0) {
            return 0;
        } else if (handResult == 1) {
            result = (40*bet) + bet;
        } else if (handResult == 2) {
            result = (30*bet) + bet;
        } else if (handResult == 3) {
            result = (6*bet) + bet;
        } else if (handResult == 4) {
            result = (3*bet) + bet;
        } else if (handResult == 5) {
            result = (1*bet) + bet;
        }
        return result;
    }

    //function to check if there is a queen or higher:

    public static boolean queenOrHigher(ArrayList<Card> dealer) {
        for (int i = 0; i < 3; i ++) {
            if (dealer.get(i).getValue() >= 12) {
                return true;
            }
        }
        return false;
    }

    //compare the two hands passed in and return an integer based on which hand won
    // 0 if neither hand won
    // 1 if the dealer hand won
    // 2 if the player hand won
    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
        int evaluateDealer = evalHand(dealer);
        int evaluatePlayer = evalHand(player);

        if (evaluateDealer < evaluatePlayer && evaluateDealer != 0) {
            return 1;
        } else if (!queenOrHigher(dealer)) { //check if the dealer has a queen high:
            return 0;
        } else if (evaluatePlayer < evaluateDealer && evaluatePlayer != 0) {
            return 2;
        } else if (evaluatePlayer == 0 || evaluateDealer == 0) {
            if (evaluateDealer > evaluatePlayer) {
                return 1;
            } else if (evaluatePlayer > evaluateDealer) {
                return 2;
            }
        }
        return 0;
    }



}
