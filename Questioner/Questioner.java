import java.util.Scanner;
public class Questioner {
    public static void main(String [] args) {
        questioner();
    }

    public static void questioner() {
        boolean validInput = false;
        String input;
        int age = 0;
        double money = 0.0;

        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = userInputScanner.nextLine();

        System.out.println("\nWhat is your favorite food?");
        String food = userInputScanner.nextLine();

        while (!validInput) {
            System.out.println("\nHow old are you?");
            input = userInputScanner.nextLine();
            try {
                age = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("\nHow much money are you holding in your wallet?");
            input = userInputScanner.nextLine();
            try {
                money = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("$0.00");
        String sMoney = decimalFormat.format(money);

        System.out.format("\nHello %s, I heard you were %d " + (age > 1 ? "years" : "year") + " old and had %s in your wallet.", name, age, sMoney);
        System.out.format("\nAlso, you told me your favorite food is %s.", food);
        System.out.println("\n");

        String answer;

        do {  
            System.out.println("\nWould you like to try again? (Yes/No)");
            answer = userInputScanner.nextLine();
        }

        while (!(answer.equals("Yes") || answer.equals("No"))); 

        if (answer.equals("Yes")) {
            // System.out.println("");
            System.out.print("\f");
            questioner();
        }
        else if (answer.equals("No")) {
            return;
        }
    }
}