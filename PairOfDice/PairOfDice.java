import java.util.*;
public class PairOfDice {
    private int value1;  
    private int value2; 
    private int numSides1;
    private int numSides2;

    public PairOfDice() {
        roll();  
    }

    public void setNumSides(int inNumSides1, int inNumSides2) {
        numSides1 = inNumSides1;
        numSides2 = inNumSides2;
    }

    
    public void roll() {
        // Random RandNum = new Random();
        value1 = (int)(Math.random()*numSides1) + 1;
        value2 = (int)(Math.random()*numSides2) + 1;
    }

    public int getDie1() { 
        return value1;
    }

    public int getDie2() { 
        return value2;
    }

    public int getTotal() {
        return value1 + value2;
    }
} 