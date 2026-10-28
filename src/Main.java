
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.println("Enter the name of student:");
        String name = scanner.next();
        System.out.println("Enter the percentage:");
        double percentage = scanner.nextDouble();
        System.out.println("Enter the backlogs:");
        int backlogs = scanner.nextInt();
        System.out.println("Enter the graduation year:");
        int graduationYear = scanner.nextInt();

        // Create the Candidate object
        Candidate candidate = new Candidate(
                name,
                percentage,
                backlogs,
                graduationYear
        );

        // Print values using getter methods
        System.out.println("Candidate: " + candidate.getName());
        System.out.println("Percentage: " + candidate.getPercentage());
        System.out.println("Backlogs: " + candidate.getBacklogs());
        System.out.println("Graduation Year: " + candidate.getGraduationYear());

        scanner.close();
    }
}
