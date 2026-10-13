package Loops;

public class nestedloop {
    public static void main(String[] args) {

        for (int round = 1; round <= 3; round++) {

            for (int candidate = 1; candidate <= 3; candidate++) {

                if (round == 1) {
                    System.out.println("Candidate " + candidate + " - Selected for Round 1");
                } 
                else if (round == 2 && candidate <= 2) {
                    System.out.println("Candidate " + candidate + " - Selected for Round 2");
                } 
                else if (round == 3 && candidate == 1) {
                    System.out.println("Candidate " + candidate + " - Selected for Final Interview");
                } 
                else {
                    System.out.println("Candidate " + candidate + " - Not Selected");
                }
            }

            System.out.println("---------------------------");
        }
    }
}
