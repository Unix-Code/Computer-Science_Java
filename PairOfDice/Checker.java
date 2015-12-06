import java.util.*;

public class Checker {
    public void checker() {
        PairOfDice Dice = new PairOfDice();         
        int rollCount;
        
        Scanner s = new Scanner(System.in);
        System.out.print("\fNumber of sides on die 1: ");
        int numSides1 = s.nextInt();
        System.out.print("Number of sides on die 2: ");
        int numSides2 = s.nextInt();
        System.out.print("Desired roll: ");
        int desiredRoll = s.nextInt();
        System.out.println("");
        
        Dice.setNumSides(numSides1, numSides2);
        rollCount = 0;

        do {
            Dice.roll();
            System.out.println("The first dice come up " + Dice.getDie1() + " \nand the second dice comes up " + Dice.getDie2());
            rollCount++;
        } while (Dice.getTotal() != desiredRoll);

        System.out.print("\nIt took " + rollCount);
        System.out.print((rollCount == 1) ? " roll" : " rolls");
        System.out.print(" to get a " + desiredRoll + ".");
    }
}  