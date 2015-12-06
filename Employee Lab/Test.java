import java.util.*;
public class Test {
    public static void main(String [] args) {
        Employee e1 = new Employee("John", "Smith", "00-000-0000", 29, "Developer", 37000.00);
        Employee e2 = new Employee("Brian", "Johnson", "00-000-0000", 35, "Manager", 76400);
        Random rand = new Random();
        int temp;
        Employee x;
        for (int i = 0; i < 6; i++) {
            temp = rand.nextInt(2) + 1;
            if (temp == 1) {
                x = e1;
            }
            else {
                x = e2;
            }
            x.printPersonnelReport();
        }
    }
}