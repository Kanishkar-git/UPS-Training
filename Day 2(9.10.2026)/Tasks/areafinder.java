package Tasks;

import java.util.Scanner;

public class areafinder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter details of Rectangle: ");

        System.out.println("Enter length: ");
        float length = sc.nextFloat();

        System.out.print("Enter breadth: ");
        float breadth = sc.nextFloat();

        float area = length * breadth;

        System.out.println("Area of Rectangle: " + area);
        
        
        System.out.print("Enter details of Square: ");
        
        System.out.print("Enter side: ");
        float side = sc.nextFloat();
        
        float squarearea=side*side;
        
        System.out.println("Area of Square: " + squarearea);
        
        
        

  
    }
}

