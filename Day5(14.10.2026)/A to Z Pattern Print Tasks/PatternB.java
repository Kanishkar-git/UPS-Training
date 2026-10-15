package Patterns;
import java.util.Scanner;

public class PatternB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter B
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if(i==0||j==0||i==l-1||i==l/2||j==l-1) {
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
