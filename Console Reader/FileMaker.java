import java.io.*;
import java.util.*;
public class FileMaker {
    public static void main(String args[]) throws IOException {
        FileWriter out = null;
        out = new FileWriter("F:/Computer Science _ Local/Console Reader/output.txt", false);
        //BufferedWriter out = new BufferedWriter(new FileWriter("F:/Computer Science _ Local/Console Reader/output.txt", false));
        System.out.print("Enter text, '/q' to quit.\n");
        ArrayList<String> text = new ArrayList<String>();

        Scanner userInputScanner = new Scanner(System.in);
        String input = userInputScanner.nextLine();
        while(!(input.equals("/q"))) {
            out.write(input + "\r\n");
            //out.newLine();
            input = userInputScanner.nextLine();
        }

        // Ending Sequence
        // out.flush();
        out.close();
        System.out.println("\fFile Write Terminated");
        try {
            Thread.sleep(1250);                 //1000 milliseconds is one second.
        }  catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\f");
        return;

    }
}
