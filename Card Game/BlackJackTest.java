import java.util.*;
public class BlackJackTest {
    public static void main(String [] args) {
        ArrayList<BlackJack2> arrBJ = new ArrayList<BlackJack2>();
        
        boolean exitGame = false;
        Scanner Scan = new Scanner(System.in);
        int gameNum = 0;
        System.out.println("\fWould you like to play?");
        while (exitGame != true) {
            
            String command = Scan.nextLine();
            if (command.equalsIgnoreCase("Yes")) {
                // validInput = true;
                System.out.println("\f");
                arrBJ.add(new BlackJack2());
                arrBJ.get(gameNum).start();
                gameNum++;
            }
            else if (command.equalsIgnoreCase("No")) {
                exitGame = true;
                
                return;
            }
            else {
                System.out.println("\nError: Invalid Command\n");
            }
            System.out.println("Would you like to play again?");
        }

    }
}