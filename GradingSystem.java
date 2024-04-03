/*Welcome to Jane's Grading App. This program would calculate the student's grade and evaluate the remarks if she/he passed the midterm or final
 * Written by: Janelie S. Blanco BSCS 1A */
import java.text.DecimalFormat;
import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args){
        //variable declarations
        float quizG, labWork, midtermExam, finalExam, Grade = 0;
        char response;
        boolean decision = true;
        int option;
        String RED = "\u001B[31m", GREEN = "\u001B[32m", RESET = "\u001B[0m"; //ANSI color codes for console text :>
        final double QUIZ_PERCENTAGE = 0.20;
        final double LABW_PERCENTAGE = 0.40;
        final double MAJOREXAM_PERCENTAGE = 0.40;
        final double PASSING_GRADE = 3.0;
        Scanner scan = new Scanner(System.in);
        DecimalFormat numform = new DecimalFormat("0.0"); //to make it one decimal place only

        System.out.print("Are you excited to see you grade [Press Y for yes and N for no]? "); //prompt the user
        response = scan.next().toUpperCase().charAt(0);
        
        if (response == 'Y'){
            System.out.println("That's good. Let's proceed then!");
            decision = true;  
        } else if (response == 'N'){
            System.out.println("No pressure. Take your time and try again later!");
            decision = false;
            return; //exit the program if the user is not excited to see its grade
        } else {
            System.out.println(RED + "Try again. Press only Y or N" + RESET);
            return; //exit if the input is invalid
        }
        
        do{
            System.out.println("\n\tGRADING SYSTEM");
            System.out.println("Options:");
            System.out.println("Press [1] to Compute Midterm Grade");
            System.out.println("Press [2] to Compute Final Grade");
            System.out.println("Press [3] to Quit App");
            System.out.print("Press [1], [2], [3]: ");
            option = scan.nextInt();

            switch (option){
                case 1: //computes the midterm grade
                    System.out.print("Enter your Quiz Grade: ");
                    quizG = scan.nextFloat();
                    System.out.print("Enter your Labworks Grade: ");
                    labWork = scan.nextFloat();
                    System.out.print("Enter your Midterm Exam Grade: ");
                    midtermExam = scan.nextFloat();
                    
                    //calculates the grade
                    quizG *= QUIZ_PERCENTAGE;
                    labWork *= LABW_PERCENTAGE;
                    midtermExam *= MAJOREXAM_PERCENTAGE;
                    Grade = quizG + labWork + midtermExam;
                    System.out.println("Your Midterm Grade is: " + numform.format(Grade)); //print the midT grade
                    break;

                case 2:
                    //calculates the final grade
                    System.out.print("Enter your Quiz Grade: ");
                    quizG = scan.nextFloat();
                    System.out.print("Enter your Labworks Grade: ");
                    labWork = scan.nextFloat();
                    System.out.print("Enter your Final Exam Grade: ");
                    finalExam = scan.nextFloat();

                    //calculates the grade
                    quizG *= QUIZ_PERCENTAGE;
                    labWork *= LABW_PERCENTAGE;
                    finalExam *= MAJOREXAM_PERCENTAGE;
                    Grade = quizG + labWork + finalExam;
                    System.out.println("Your Final Grade is: " + numform.format(Grade));
                    break;

                case 3: //exit the program 
                    System.out.println("The program has stopped. Thank you for using Jane's Grading App!");
                    System.exit(0);
                    break;
            }
                    if(Grade > PASSING_GRADE){ //evaluates the grade and prints its remarks
                        if(Grade > 5.0)
                            System.out.println(RED + "Try again. There is no grade above 5.0" + RESET);
                        else
                            System.out.println(RED + "You FAILED. Better luck next time!" + RESET);  
                    } 
                    else 
                        System.out.println(GREEN + "CONGRATULATIONS. YOU PASSED!" + RESET);
        } while(decision); //loop continues as long as the decision is true
    }
}    
