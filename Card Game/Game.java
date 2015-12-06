import java.util.*;
public class Game {
    public static void main(String [] args) {
        War Game1 = new War();
        BlackJack2 Game2 = new BlackJack2();
        Scanner scan = new Scanner(System.in);
        String command = "";

        while (!(command.equalsIgnoreCase("War") || command.equalsIgnoreCase("Black Jack"))) {
            System.out.println("\fWhich game would you like to play?\nWar or Black Jack?");
            
            command = scan.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                return;
            }

            System.out.print((!(command.equalsIgnoreCase("War") || command.equalsIgnoreCase("Black Jack"))) ? "Error: Game Not Found" : "");
            
            try {
                Thread.sleep(750);                 //1000 milliseconds is one second.
            }  catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        if (command.equalsIgnoreCase("War")) {
            Game1.game();
        }
        else {    
            Game2.start();
        }
    }
}