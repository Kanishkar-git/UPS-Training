package Tasks;

import java.util.Scanner;

public class tempconverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Fahrenheit to Celsius : ");
		
		System.out.print("Enter temperature in Fahrenheit: ");
		float f = sc.nextFloat();
		
		float c = (f - 32) * 5 / 9;
		
		System.out.println("Temperature in Celsius: " + c);
				
	}

}
