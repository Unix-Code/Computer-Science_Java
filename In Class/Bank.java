public class Bank {
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Employee teller1; 
    private Employee teller2;
    private Employee teller3;
    private Employee president;
    private Employee vicePrez;
    public Bank() {
        customer1 = new Customer("Ahmet Atay", 200);
        customer2 = new Customer("David Malakh");
        customer3 = new Customer("Omar Elhadad", 100.0);
        teller1 = new Employee("John", "Smith", 29, "Teller", 17000.00);
        teller2 = new Employee("Brian", "Johnson",  46, "Teller", 18000.00);
        teller3 = new Employee("Anders", "Jackson", 17, "Teller", 15000.00);
        president = new Employee("Ronald", "Watson", 65, "President", 290000.00);
        vicePrez = new Employee("Sid", "Stewartson", 34, "VicePresident", 130000.00);
    }

    public Bank(BankAccount a, BankAccount b, BankAccount c) {
        customer1 = new Customer("Ahmet Atay", a);
        customer2 = new Customer("David Malakh", b);
        customer3 = new Customer("Omar Elhadad", c);
        teller1 = new Employee("John", "Smith", 29, "Teller", 17000.00);
        teller2 = new Employee("Brian", "Johnson",  46, "Teller", 18000.00);
        teller3 = new Employee("Anders", "Jackson", 17, "Teller", 15000.00);
        president = new Employee("Ronald", "Watson", 65, "President", 290000.00);
        vicePrez = new Employee("Sid", "Stewartson", 34, "Vice President", 130000.00);
    }

    public void fireBigShots() {
        president.fire();
        vicePrez.fire();
    }

    public void giveTellersRaise(double raise) {
        teller1.giveRaise(raise);
        teller2.giveRaise(raise);
        teller3.giveRaise(raise);
    }

    public void replaceBigShots(Employee newPresident, Employee newVicePrez) {
        president = newPresident;
        newPresident.changePosition("President", 250000);
        vicePrez = newVicePrez;
        newVicePrez.changePosition("Vice President", 120000);
    }

    public String getTotalFunds() {
        double totalFunds = 0;
        for (int i = 0; i < customer1.getAllAccounts().size(); i++) {
            if (customer1.getAllAccounts().get(i) == null) {            
                continue;
            }
            else {
                totalFunds += customer1.getAllAccounts().get(i).getBalance();
            }
        }
        for (int i = 0; i < customer2.getAllAccounts().size(); i++) {
            if (customer2.getAllAccounts().get(i) == null) {
                continue;
            }
            else {
                totalFunds += customer2.getAllAccounts().get(i).getBalance();
            }
        }
        for (int i = 0; i < customer3.getAllAccounts().size(); i++) {
            if (customer3.getAllAccounts().get(i) == null) {
                continue;
            }
            else {
                totalFunds += customer3.getAllAccounts().get(i).getBalance();
            }
        }
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("$###,##0.00");
        String sTotalFunds = decimalFormat.format(totalFunds);
        return sTotalFunds;
    }

    public void chargeFees(double fee) {
        customer1.withdrawAll(fee);
        customer2.withdrawAll(fee);
        customer3.withdrawAll(fee);
    }

    public void setInterest(double newInterest) {
        BankAccount.setInterest(newInterest);
    }

    public void addInterest() {
        for (int i = 0; i < customer1.getAllAccounts().size(); i++) {
            if (customer1.getAllAccounts().get(i) == null) {
                continue;
            }     
            else {         
                customer1.depositSingle(Math.abs(customer1.getAllAccounts().get(i).getBalance() * customer1.getBankAccount(1).getInterest()), i + 1);
            }
        } 
        for (int i = 0; i < customer2.getAllAccounts().size(); i++) {
            if (customer2.getAllAccounts().get(i) == null) {
                continue;
            }
            else {
                customer2.depositSingle(Math.abs(customer2.getAllAccounts().get(i).getBalance() * customer2.getBankAccount(1).getInterest()), i + 1);
            }
        }
        for (int i = 0; i < customer3.getAllAccounts().size(); i++) {
            if (customer3.getAllAccounts().get(i) == null) {
                continue;
            }
            else {
                customer3.depositSingle(Math.abs(customer3.getAllAccounts().get(i).getBalance() * customer3.getBankAccount(1).getInterest()), i + 1);
            }
        }
    }

    public void printAllAccounts() {
        customer1.printAccounts();
        customer2.printAccounts();
        customer3.printAccounts();
    }

    public void printCompanyReport() {
        printAllAccounts();
        teller1.print();
        teller2.print();
        teller3.print();
        president.print();
        vicePrez.print();
    }
}
