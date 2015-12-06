import java.util.*;
public class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;
    public Customer() {
        accounts = new ArrayList<BankAccount>();
        name = "User 0";
        accounts.add(new BankAccount(name, 0));
    }

    public Customer(String inName) {
        name = inName;
        accounts = new ArrayList<BankAccount>();
        accounts.add(new BankAccount(name, 0));
    }
    
    public Customer(String inName, double startBalance) {
        name = inName;
        accounts = new ArrayList<BankAccount>();
        accounts.add(new BankAccount(name, startBalance));
    }
    
    public Customer(String inName, BankAccount inAccount) {
        name = inName;
        accounts = new ArrayList<BankAccount>();
        accounts.add(inAccount);
    }
    
    public void depositAll(double amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) != null) {
                accounts.get(i).deposit(amount);
            }
        }
    }
    
    public void depositSingle(double amount, int accountNum) {
        accounts.get(accountNum - 1).deposit(amount);
    }
    
    public void withdrawAll(double amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) != null) {
                accounts.get(i).withdraw(amount);
            }
        }
    }
    
    public void createAccount(double inBalance) {
        BankAccount newAccount = new BankAccount(name, inBalance);
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) == null) {
                accounts.add(newAccount);
                return;
            }
        }
    }

    public void printAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            try {
                accounts.get(i).printSlip();
            } catch (NullPointerException e) {
                continue;
            }
        }
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount(int numAccount) {
        try {
            return accounts.get(numAccount - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return accounts;
    }

    public void closeAccount(int numAccount) {
        try {
            accounts.set(numAccount - 1, null);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: No Account Found");
        }
    }
}