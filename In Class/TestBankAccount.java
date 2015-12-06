public class TestBankAccount {
    public static void main(String [] args) {
        BankAccount b1 = new BankAccount("Grace Hopper", 99);
        b1.printSlip();
        b1.deposit(100);
        b1.printSlip();
        
    }
    
}