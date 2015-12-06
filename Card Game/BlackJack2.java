import java.util.*;
public class BlackJack2 {
    private ArrayList<Card> hand1 = new ArrayList<Card>();
    private ArrayList<Card> hand2 = new ArrayList<Card>();
    private theDeck deck = new theDeck();

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
            // System.out.println(hand1.get(0).getValue());
            blackjack();
        }
    }

    public void deal() {
        deck.shuffle();
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (i < 2) {
                hand1.add(deck.getDeck().get(i));
                deck.getDeck().remove(i);
            }
            else if (i < 4 && i >= 2) {
                hand2.add(deck.getDeck().get(i));
                deck.getDeck().remove(i);
            }
        }

    }

    public void blackjack() {
        String move;
        int playerNum = 1;
        int stayCount = 0;

        System.out.print("\f");

        while (sum(hand1) < 21 && sum(hand2) < 21) {
            System.out.println("Player " + playerNum + "'s turn");
            System.out.println("\nYour hand: " + ((playerNum == 1) ? hand1 : hand2));
            // System.out.print((playerNum == 1) ? hand1 : hand2);
            System.out.println("Your Move?");
            move = Scan.nextLine();

            if (move.equalsIgnoreCase("Hit")) {
                playerMove(0, playerNum);
            }
            else if (move.equalsIgnoreCase("Stay")) {
                playerMove(1, playerNum);
                
                stayCount++;
                if (stayCount == 1) {
                    playerNum++;
                }
                else {
                    break;
                }
            }
            else if (move.equalsIgnoreCase("Quit")) {
                return;
            }
            else {
                System.out.println("\nError: Invalid Command\n");
            }
        }

        System.out.println("Player 1's hand: " + hand1 + "\nPlayer 2's hand: " + hand2);
        System.out.println("\nGame Over\n");
        String winner;
        if (sum(hand1) == 21 || sum(hand2) == 21) {
            winner = (sum(hand1) == 21) ? "Player 1" : "Player 2";
            System.out.println(winner + " got Black Jack\n" + winner + " wins!");
        }
        else if (sum(hand1) > 21 || sum(hand2) > 21) {
            winner = (sum(hand1) > 21) ? "Player 2" : "Player 1";
            System.out.println(((sum(hand1) > 21) ? "Player 1" : "Player 2") + " busts\n" + winner + " wins!");
        }
        else if (stayCount == 2 && sum(hand1) != sum(hand2)) {
            winner = (sum(hand1) > sum(hand2)) ? "Player 1" : "Player 2";
            System.out.println(winner + " got the larger hand\n" + winner + " wins!");
        }
        else if (stayCount == 2 && sum(hand1) == sum(hand2)) {
            System.out.println("The Game is a Tie");
        }
        else {
            System.out.println("Undetermined winner" + "\n\nPlayer 1's hand: " + hand1 + "\nPlayer 2's hand: " + hand2);

        }
        System.out.println("\n");
        return;
    }

    public int sum(ArrayList<Card> handNum) {
        int cardSum = 0;
        int numAces = 0;

        for (int i = 0; i < handNum.size(); i++) {
            if ((handNum.get(i).getValue() + 2) > 10 && (handNum.get(i).getValue() + 2) < 14) {
                cardSum += 10;
            }
            else if (handNum.get(i).getValue() + 2 <= 10){
                cardSum += handNum.get(i).getValue() + 2;   
            }
        }
        for (int j = 0; j < handNum.size(); j++) {
            if (handNum.get(j).getValue() + 2 == 14) {
                if (numAces == 0 && cardSum + 11 <= 21) {
                    cardSum += 11;
                }
                else if (numAces == 1 && cardSum + 1 > 21) {
                    cardSum -= 9;
                    // -11 , + 1, + 1
                }
                else {
                    cardSum += 1;
                }
                numAces++;
            }
        }

        return cardSum;
    }

    public void playerMove(int inMove, int inPlayerNum) {
        switch (inMove) {
            case 0 :
            System.out.println("\nYou chose to hit\n");
            if (inPlayerNum == 1) {
                hand1.add(deck.getDeck().get(0));
            }
            else {
                hand2.add(deck.getDeck().get(0));
            }
            deck.getDeck().remove(0);
            break;

            case 1 :
            System.out.println("\nYou chose to stay\n");

            break;
        }
    }
}