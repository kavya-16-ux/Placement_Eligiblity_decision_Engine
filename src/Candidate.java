
public class Candidate {

    // 1. Private fields (prevent direct external access)
    private String name;
    private double percentage;
    private int backlogs;
    private int graduationYear;

    // 2. Constructor to initialize all fields
    public Candidate(
            String name,
            double percentage,
            int backlogs,
            int graduationYear
    ) {
        this.name = name;
        this.percentage = percentage;
        this.backlogs = backlogs;
        this.graduationYear = graduationYear;
    }

    // 3. Getter methods for controlled read access
    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public int getGraduationYear() {
        return graduationYear;
    }
}
