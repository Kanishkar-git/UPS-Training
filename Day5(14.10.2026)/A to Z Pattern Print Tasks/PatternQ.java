package Patterns;
import java.util.Scanner;

public class PatternQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter Q
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if(i==0||i==l-1||j==0||j==l-1||(i==j && i>=l/2)) {
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
