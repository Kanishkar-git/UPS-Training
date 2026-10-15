package Patterns;
import java.util.Scanner;

public class PatternT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter T
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if(i==0||j==l/2) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
