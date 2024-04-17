/*Welcome to Jane's Grading App. This program would calculate the student's grade and evaluate the remarks if she/he passed the midterm or final
 *Written by: Janelie S. Blanco BSCS 1A */
import java.text.DecimalFormat;
import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        //Variable declarations
        float quizG, labWork, midtermExam, finalExam, Grade = 0;
        char response;
        boolean decision = true;
        int option;
        final double QUIZ_PERCENTAGE = 0.20;
        final double LABW_PERCENTAGE = 0.40;
        final double MAJOREXAM_PERCENTAGE = 0.40;
        final double PASSING_GRADE = 3.0;
        Scanner scan = new Scanner(System.in);
        DecimalFormat numform = new DecimalFormat("0.0"); // To format output

        System.out.print("Are you excited to see your grade [Press Y for yes and N for no]? "); // Prompt the user
        response = scan.next().toUpperCase().charAt(0);

        if (response == 'Y') {
            System.out.println("That's good. Let's proceed then!");
            decision = true;
        } else if (response == 'N') {
            System.out.println("No pressure. Take your time and try again later!");
            decision = false;
        } else {
            System.out.println("Try again. Press only Y or N");
            decision = false;
        }

        while (decision) {
            System.out.println("\n\tGRADING SYSTEM");
            System.out.println("Options:");
            System.out.println("Press [1] to Compute Midterm Grade");
            System.out.println("Press [2] to Compute Final Grade");
            System.out.println("Press [3] to Quit App");
            System.out.print("Press [1], [2], [3]: ");
            option = scan.nextInt();

            switch (option) {
                case 1: // Computes the midterm grade
                    System.out.print("Enter your Quiz Grade: ");
                    quizG = scan.nextFloat();
                    System.out.print("Enter your Labworks Grade: ");
                    labWork = scan.nextFloat();
                    System.out.print("Enter your Midterm Exam Grade: ");
                    midtermExam = scan.nextFloat();

                    // Calculates the grade
                    quizG *= QUIZ_PERCENTAGE;
                    labWork *= LABW_PERCENTAGE;
                    midtermExam *= MAJOREXAM_PERCENTAGE;
                    Grade = quizG + labWork + midtermExam;
                    System.out.println("Your Midterm Grade is: " + numform.format(Grade)); // Print the midterm grade
                    break;

                case 2: // Computes the final grade
                    System.out.print("Enter your Quiz Grade: ");
                    quizG = scan.nextFloat();
                    System.out.print("Enter your Labworks Grade: ");
                    labWork = scan.nextFloat();
                    System.out.print("Enter your Final Exam Grade: ");
                    finalExam = scan.nextFloat();

                    // Calculates the grade
                    quizG *= QUIZ_PERCENTAGE;
                    labWork *= LABW_PERCENTAGE;
                    finalExam *= MAJOREXAM_PERCENTAGE;
                    Grade = quizG + labWork + finalExam;
                    System.out.println("Your Final Grade is: " + numform.format(Grade));
                    break;

                case 3: // Exit the program
                    System.out.println("The program has stopped. Thank you for using Jane's Grading App!");
                    decision = false;
                    break;

                default: // Invalid option
                    System.out.println("Invalid option. Choose only the given options above.");
                    System.exit(0);
                    break;
            }

            // Evaluate the grade and print remarks
            if (Grade > 5.0 || Grade < 1.0)
                System.out.println("Try again. There is no grade above 5.0 and below 1.0");
            else if (Grade > PASSING_GRADE)
                System.out.println("You FAILED. Better luck next time!");
            else 
                System.out.println("CONGRATULATIONS. YOU PASSED!");     
        }
    }
}
