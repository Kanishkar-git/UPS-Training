package Patterns;
import java.util.Scanner;

public class PatternX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter X
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if(i + j == l - 1 || i==j) {
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
