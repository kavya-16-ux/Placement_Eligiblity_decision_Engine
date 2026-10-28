
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of student:");
        String name = scanner.next();
        System.out.println("Enter the percentage:");
        double percentage = scanner.nextDouble();
        System.out.println("Enter the backlogs:");
        int backlogs = scanner.nextInt();
        System.out.println("Enter the graduation year:");
        int graduationYear = scanner.nextInt();

        Candidate candidate = new Candidate(
                name,
                percentage,
                backlogs,
                graduationYear
        );

        Job job = new Job(
                "Infosys",
                "Java Developer",
                65.0,
                0,
                2026
        );

        EligibilityRule[] rules = {
            new PercentageRule(),
            new BacklogRule(),
            new GraduationYearRule()
        };

        System.out.println("================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULT");
        System.out.println("================================");
        System.out.println();

        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + job.getCompany());
        System.out.println("Role      : " + job.getRole());
        System.out.println();

        boolean eligible = true;

        for (int i = 0; i < rules.length; i++) {
            boolean passed = rules[i].check(candidate, job);

            if (passed) {
                System.out.println(rules[i].getRuleName() + " : PASS");
            } else {
                System.out.println(rules[i].getRuleName() + " : FAIL");
                eligible = false;
            }
        }

        System.out.println();

        if (eligible) {
            System.out.println("Final Result : ELIGIBLE");
        } else {
            System.out.println("Final Result : NOT ELIGIBLE");
        }

        System.out.println("================================");

        scanner.close();
    }
}
