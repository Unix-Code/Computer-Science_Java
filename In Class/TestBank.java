public class TestBank {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Ahmet Atay", 250);
        BankAccount a2 = new BankAccount("David Malakh", 780);
        BankAccount a3 = new BankAccount("Omar Elhadad", 654);
        Employee e1 = new Employee("Victor", "Victorson", 43, "New Guy", 0.00);
        Employee e2 = new Employee("Walter", "Billson", 55, "New Guy", 0);
        Bank B1 = new Bank();
        Bank B2 = new Bank(a1, a2, a3);
        System.out.println("Bank 1 Information");
        B1.printCompanyReport();
        System.out.println("\n");
        System.out.println("Bank 2 Information");
        B2.printCompanyReport();
        
        B1.giveTellersRaise(5400);
        System.out.println("\nBank 1 Information");
        B1.printCompanyReport();
        
        System.out.println("Bank 2 Total Funds: " + B2.getTotalFunds());
        B2.chargeFees(200);
        System.out.println("\nBank 2 Total Funds: " + B2.getTotalFunds());
        
        B2.setInterest(7);
        B2.addInterest();
        System.out.println("\nBank 2 Total Funds: " + B2.getTotalFunds() + "\n");
        
        System.out.println("Bank 1 Account Information");
        B1.printAllAccounts();
        System.out.println("\n");
        B1.fireBigShots();
        
        System.out.println("Bank 1 Information");
        B1.printCompanyReport();
        
        B1.replaceBigShots(e1, e2);
        System.out.println("\nBank 1 Information");
        B1.printCompanyReport();
    }
}