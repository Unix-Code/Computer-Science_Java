import java.util.*;
public class Creator {
    private String name;
    private String race;
    private int charAge;
    private String sex;
    private String sClass;
    private int str;
    private int con;
    private int dex;
    private int intel;
    private int wis;
    private int cha;
    private int arm;

    public void create() {
        Random RandomNum = new Random();

        int[] randValue = new int[6];
        for (int i = 0; i < randValue.length; i++) {
            randValue[i] = RandomNum.nextInt(20) + 1;
        }
        str = randValue[0];
        con = randValue[1];
        dex = randValue[2];
        intel = randValue[3];
        wis = randValue[4];
        cha = randValue[5];

        Scanner Scan = new Scanner(System.in);

        boolean validInput = false;
        while (validInput != true) {
            System.out.println("\fWhat is your Character's Name?");
            name = Scan.nextLine();
            if (name.length() > 2) {
                validInput = true;
            }
            else {
                validInput = false;
            }
        }

        validInput = false;
        while (validInput != true) {
            System.out.println("\fWhat is " + name + "'s Gender?");
            sex = Scan.nextLine();
            if (sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female") || name.equalsIgnoreCase("Prazzly Dazzling")) {
                validInput = true;
            }
            else {
                validInput = false;
            }
        }
        
        validInput = false;
        while (validInput != true) {
            System.out.println("\fWhat is " + name + "'s Race?");
            race = Scan.nextLine();
            if (race.length() > 2) {
                validInput = true;
            }
            else {
                validInput = false;
            }
        }

        validInput = false;
        while (validInput != true) {
            try {
                System.out.println("\r\fWhat is " + name + "'s Age?");
                charAge = Integer.parseInt(Scan.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }
        
        validInput = false;
        while (validInput != true) {
            System.out.println("\fWhat is " + name + "'s Class?");
            sClass = Scan.nextLine();
            if (sClass.length() > 2) {
                validInput = true;
            }
            else {
                validInput = false;
            }
        }
        
        System.out.println("\fWhat level of armour is " + name + " wearing?");

        Character PlayerChar = new Character(name, race, charAge, sClass, sex,
                str, con, dex, intel, wis, cha, arm);

        PlayerChar.printCharacterSheet();
    }
}