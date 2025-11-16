abstract class JobRole {
    String name;
    JobRole(String name) { this.name = name; }
    public String toString() { return name; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    private String applicant;
    private T role;

    Resume(String applicant, T role) {
        this.applicant = applicant;
        this.role = role;
    }

    public String toString() {
        return applicant + " | " + role;
    }
}

class ScreeningUtil {
    static void screenResumes(List<? extends JobRole> roles) {
        for (JobRole r : roles) {
            System.out.println(r);
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        ScreeningUtil.screenResumes(jobRoles);
    }
}
