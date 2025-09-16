class Course {
    String courseName;
    int duration; // in weeks
    double fee;
    static String instituteName = "ABC Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 12, 5000);
        Course c2 = new Course("Python Programming", 10, 4500);

        System.out.println("Before Institute Name Change:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        Course.updateInstituteName("XYZ Academy");

        System.out.println("\nAfter Institute Name Change:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
