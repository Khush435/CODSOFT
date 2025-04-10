import java.util.Scanner;

public class StudentGrade 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        int marks[] = new int[numSubjects];
        int total = 0;

        for (int i = 0; i < numSubjects; i++) 
        {
            System.out.print("Enter marks (out of 100) for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) 
            {
                System.out.println("Invalid marks. Please enter between 0 and 100.");
                i--; 
            } 
            else 
            {
                total += marks[i];
            }
        }

        double percentage = (double) total / numSubjects;

        String grade;
        if (percentage >= 90) 
            grade = "A+";
        else if (percentage >= 80) 
            grade = "A";
        else if (percentage >= 70) 
            grade = "B";
        else if (percentage >= 60) 
            grade = "C";
        else if (percentage >= 50) 
            grade = "D";
        else 
            grade = "F (Fail)";
        
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
    }
}
