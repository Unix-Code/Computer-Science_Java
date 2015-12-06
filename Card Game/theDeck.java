import java.util.*;
public class theDeck {
    private ArrayList<Card> deck = new ArrayList<Card>(52);
    public theDeck() {
        for (int i=0; i < 52; i++){
            deck.add(new Card(((int)(i/4)), i%4));
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}

