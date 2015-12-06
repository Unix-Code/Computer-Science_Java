public class Reverse {
    public static String reverser(String input){
    String output = "";
    for (int i = input.length()-1; i >= 0; i--) {
        output += Character.toString(input.charAt(i));
    }
    return output;
    }
}