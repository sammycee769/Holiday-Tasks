public class StudentGrade {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = input.nextInt();

        int[][] scores = new int[students][subjects];

        // Collect scores
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


        System.out.println("\nCLASS SUMMARY");

        for (int count = 0; count < students; count++) {
            int total = 0;

            for (int counter = 0; counter < subjects; counter++) {
                total += scores[count][counter];
            }

            double average = (double) total / subjects;

            System.out.println(
                "Student " + (count + 1) +
                " | Total: " + total +
                " | Average: " + String.format("%.2f", average)
            );
        }

    }
}

