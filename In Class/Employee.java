import java.util.*;
public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String idNum;
    private double salary;
    private String title;
    private String inIDNum;

    public Employee() {
        firstName = "";
        lastName = "";
        age = 0;
        idNum = "";
        salary = 0.0;
        title = "";
    }

    public Employee(String inFirstName, String inLastName, int inAge, String inTitle, double inSalary) {
        firstName = inFirstName;
        lastName = inLastName;
        age = inAge;
        idNum = "00-000-0000";
        salary = inSalary;
        title = inTitle;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public String getID() {
        return idNum;
    }

    public void print(){
        System.out.format("Employee %s %s", firstName, lastName);
        System.out.format("\nID: %s", idNum);
        System.out.format("\nAge: %d", age);
        System.out.format("\nTitle: %s", title);
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("$###,##0.00");
        String sSalary = decimalFormat.format(salary);
        System.out.format("\nSalary: %s", sSalary);
        System.out.println("");
    }

    public void fire() {
        title = "terminated";
        salary = 0;
    }

    public void increaseAge() {
        age++;
    }

    public void setID(String IDset) {
        idNum = IDset;
    }

    public void giveRaise(double raise) {
        salary += raise;
    }

    public void changePosition(String titleSet, double salarySet) {
        title = titleSet;
        salary = salarySet;
    }
    
    public void switchPosition(Employee beSwitched) {
        String newTitle = this.title;
        double newSalary = this.salary;
        this.changePosition(beSwitched.getPosition(), beSwitched.getSalary());
        beSwitched.changePosition(newTitle, newSalary);
        
    }
    
    public String getPosition() {
        return title;
    }
    
    public double getSalary() {
        return salary;
    }
}