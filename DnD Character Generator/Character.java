import java.io.*;
public class Character {
    private String charName;
    private String charRace;
    private String gender;
    private int age;
    private String charClass;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;
    private int armour;

    public Character() {
        charName = "Legolas";
        charRace = "Elf";
        age = 2931;
        gender = "Male";
        charClass = "Ranger";
        strength = 12;
        constitution = 10;
        dexterity = 18;
        intelligence = 12;
        wisdom = 12;
        charisma = 12;
        armour = 5;
        hitpoints = constitution + armour;

    }

    public Character(String name, String race, int charAge, String sClass, String sex, int str, int con, int dex, int intel, int wis, int cha, int arm) {
        charName = name;
        charRace = race;
        age = charAge;
        charClass = sClass;
        armour = arm; 
        gender = sex;
        if (strength < 21 || constitution < 21 || dexterity < 21 || intelligence < 21 || wisdom < 21 || charisma < 21) {
            strength = str;
            constitution = con;
            dexterity = dex;
            intelligence = intel;
            wisdom = wis;
            charisma = cha;
            hitpoints = constitution + armour;
        }
        else {
            System.err.print("Error: Attributes Exceed Limit, Cheater.");
        }
    }

    public String getname() {
        return charName;
    }

    public int getstr(){
        return strength;
    }

    public int getcon(){
        return constitution;
    }

    public int getdex(){
        return dexterity;
    }

    public int getintel() {
        return intelligence;
    }

    public int gethealth() {
        return hitpoints;
    }

    public int getarm() {
        return armour;
    }

    public void printCharacterSheet() {
        System.out.format("\f%s, the %d year old %s %s", charName, age, charRace, charClass);
        System.out.println((gender.equalsIgnoreCase("Male")) ? "\n\nHis Stats:" : "\n\nHer Stats:");
        System.out.format("\nStrength: %d\nConstitution: %d\nDexterity: %d\nIntelligence: %d\nWisdom: %d\nCharisma: %d\nHitpoints: %d\nArmour: %d\n",
            strength, constitution, dexterity, intelligence, wisdom, charisma, hitpoints, armour);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("\\Computer Science_Java\\DnD Character Generator\\Saves\\" + charName + "_Save.txt"), "utf-8"))) {
            writer.write(charName + ", the " + age + " year old " + charRace + " " + charClass);
            writer.write((gender.equalsIgnoreCase("Male")) ? "\r\n\r\nHis Stats:" : "\r\n\r\nHer Stats:");
            writer.write("\r\n\r\n\tStrength: " + strength + "\r\n\tConstitution: " + constitution + "\r\n\tDexterity: " + dexterity
                + "\r\n\tIntelligence: " + intelligence + "\r\n\tWisdom: " + wisdom 
                + "\r\n\tCharisma: " + charisma + "\r\n\tHitpoints: " + hitpoints + "\r\n\tArmour: " + armour + "\r\n");
            writer.close();
        } catch (IOException e) {
            System.err.print("Error: Could not write save");
        }
    }
}

       