public class StudentGrade {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = input.nextInt();
        
        System.out.println("\nSaving ................ ");
        System.out.println("Saved succesfully");

        int[][] scores = new int[students][subjects];
        int[] totals = new int[students];
        double[] averages = new double[students];
        int[] position = new int[students];

        for (int count = 0; count < students; count++) {
            System.out.println("\nEntering scores for Student " + (count + 1));

            for (int counter = 0; counter < subjects; counter++) {
                int score;

                while (true) {
                    System.out.print("Subject " + (counter + 1) + " score: ");
                    score = input.nextInt();

                    if (score >= 0 && score <= 100) {
                        break;
                    } else {
                        System.out.println("Score must be between 0 and 100. Try again.");
                    }
                }

                scores[count][counter] = score;
            }
        }
         for (int count = 0; count < students; count++) {
                    int sum = 0;
                    for (int counter = 0; counter < subjects; counter++) {
                        sum += scores[count][counter];
                    }
                    totals[count] = sum;
                    averages[count] = (double) sum / subjects;
                }

       for (int positionCount = 0; positionCount < students; positionCount++) {
            position[positionCount] = 1;
            for (int positionCounter = 0; positionCounter < students; positionCounter ++) {
                if (totals[positionCounter] > totals[positionCount]) {
                    position[positionCount]++;
                }
            }
                }

        System.out.println("=".repeat(60));
        System.out.printf("%-10s","STUDENT");

        for (int count = 0; count < subjects; count++) {
            System.out.printf(" %5s", "SUB" + (count + 1));
        }
        System.out.printf(" %6s %7s %5s%n", "TOT", "AVE", "POS");
        System.out.println("=".repeat(60));
        for (int count = 0; count < students; count++) {
            System.out.printf("%-10s", "Student " + (count + 1));

            for (int counter = 0; counter < subjects; counter++) {
                System.out.printf(" %5d", scores[count][counter]);
            }

            System.out.printf(
                " %6d %7.2f %5d%n",
                totals[count],
                averages[count],
                position[count]
            );
        }

        System.out.println("=".repeat(60));
}
}

