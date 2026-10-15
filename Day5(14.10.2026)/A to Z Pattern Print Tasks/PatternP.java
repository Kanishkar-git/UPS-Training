package Patterns;
import java.util.Scanner;

public class PatternP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        // Letter P
        for(int i=0;i<l;i++) {
            for(int j=0;j<l;j++) {
                if(j==0||i==0||i==l/2||(j==l-1 && i<=l/2)) {
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
