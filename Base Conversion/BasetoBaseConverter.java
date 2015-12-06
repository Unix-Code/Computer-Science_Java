import java.util.*;
public class BasetoBaseConverter {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        BasetoBaseConverter Run = new BasetoBaseConverter();
        
        System.out.println("\fWhat number would you like to convert?");
        String input = Scan.nextLine();
        String start = input;
        
        System.out.println("\nWhat base is this number in?");
        int input2 = Scan.nextInt();
        int startBase = input2;
        
        System.out.println("\nWhat base would you like to convert to?");
        int input3 = Scan.nextInt();
        int endBase = input3;
        
        String end = Run.finalConvert(Run.primeConvert(start, startBase), endBase);
        System.out.println("\nStart: " + start + "\nEnd: " + end);
        // System.out.format("Start: %s in base %n \nEnd: %s in base %n\n", start, startBase, end, endBase);
    }
    
    public int primeConvert(String numStart, int base) {
        String start = numStart.toUpperCase();
        int endNum = 0;
        char placeValue;
        int temp = 0;
        int power = 0;
        for (int i = start.length() - 1; i > -1; i--) {
            placeValue = start.charAt(i);
            
            if ((int)placeValue >= (int)'0' && (int)placeValue <= (int)'9') {
                temp = (int)placeValue - (int)'0';
            }
            else if ((int)placeValue >= (int)'A' && (int)placeValue <= (int)'Z') {
                temp = 10 + ((int)placeValue - (int)'A');
            }
            if (temp >= base) {
                System.err.print("Error: Place Value " + "(" + placeValue + ") Greater Than Base " + base + " Allows");
                System.exit(0);
            }
            endNum += temp * Math.pow(base, power);
            power++;
        }
        
        //System.out.println("Start: " + start + " in base " + base + "\nEnd: " + endNum); 
        return endNum;
    }
    
    public String finalConvert(int numStart, int base) {
        int start = numStart;
        int temp;
        String endNum = "";
        /*char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                         'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                         'W', 'X', 'Y', 'Z'};*/
        if (!(base > 1 && base <= 36)) {
            System.err.print("Error: Invalid Base");
            System.exit(0);
        }
        
        char tempChar = ' ';
        while (Math.abs(start) > 0) {
            temp = start%base;
            if (temp <= 9) {
                tempChar = (char)(temp + (int)'0');
            }
            else if (temp >= 10) {
                tempChar = (char)((temp - 10) + (int)'A');
            }
            endNum = tempChar + endNum;
            start /= base;
        }
        
        //System.out.println("Start: " + numStart + "\nEnd: " + endNum);
        return endNum;                 
    }
}