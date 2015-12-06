import java.util.*;
public class Card {
    private int value;
    private int suit;
    
    public Card() {
        value = 0;
        suit  = 0;
    }

    public Card(int inValue, int inSuit) {
        if (value >= 0 && value < 13 ) {
            value = inValue;
        } 
        else {
            System.err.print("Card value must be between 0 and 12");
        }
        if (suit >= 0 && suit < 4) {
            suit = inSuit;
        }
        else {
            System.err.print("Suit value must be between 0 and 3");
        }

    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public String toString() {
        // return value  of "suit"; 
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
        return rank[value] + " of " + suits[suit];
    }
}