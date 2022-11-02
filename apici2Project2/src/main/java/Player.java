import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand;
    int anteBet;
    int playBet;
    int pairPlusBet;
    int totalWinnings;

    Player() {
        anteBet = 0;
        playBet = 0;
        pairPlusBet = 0;
        totalWinnings = 0;
    }
    //getters and setters

    public void setHand(ArrayList<Card> newHand) {
        this.hand = newHand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setAnteBet(int newAnteBet) {
        this.anteBet = newAnteBet;
    }

    public int getAnteBet() {
        return anteBet;
    }

    public void setPlayBet(int newPlayBet) {
        this.playBet = newPlayBet;
    }

    public int getPlayBet() {
        return playBet;
    }

    public void setPairPlusBet(int newPairPlusBet) {
        this.pairPlusBet = newPairPlusBet;
    }

    public int getPairPlusBet() {
        return pairPlusBet;
    }

    public void setTotalWinnings(int newTotalWinnings) {
        this.totalWinnings = newTotalWinnings;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }
}
