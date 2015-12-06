public class Base10Converter {
    public void convert(int numStart, int base) {
        int start = numStart;
        int temp;
        String endNum = "";
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                         'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                         'W', 'X', 'Y', 'Z'};
        if (!(base > 1 && base <= 36)) {
            System.out.println("Error: Invalid Base");
            return;
        }
        
        while (Math.abs(start) > 0) {
            temp = start%base;
            endNum = digits[temp] + endNum;
            start /= base;
        }
        
        System.out.println("Start: " + numStart + "\nEnd: " + endNum);
                         
    }
}