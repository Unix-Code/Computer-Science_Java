import java.util.*;
public class Main {
    public static void main(String[] args) {
        theDeck finalDeck = new theDeck();
        
        finalDeck.shuffle();
        System.out.println(finalDeck.getDeck());
    }
}