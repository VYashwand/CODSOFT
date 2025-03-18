import java.util.Scanner;

public class StudentGradeCalculator {

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
            
            double totalMarks = 0;
            
            
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                double marks = scanner.nextDouble();
                totalMarks += marks;
            }
            
            
            double averagePercentage = (totalMarks / (numSubjects * 100)) * 100;
            
            
            String grade = calculateGrade(averagePercentage);
            
            
            System.out.println("\nTotal Marks: " + totalMarks + " / " + (numSubjects * 100));
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
            System.out.println("Grade: " + grade);
        }
    }
}