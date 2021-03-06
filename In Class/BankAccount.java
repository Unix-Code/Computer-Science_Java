/**
 * A class to represent a simple BankAccount
 * 
 * @author (Tim Barron) 
 * @version (1.0)
 */
public class BankAccount
{

    //fields
    private double balance;
    private String owner;
    private static double interest;
    //constructors
    /**
     * Default Constructor for objects of class BankAccount
     */
    public BankAccount()
    {
        // initialise instance variables
        balance = 0;
        owner = "Default Owner";
    }

    public BankAccount(String myOwner)
    {
        // initialise instance variables
        balance = 0;
        owner = myOwner;
    }

    public BankAccount(String myOwner, double start)
    {
        // initialise instance variables
        balance = start;
        owner = myOwner;
    }

    // methods
    public double getBalance()
    {
        return balance;
    }

    public String getOwner()
    {
        return owner;
    }
    
    public double getInterest() {
        return interest;
    }
    
    public static void setInterest(double newInterest) {
        interest = newInterest/100;
    }

    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    public void printSlip()
    {
        System.out.println("This is the balance: $" + balance);
        System.out.println("Account owner: " + owner + "\n");
    }
    
    /*public void transferFunds(double amount, BankAccount end) {
        this.withdraw(amount);
        end.deposit(amount);
    }*/
}

