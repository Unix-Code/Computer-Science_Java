import java.util.Scanner;
public class CommandLine {
    //Employee[] arrayEmployee = new Employee[2]; 
    Employee[] arrayEmployee = {new Employee("John", "Smith", "00-000-0000", 29, "Developer", 37000.00), new Employee("Brian", "Johnson", "00-000-0000", 35, "Manager", 76400)}; 
    public void commandLine() {
        int i = -1;
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print(">");
        String command = userInputScanner.nextLine();
        String commandInput = command;
        String delims = "[ ]+"; // use + to treat consecutive delims as one;
        // omit to treat consecutive delims separately
        String[] tokens = commandInput.split(delims);

        // arrayEmployee[0] = new Employee("John", "Smith", "00-000-0000", 29, "Developer", 37000.00);
        // arrayEmployee[1] = new Employee("Brian", "Johnson", "00-000-0000", 35, "Manager", 76400);
        
        if (tokens.length > 1) {
            try {
                i = Integer.parseInt(tokens[1]) - 1;
            }
            catch (NumberFormatException nfe) {
                for (int j = 0; j < arrayEmployee.length; j++) {
                    if (arrayEmployee[j].getFirst().equalsIgnoreCase(tokens[1]) || arrayEmployee[j].getLast().equalsIgnoreCase(tokens[1])) {
                        i = j;
                        break;
                    }
                    else {
                        i = arrayEmployee.length;
                    }
                }
            }
        }
        
        if (tokens[0].equalsIgnoreCase("help")) {
            System.out.println("\nPossible commands include: getFirst, getLast, getID, printPersonnelReport,\nfire, increaseAge, setID, giveRaise, changePosition\n");
        }
        else if (tokens[0].equalsIgnoreCase("getFirst")) {
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getFirst() + "\n");

            }
        }
        else if (tokens[0].equalsIgnoreCase("quit")) {
            return;
        }
        else if (tokens[0].equalsIgnoreCase("getLast")) {
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getLast() + "\n");
            }
        }
        else if (tokens[0].equalsIgnoreCase("getID")) {
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getID() + "\n");
            }
        }
        else if (tokens[0].equalsIgnoreCase("setID")) {
            if (checkSyntax(i) == true) {
                arrayEmployee[i].setID(tokens[2]);
            }
        }
        else if (tokens[0].equalsIgnoreCase("increaseAge")) {
            if (checkSyntax(i) == true) {
                arrayEmployee[i].increaseAge();
            }
        }
        else if (tokens[0].equalsIgnoreCase("fire")) {
            if (checkSyntax(i) == true) {
                arrayEmployee[i].fire();
            }
        }
        else if (tokens[0].equalsIgnoreCase("giveRaise")) {
            if (checkSyntax(i) == true) {
                try {
                    try {
                        arrayEmployee[i].giveRaise(Integer.parseInt(tokens[2]));
                    } catch (NumberFormatException nfe) {
                        System.out.println("\nError: Invalid Raise\n");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("\nError: No Raise Specified\n");
                }
            }
        }
        else if (tokens[0].equalsIgnoreCase("changePosition")) {
            if (tokens[2].equals("")) {
                System.out.println("\nError: No Title Specified\n");
            }
            else if (tokens[3].equals("")) {
                System.out.println("\nError: No Salary Specified\n");
            }
            else if (!((tokens[2].equals("")) && !(tokens[3].equals("")) && checkSyntax(i) == true)) {
                try {
                    arrayEmployee[i].changePosition(tokens[2], Double.parseDouble(tokens[3]));
                } catch (NumberFormatException nfe) {
                    System.out.println("\nError: Invalid Salary\n");
                }
            }
        }
        else if (tokens[0].equalsIgnoreCase("printPersonnelReport")) {
            for (i = 0; i < arrayEmployee.length; i++) {
                System.out.println("");
                arrayEmployee[i].printPersonnelReport();
                System.out.println("");
            }
        }
        else {
            System.out.println("\nError: Invalid Command Sequence\n");
        }
        commandLine();
    }

    public boolean checkSyntax(int check) {

        if (check == -1) {
            System.out.println("\nError: No Employee Specified\n");
            return false;
        }
        else if (check > (arrayEmployee.length - 1) || check < -1) {
            System.out.println("\nError: No Employee Found\n");
            return false;
        }
        else {
            return true;
        }
    }
}

// public void hireNew() {
//    Employee Employee1 = new Employee("John", "Smith", 29, "Developer", 37000.00);
//    Employee Employee2 = new Employee("Brian", "Johnson", 35, "Manager", 76400);
// } 