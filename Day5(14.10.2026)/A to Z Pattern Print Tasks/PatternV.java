package Patterns;
import java.util.Scanner;

public class PatternV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter V
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if((i==j && i<=l/2)||(i+j==l-1 && i<=l/2)) {
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
