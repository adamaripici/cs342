import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThreeCardLogicTest {

    Dealer dealer = new Dealer();

    Player player = new Player();

    @Test
    void testingSetTotalWinnings() {
        player.setTotalWinnings(10);
        assertEquals(10, player.getTotalWinnings(), "Wrong number of winnings");
    }

    //testing winnings
    @Test
    void testingSetTotalWinnings2() {
        player.setTotalWinnings(10);
        player.setTotalWinnings(player.getTotalWinnings()+5);
        assertEquals(15, player.getTotalWinnings(), "Wrong number of winnings");
    }

    //testing ante bet and get ante bet
    @Test
    void testingAnteBet() {
        player.setAnteBet(20);
        assertEquals(20, player.getAnteBet(), "Error in AnteBet");
    }

    //testing play bet plus bet and get play bet
    @Test
    void testingPlayBet() {
        player.setPlayBet(30);
        assertEquals(30, player.getPlayBet(), "Error in Play Bet");
    }

    //testing setpair plus bet and get pair bet
    @Test
    void testingPairPlusBet() {
        player.setPairPlusBet(50);
        assertEquals(50, player.getPairPlusBet(), "Error in Pair Plus Bet");
    }

    @Test
    public void ThreeOfAKindTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('C', 10));
        hand.add(new Card('D', 10));
        hand.add(new Card('S', 10));
        player.hand = hand;
        assertEquals(2, ThreeCardLogic.evalHand(player.hand), "Wrong this is a three of a kind ");

    }

    @Test
    public void ThreeOfAKindTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 2));
        hand.add(new Card('H', 2));
        hand.add(new Card('S', 2));
        dealer.dealersHand = hand;
        assertEquals(2, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a three of a kind ");

    }

    @Test
    public void FlushTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 13));
        hand.add(new Card('S', 9));
        hand.add(new Card('S', 7));
        dealer.dealersHand = hand;
        assertEquals(4, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a flush ");
    }

    @Test
    public void FlushTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 2));
        hand.add(new Card('H', 8));
        hand.add(new Card('H', 14));
        player.hand = hand;
        assertEquals(4, ThreeCardLogic.evalHand(player.hand), "Wrong this is a flush");
    }
    //check the players hand is a pair
    @Test
    public void PairTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 13));
        hand.add(new Card('D', 13));
        hand.add(new Card('C', 9));
        player.hand = hand;
        assertEquals(5, ThreeCardLogic.evalHand(player.hand), "Wrong this is a pair");
    }
    // check the dealers hand is a pair
    @Test
    public void PairTest2()
    {
        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(new Card('H', 13));
        hand2.add(new Card('D', 10));
        hand2.add(new Card('C', 10));
        dealer.dealersHand = hand2;
        assertEquals(5, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a pair");
    }

    // check the dealers hand is a pair
    @Test
    public void PairTest3()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 11));
        hand.add(new Card('D', 10));
        hand.add(new Card('C', 11));
        dealer.dealersHand = hand;
        assertEquals(5, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a pair");
    }

    // check the dealers hand is a straight flush
    @Test
    public void StraightFlushTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 10));
        hand.add(new Card('S', 9));
        hand.add(new Card('S', 8));
        dealer.dealersHand = hand;
        assertEquals(1, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a straight flush");
    }

    //check the players hand is a pair
    @Test
    public void StraightFlushTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 2));
        hand.add(new Card('H', 3));
        hand.add(new Card('H', 1));
        player.hand = hand;
        assertEquals(1, ThreeCardLogic.evalHand(player.hand), "Wrong this is a straight flush");
    }

    //check the players hand is a pair
    @Test
    public void StraightFlushTest3()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 13));
        hand.add(new Card('H', 14));
        hand.add(new Card('H', 12));
        player.hand = hand;
        assertEquals(1, ThreeCardLogic.evalHand(player.hand), "Wrong this is a straight flush");
    }

    //check the players hand is a pair
    @Test
    public void StraightTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('C', 8));
        hand.add(new Card('D', 7));
        hand.add(new Card('S', 6));
        player.hand = hand;
        assertEquals(3, ThreeCardLogic.evalHand(player.hand), "Wrong this is a straight");
    }

    //check the players hand is a pair
    @Test
    public void StraightTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 1));
        hand.add(new Card('S', 3));
        hand.add(new Card('C', 2));
        dealer.dealersHand = hand;
        assertEquals(3, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a straight");
    }

    //check the players hand is a pair
    @Test
    public void StraightTest3()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 13));
        hand.add(new Card('S', 12));
        hand.add(new Card('C', 11));
        dealer.dealersHand = hand;
        assertEquals(3, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a straight");
    }

    //check the players hand is a high card
    @Test
    public void HighCardTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('H', 14));
        hand.add(new Card('S', 1));
        hand.add(new Card('C', 2));
        dealer.dealersHand = hand;
        assertEquals(0, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a high card");
    }

    //check the players hand is a high card
    @Test
    public void HighCardTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 12));
        hand.add(new Card('S', 1));
        hand.add(new Card('C', 2));
        dealer.dealersHand = hand;
        assertEquals(0, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a high card");
    }

    @Test
    public void evalPPWinningsTest()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 12));
        hand.add(new Card('S', 12));
        hand.add(new Card('C', 2));
        dealer.dealersHand = hand;
        assertEquals(30, ThreeCardLogic.evalPPWinnings(dealer.dealersHand,15), "dealer won a pair- winning should be $30");
    }

    @Test
    public void evalPPWinningsTest2()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 5));
        hand.add(new Card('D', 12));
        hand.add(new Card('D', 2));
        dealer.dealersHand = hand;
        assertEquals(80, ThreeCardLogic.evalPPWinnings(dealer.dealersHand,20), "dealer won a flush- winning should be $80");
    }

    @Test
    public void evalPPWinningsTest3()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 8));
        hand.add(new Card('H', 7));
        hand.add(new Card('S', 6));
        dealer.dealersHand = hand;
        assertEquals(140, ThreeCardLogic.evalPPWinnings(dealer.dealersHand,20), "dealer won a straight- winning should be $140");
    }

    @Test
    public void evalPPWinningsTest4()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 8));
        hand.add(new Card('H', 8));
        hand.add(new Card('S', 8));
        player.hand = hand;
        assertEquals(620, ThreeCardLogic.evalPPWinnings(player.hand,20), "dealer won a three of a kind- winning should be $620");
    }

    @Test
    public void evalPPWinningsTest5()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 10));
        hand.add(new Card('D', 9));
        hand.add(new Card('D', 8));
        player.hand = hand;
        assertEquals(820, ThreeCardLogic.evalPPWinnings(player.hand,20), "dealer won a straight flush- winning should be $620");
    }

    @Test
    public void evalPPWinningsTest6()
    {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('D', 12));
        hand.add(new Card('S', 1));
        hand.add(new Card('C', 2));
        player.hand = hand;
        assertEquals(0, ThreeCardLogic.evalPPWinnings(player.hand,20), "player won a queen high- winning should be $0");
    }

    @Test
    public void evalCompareHandsTest()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('D', 10));
        dealerHand.add(new Card('D', 9));
        dealerHand.add(new Card('D', 8));

        dealer.dealersHand = dealerHand; //straight flush

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('H', 13));
        playerHand.add(new Card('S', 13));
        playerHand.add(new Card('C', 13));

        player.hand = playerHand; //three of a kind

        assertEquals(1, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "dealer won this round");
    }

    @Test
    public void evalCompareHandsTest2()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('D', 10));
        dealerHand.add(new Card('H', 9));
        dealerHand.add(new Card('S', 8));

        dealer.dealersHand = dealerHand; //straight

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('H', 10));
        playerHand.add(new Card('S', 9));
        playerHand.add(new Card('C', 8));

        player.hand = playerHand; //straight

        assertEquals(0, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "neither won");
    }

    @Test
    public void evalCompareHandsTest3()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('D', 1));
        dealerHand.add(new Card('H', 2));
        dealerHand.add(new Card('S', 8));

        dealer.dealersHand = dealerHand; // 8 high
        assertEquals(0, ThreeCardLogic.evalHand(dealer.dealersHand), "Wrong this is a high card");

        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand.add(new Card('H', 10));
        playerHand.add(new Card('S', 9));
        playerHand.add(new Card('C', 8));

        player.hand = playerHand; //straight

        assertEquals(0, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "neither won");
    }
    @Test
    public void evalCompareHandsTest4()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('D', 1));
        dealerHand.add(new Card('D', 2));
        dealerHand.add(new Card('D', 8));

        dealer.dealersHand = dealerHand; // flush

        ArrayList<Card> playerHand = new ArrayList<>();

        playerHand.add(new Card('H', 10));
        playerHand.add(new Card('S', 10));
        playerHand.add(new Card('C', 8));

        player.hand = playerHand; //pair

        assertEquals(1, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "dealer won");
    }

    @Test
    public void evalCompareHandsTest5()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('D', 10));
        dealerHand.add(new Card('D', 9));
        dealerHand.add(new Card('D', 8));

        dealer.dealersHand = dealerHand; // straight flush

        ArrayList<Card> playerHand = new ArrayList<>();

        playerHand.add(new Card('D', 10));
        playerHand.add(new Card('D', 9));
        playerHand.add(new Card('D', 8));

        player.hand = playerHand; //straight flush

        assertEquals(0, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "tie");
    }

    @Test
    public void evalCompareHandsTest6()
    {
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand.add(new Card('S', 1));
        dealerHand.add(new Card('S', 5));
        dealerHand.add(new Card('S', 12));

        dealer.dealersHand = dealerHand; //flush

        ArrayList<Card> playerHand = new ArrayList<>();

        playerHand.add(new Card('H', 1));
        playerHand.add(new Card('D', 1));
        playerHand.add(new Card('S', 1));

        player.hand = playerHand; //three of a kind

        assertEquals(2, ThreeCardLogic.compareHands(dealer.dealersHand,player.hand), "player won");
    }
}
