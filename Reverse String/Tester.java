import java.util.*;
public class Tester {
    public void main() {
        Scanner userInputScanner = new Scanner(System.in);
        String sString = userInputScanner.nextLine();
        test(sString);
    }

    public void test(String inputted) {
        Reverse Reversing = new Reverse();
        String result = Reversing.reverser(inputted);
        System.out.println("Input String >" + inputted + "<" + "\nOutput String: >" + result + "<");
    }
}