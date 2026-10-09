package scannerpractice;
import java.util.Scanner;


public class scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        System.out.print("Enter your height: ");
        float height = sc.nextFloat();

        System.out.print("Enter your weight: ");
        float weight = sc.nextFloat();

        sc.nextLine();

        System.out.print("Enter your city: ");
        String city = sc.nextLine();

        System.out.print("Enter your mobile number: ");
        long mobile_number = sc.nextLong();

        System.out.println("\n--- Your Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("City: " + city);
        System.out.println("Mobile Number: " + mobile_number);
	}

}
