import java.util.Scanner;
class demo3 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter your name: ");
String name = sc.nextLine();
System.out.println("My name is " + name);
sc.close();
}
}