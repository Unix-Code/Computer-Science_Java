import java.util.*;
public class CommandLine2 {
    Employee[] arrayEmployee = {new Employee("John", "Smith", "00-000-0000", 29, "Developer", 37000.00), new Employee("Brian", "Johnson", "00-000-0000", 35, "Manager", 76400)}; 
    public void commandLine() {
        int i = -1;

        Scanner userInputScanner = new Scanner(System.in);
        System.out.print(">");
        String command = userInputScanner.nextLine();

        String[] tokens = command.split("[ ]+");
        Map<String, Integer> EmployeeName = new HashMap<String, Integer>();
        for (int t = 0; t < arrayEmployee.length; t++) {
            EmployeeName.put(arrayEmployee[t].getFirst().toLowerCase(), t);
            EmployeeName.put(arrayEmployee[t].getLast().toLowerCase(), t);
        }
        if (tokens.length > 1) {
            try {
                i = Integer.parseInt(tokens[1]) - 1;
            } catch (NumberFormatException e) {
                try {
                    i = EmployeeName.get(tokens[1].toLowerCase());
                } catch (NullPointerException f) {
                    i = arrayEmployee.length;
                }
            }
        }

        switch (tokens[0].toLowerCase()) {
            case "help" :
            System.out.println("\nPossible commands include: getFirst, getLast, getID, printPersonnelReport,\nfire, increaseAge, setID, giveRaise, changePosition\n");
            break;

            case "getfirst" :
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getFirst() + "\n");
            }
            break;

            case "quit" :
            return;

            case "getlast" :
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getLast() + "\n");
            }
            break;
            case "getid" :
            if (checkSyntax(i) == true) {
                System.out.println("\n" + arrayEmployee[i].getID() + "\n");
            }
            break;

            case "setid" :
            if (checkSyntax(i) == true) {
                arrayEmployee[i].setID(tokens[2]);
            }
            System.out.println("");
            break;

            case "increaseage" :
            if (checkSyntax(i) == true) {
                arrayEmployee[i].increaseAge();
            }
            System.out.println("");
            break;

            case "fire" :
            if (checkSyntax(i) == true) {
                arrayEmployee[i].fire();
            }
            System.out.println("");
            break;

            case "giveraise" :
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
            System.out.println("");
            break;

            case "changeposition" :
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
            System.out.println("");
            break;

            case "printpersonnelreport" :
            for (i = 0; i < arrayEmployee.length; i++) {
                System.out.println("");
                arrayEmployee[i].printPersonnelReport();
                System.out.println("");
            }
            break;

            case "print" :
            if (checkSyntax(i) == true) {
                System.out.println("");
                arrayEmployee[i].printPersonnelReport();
                System.out.println("");
            }
            break; 

            default :
            System.out.println("\nError: Invalid Command Sequence\n");
            break;
        }

        commandLine();
    }

    public boolean checkSyntax(int check) {
        if (check == -1) {
            System.out.println("\nError: No Employee Specified\n");
            return false;
        }
        else if ((check > (arrayEmployee.length - 1) || check < 0 ) &&  check != -1) {
            System.out.println("\nError: No Employee Found\n");
            return false;
        }
        else {
            return true;
        }
    }
}