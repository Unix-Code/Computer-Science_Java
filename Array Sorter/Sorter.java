import java.util.*;
public class Sorter {
    public static int[] sorter(int[] array) {
        int temp;

        for (int j = 0; j < array.length; j ++) { 
            for (int i = (array.length - 1); i > j; i--) {
                if (array[i - 1] > array[i]) { 
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
                // System.out.println(Arrays.toString(array));
            }

        }

        return array;
    }
}
