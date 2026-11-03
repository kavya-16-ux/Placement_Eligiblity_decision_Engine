
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read Candidate details
        System.out.println("Enter the name of student:");
        String name = scanner.next();
        System.out.println("Enter the percentage:");
        double percentage = scanner.nextDouble();
        System.out.println("Enter the number of backlogs:");
        int backlogs = scanner.nextInt();
        System.out.println("Enter the graduation year:");
        int graduationYear = scanner.nextInt();

        // 2. Read Candidate skills
        System.out.println("Enter the number of skills:");
        int skillCount = scanner.nextInt();
        String[] skills = new String[skillCount];

        System.out.println("Enter the skills:");
        for (int i = 0; i < skillCount; i++) {
            skills[i] = scanner.next();
        }

        Candidate candidate = new Candidate(
                name,
                percentage,
                backlogs,
                graduationYear,
                skills
        );

        // 3. Read dynamic Jobs
        System.out.print("Enter total number of jobs to register: ");
        int jobCount = scanner.nextInt();
        Job[] jobs = new Job[jobCount];

        for (int i = 0; i < jobCount; i++) {
            System.out.println("Enter the name of company:");
            String company = scanner.next();
            System.out.println("Enter the role in that company:");
            String role = scanner.next();
            System.out.print("Enter minimum required percentage: ");
            double minimumPercentage = scanner.nextDouble();
            System.out.print("Enter maximum allowed backlogs: ");
            int maximumBacklogs = scanner.nextInt();
            System.out.print("Enter required graduation year: ");
            int requiredGraduationYear = scanner.nextInt();

            System.out.print("Enter number of required skills: ");
            int requiredSkillCount = scanner.nextInt();
            String[] requiredSkills = new String[requiredSkillCount];

            System.out.println("Enter the required skills:");
            for (int j = 0; j < requiredSkillCount; j++) {
                requiredSkills[j] = scanner.next();
            }

            jobs[i] = new Job(
                    company,
                    role,
                    minimumPercentage,
                    maximumBacklogs,
                    requiredGraduationYear,
                    requiredSkills
            );
        }

        // 4. Display available jobs
        System.out.println();
        System.out.println("AVAILABLE JOBS");

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(
                    (i + 1) + ". "
                    + jobs[i].getCompany()
                    + " - "
                    + jobs[i].getRole()
            );
        }

        // 5. Select Job
        System.out.println("Enter the number of job you want to apply:");
        int selectedJobNumber = scanner.nextInt();
        Job selectedJob = jobs[selectedJobNumber - 1];

        // 6. Evaluate via EligibilityChecker
        EligibilityChecker checker = new EligibilityChecker();

        System.out.println();
        System.out.println("================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULT");
        System.out.println("================================");
        System.out.println();

        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + selectedJob.getCompany());
        System.out.println("Role      : " + selectedJob.getRole());
        System.out.println();

        boolean eligible = checker.evaluate(candidate, selectedJob);

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
