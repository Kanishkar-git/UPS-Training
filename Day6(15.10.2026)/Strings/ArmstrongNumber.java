import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Negative numbers are not Armstrong numbers");
        } else {
            int original = n;
            int digits = String.valueOf(n).length();
            int temp = n;
            int sum = 0;

            while (temp > 0) {
                int digit = temp % 10;
                sum += (int) Math.pow(digit, digits);
                temp /= 10;
            }

            if (original == sum) {
                System.out.println("It is an Armstrong number");
            } else {
                System.out.println("It is not an Armstrong number");
            }
        }

        sc.close();
    }
}
