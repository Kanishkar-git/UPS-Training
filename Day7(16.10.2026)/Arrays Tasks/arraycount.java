
package Arrays;

import java.util.Scanner;

public class arraycount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int even = 0, odd = 0, prime = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            int count = 0;

            if (arr[i] > 1) {
                for (int j = 1; j <= arr[i]; j++) {
                    if (arr[i] % j == 0) {
                        count++;
                    }
                }

                if (count == 2) {
                    prime++;
                }
            }
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        System.out.println("Prime numbers: " + prime);

        sc.close();
    }
}
