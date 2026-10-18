import java.util.Scanner;

public class Factorial {
    public static long factorial(int num) {
        if (num < 0) {
            return -1; // Negative numbers do not have a factorial.
        }

        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers");
        } else if (n > 20) {
            System.out.println("Number is too large for a long factorial result");
        } else {
            System.out.println("Factorial of " + n + " is " + factorial(n));
        }

        sc.close();
    }
}
