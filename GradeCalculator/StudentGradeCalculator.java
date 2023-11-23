package GradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for grade thresholds
        final double A_GRADE_THRESHOLD = 90.0;
        final double B_GRADE_THRESHOLD = 80.0;
        final double C_GRADE_THRESHOLD = 70.0;
        final double D_GRADE_THRESHOLD = 60.0;

        // List of subjects
        String[] subjects = {"Math", "Science", "English", "History", "Computer Science"};

        int totalMarks = 0;

        for (String subject : subjects) {
            System.out.print("Enter marks for " + subject + " (out of 100): ");
            int marks = scanner.nextInt();

            // Validate input marks (assuming a valid range of 0 to 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be in the range of 0 to 100.");
                // Repeat input for the current subject
                subject = scanner.nextLine();
                continue;
            }

            totalMarks += marks;
        }

        // Calculate Total Marks
        double averagePercentage = (double) totalMarks / subjects.length;

        // Grade Calculation
        char grade;

        if (averagePercentage >= A_GRADE_THRESHOLD) {
            grade = 'A';
        } else if (averagePercentage >= B_GRADE_THRESHOLD) {
            grade = 'B';
        } else if (averagePercentage >= C_GRADE_THRESHOLD) {
            grade = 'C';
        } else if (averagePercentage >= D_GRADE_THRESHOLD) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
