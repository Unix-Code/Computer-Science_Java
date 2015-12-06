public class MultiTester {
    public static void main(String [] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount("Brian Wilson");
        BankAccount b3 = new BankAccount("John Smith", 42);
        Employee e1 = new Employee("John", "Smith", 29, "Developer", 37000.00);
        
        b1.deposit(420);
        b1.printSlip();

        b2.deposit(420);
        b2.printSlip();

        b3.deposit(420);
        b3.printSlip();

        b1.withdraw(420);
        b1.printSlip();

        b2.withdraw(420);
        b2.printSlip();

        b3.withdraw(420);
        b3.printSlip();

        System.out.println(e1.getFirst());

        System.out.println(e1.getLast());

        System.out.println(e1.getID());

        e1.setID("11-222-3333");

        e1.printPersonnelReport();
        System.out.println("");

        e1.increaseAge();

        e1.printPersonnelReport();
        System.out.println("");

        e1.giveRaise(1200.0);

        e1.printPersonnelReport();
        System.out.println("");

        e1.fire();

        e1.printPersonnelReport();
        System.out.println("");

        e1.changePosition("Manager", 200000);

        e1.printPersonnelReport();
        System.out.println("");
        /*
        try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
        }  catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
        }
        System.out.println("\f");

        CommandLine2 EmployeeTest = new CommandLine2();

        EmployeeTest.commandLine();*/
    }
}