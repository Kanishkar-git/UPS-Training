import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci terms: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number of terms");
        } else {
            int a = 0;
            int b = 1;

            for (int i = 1; i <= n; i++) {
                System.out.print(a);
                if (i < n) {
                    System.out.print(" ");
                }

                int next = a + b;
                a = b;
                b = next;
            }
            System.out.println();
        }

        sc.close();
    }
}
