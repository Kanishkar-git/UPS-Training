package Arrays;
import java.util.Scanner;
public class arrayinput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter array size:");
	     int n = sc.nextInt();
	     
	     int[] arr = new int[n];

	     System.out.println("Enter array elements:");

	     for (int i = 0; i < arr.length; i++) {
	            arr[i] = sc.nextInt();
	        }
	     
	     System.out.println("Array elements:");

	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
		

	}

}
