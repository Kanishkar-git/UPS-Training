import java.util.Scanner;

public class usingscannerresume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your city: ");
        String city = sc.nextLine();

        System.out.print("Enter your marks: ");
        float marks = sc.nextFloat();

        System.out.print("Enter your height (cm): ");
        double height = sc.nextDouble();

        System.out.print("Enter your weight (kg): ");
        double weight = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter your mobile number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter your qualification: ");
        String qualification = sc.nextLine();

        System.out.print("Enter your college name: ");
        String college = sc.nextLine();

        System.out.print("Enter your skills: ");
        String skills = sc.nextLine();

        System.out.println("\n========== MY RESUME ==========");
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age);
        System.out.println("City          : " + city);
        System.out.println("Marks         : " + marks);
        System.out.println("Height        : " + height + " cm");
        System.out.println("Weight        : " + weight + " kg");
        System.out.println("Mobile Number : " + mobile);
        System.out.println("Qualification : " + qualification);
        System.out.println("College       : " + college);
        System.out.println("Skills        : " + skills);
        System.out.println("================================");

        sc.close();
    }
}
