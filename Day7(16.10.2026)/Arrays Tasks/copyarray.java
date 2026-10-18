package Arrays;

import java.util.Arrays;

public class copyarray {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int[] copy = Arrays.copyOf(arr, arr.length);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Copied Array: " + Arrays.toString(copy));
    }
}
