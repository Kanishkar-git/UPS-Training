package Methods;
import java.util.Scanner;

public class sortanarray {
	static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);

        System.out.print("Sorted array: ");
        
        for (int x : arr) {
            System.out.print(x + " ");
        }

	}

}
