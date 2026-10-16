package Arrays;

import java.util.Arrays;

public class comparearrays {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 30};

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }
}
