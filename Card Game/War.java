import java.util.*;
public class War {
    private ArrayList<Card> hand1 = new ArrayList<Card>();
    private ArrayList<Card> hand2 = new ArrayList<Card>();
    theDeck deck = new theDeck();
    public void game() {
        deal();
        System.out.print("\f");
        System.out.print("Hit Enter to Start");
        Scanner userInputScanner = new Scanner(System.in);
        String cmdStart = userInputScanner.nextLine();
        if (cmdStart.equals("")) {
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            }  catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("\fWar has begun\n");
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            }  catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            war();
        }
    }

    public void deal() {

        deck.shuffle();
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (i < (deck.getDeck().size()/2)) {
                hand1.add(deck.getDeck().get(i));
            }
            else {
                hand2.add(deck.getDeck().get(i));
            }
        }
    }

    public void war() {
        // System.out.println("This is where the game takes place");
        
        while (!(hand1.size() == 0 || hand2.size() == 0)) { 
            System.out.println("Hit Enter to Deal Hand");
            Scanner userInputScanner = new Scanner(System.in);
            String cmdNext = userInputScanner.nextLine();
            if (cmdNext.equals("quit")) {
                System.out.print("\f");
                return;
            }
            else if (cmdNext.equals("")) {
                System.out.print("\f");

                String winner;
                Card temp = new Card();

                System.out.println("Player 1 plays: " + hand1.get(0));
                System.out.println("Player 2 plays: " + hand2.get(0) + "\n");

                if (hand1.get(0).getValue() > hand2.get(0).getValue()) {
                    winner = "Player 1";

                    hand1.add(hand2.get(0));
                    hand2.remove(0);

                    temp = hand1.get(0);
                    hand1.remove(0);
                    hand1.add(temp);
                }
                else if (hand1.get(0).getValue() < hand2.get(0).getValue()) {
                    winner = "Player 2";

                    hand2.add(hand1.get(0));
                    hand1.remove(0);

                    temp = hand2.get(0);
                    hand2.remove(0);
                    hand2.add(temp);
                }
                else {
                    winner = "No One";

                    // I'm WAY too lazy
                    // hand1.remove(0);
                    // hand2.remove(0);

                    int t = 4;

                    try {
                        while (hand1.get(t).getValue() == hand2.get(t).getValue()) {
                            t = t + 4;
                        }
                    }
                    catch (IndexOutOfBoundsException e) {
                        if (t >= hand1.size() || t >= hand2.size() && !(hand1.size() == 1 || hand2.size() == 1)) {
                            t = Math.min(hand1.size(), hand2.size());
                            break;
                        }
                        else if ((hand1.size() == 1 || hand2.size() == 1) && !(hand1.size() == 1 && hand2.size() == 1)) {
                            System.out.println((hand1.size() == 1)
                                ? ("\fGame over.\nPlayer 2 wins!\n\nPlayer 1 ran oyut of cards.")
                                : ("\fGame over.\nPlayer 1 wins!\n\nPlayer 2 ran out of cards."));
                            return;
                        }
                        else if (hand1.size() == 1 && hand2.size() == 1) {
                            System.out.println("\fGame over.\nIt is a Draw!\n\nBoth players have run out of cards.");
                            return;
                        }
                    }
                    System.out.println("WAR\n");
                    System.out.println("Player 1 plays: " + hand1.get(t));
                    System.out.println("Player 2 plays: " + hand2.get(t) + "\n");

                    if (hand1.get(t).getValue() > hand2.get(t).getValue()) {
                        winner = "Player 1";
                        for (int h = t; h >= 0; h--) {
                            hand1.add(hand2.get(h));
                            hand2.remove(h);

                            temp = hand1.get(h);
                            hand1.remove(h);
                            hand1.add(temp);
                        }
                    }
                    else {
                        winner = "Player 2";
                        for (int z = t; z >= 0; z--) {
                            hand2.add(hand1.get(z));
                            hand1.remove(z);

                            temp = hand2.get(z);
                            hand2.remove(z);
                            hand2.add(temp);
                        }
                    } 
                    // System.out.println(hand1 + "\n" + hand2); // Debugging
                }               
                System.out.println("The winner is " + winner + ".\n");
                System.out.format("Player 1 has %d cards", hand1.size());
                System.out.format("\nPlayer 2 has %d cards\n\n", hand2.size());
                // System.out.println(hand1); // For Debugging Only
                // System.out.println(hand2 + "\n"); // For Debugging Only
                // check();
                /** } catch (StackOverflowError e) {
                System.out.println("\f");
                System.err.println("Ouch! Calm down there...");
                return;
                } **/
            }   
        }         

        if (hand1.size() == 0) {
            System.out.println("\fGame over.\nPlayer 2 wins!");
            return;
        }
        else {
            System.out.println("\fGame over.\nPlayer 1 wins!");
            return;
        }
    }
}
