
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read candidate data in sequence
        System.out.println("Enter the name of student:");
        String name = scanner.next();
        System.out.println("Enter the percentage:");
        double percentage = scanner.nextDouble();
        System.out.println("Enter the backlogs:");
        int backlogs = scanner.nextInt();
        System.out.println("Enter the graduation year:");
        int graduationYear = scanner.nextInt();

        // Display read values
        System.out.println("Candidate: " + name);
        System.out.println("Percentage: " + percentage);
        System.out.println("Backlogs: " + backlogs);
        System.out.println("Graduation Year: " + graduationYear);

        scanner.close();
    }
}
