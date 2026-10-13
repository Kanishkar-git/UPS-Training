package switchcase;

import java.util.Scanner;

public class GradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your mark: ");
        int mark = sc.nextInt();

        switch (mark / 10) {
            case 10:
            case 9:
                System.out.println("Grade A");
                break;

            case 8:
                System.out.println("Grade B");
                break;

            case 7:
                System.out.println("Grade C");
                break;

            case 6:
                System.out.println("Grade D");
                break;

            case 5:
                System.out.println("Grade E");
                break;

            default:
                if (mark >= 0 && mark < 50) {
                    System.out.println("Fail");
                } else {
                    System.out.println("Invalid mark");
                }
        }

        sc.close();
    }
}
