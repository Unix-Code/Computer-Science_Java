import java.util.*;
public class BlackJack {
    private ArrayList<Card> hand1 = new ArrayList<Card>();
    private ArrayList<Card> hand2 = new ArrayList<Card>();
    private ArrayList<Card> hand3 = new ArrayList<Card>(); 
    Scanner Scan = new Scanner(System.in);

    public void start() {
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
            System.out.println("\fDealing Out Hands\n");
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            }  catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println(hand1.get(0).getValue());
            blackjack();
        }
    }

    public void deal() {
        theDeck deck = new theDeck();
        deck.shuffle();
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (i < 2) {
                hand1.add(deck.getDeck().get(i));
            }
            else if (i < 4 && i >= 2) {
                hand2.add(deck.getDeck().get(i));
            }
            else {
                hand3.add(deck.getDeck().get(i));
            }
        }

    }

    public void blackjack() {
        // System.out.println(hand1);
        // System.out.println(hand2);
        int m = 1;

        while (m < 3) {
            if (playerMove(m) == 0 ) {
                m++;
            }
            /**
            else if (playerMove(m) == 3) {
                return;
            } **/
            else if (playerMove(m) == 1) {
                System.out.println("\nPlayer 1 wins");
            }
            else if (playerMove(m) == 2) {
                System.out.println("\nPlayer 2 wins");
            }
        }

    }

    public int playerMove(int playerNum) {
        String move = "";
        int sum1 = 0;
        int sum2 = 0;

        while ((sum1 < 21 && sum2 < 21) || !(move.equalsIgnoreCase("Stay"))) {
            System.out.print(">");
            move = Scan.nextLine();
            if (move.equalsIgnoreCase("Hit")) {

                if (playerNum == 1) {
                    hand1.add(hand3.get(hand1.size()-2));
                    System.out.println("Card Dealt: " + hand1.get(hand1.size() -1));

                }
                else {
                    hand2.add(hand3.get(hand2.size()-2));
                    System.out.println("Card Dealt: " + hand2.get(hand2.size() -1));

                }

            }
            else if (move.equalsIgnoreCase("quit")) {
                System.exit(0);
                return 3;
            }
            sum1 = 0;
            sum2 = 0;
            for (int k = 0; k < hand1.size(); k++) {
                if (hand1.get(k).getValue() > 8 && hand1.get(k).getValue() != 12) {
                    sum1 += 10;
                }
                else if (hand1.get(k).getValue() == 12) {
                    if ((sum1 + 11) > 21) {
                        sum1 += 1;
                    }
                    else {
                        sum1 += 11;
                    }
                }
                else {
                    sum1 += (hand1.get(k).getValue() + 2);
                }
            }           
            for (int k = 0; k < hand2.size(); k++) {
                if (hand2.get(k).getValue() > 8 && hand2.get(k).getValue() != 12) {
                    sum2 += 10;
                }
                else if (hand2.get(k).getValue() == 12) {
                    if ((sum2 + 11) > 21) {
                        sum2 += 1;
                    }
                    else {
                        sum2 += 11;
                    }
                }
                else {
                    sum2 += (hand2.get(k).getValue() + 2);
                }
            }
            System.out.println(sum1 + "\n" + sum2 + "\n");
            System.out.println(hand1 + "\n" + hand2 + "\n");
        }
        if (playerNum == 2) {
            if (sum1 <= 21 && sum2 <= 21)  {
                return (sum1 > sum2)
                ? 1
                : 2;
            }
            else {
                return (sum1 > 21)
                ? 2
                : 1;
            }
        }
        else {
            return 0;
        }
    }    
}