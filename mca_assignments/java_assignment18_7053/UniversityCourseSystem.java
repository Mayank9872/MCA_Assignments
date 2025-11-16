abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
    public String toString() { return name; }
}

class ExamCourse extends CourseType {
    ExamCourse() { super("Exam-Based"); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() { super("Assignment-Based"); }
}

class ResearchCourse extends CourseType {
    ResearchCourse() { super("Research-Based"); }
}

class Course<T extends CourseType> {
    private String courseName;
    private T type;

    Course(String courseName, T type) {
        this.courseName = courseName;
        this.type = type;
    }

    public String toString() {
        return courseName + " | " + type;
    }
}

class CourseUtil {
    static void displayCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c);
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        List<CourseType> courses = new ArrayList<>();
        courses.add(new ExamCourse());
        courses.add(new AssignmentCourse());
        courses.add(new ResearchCourse());

        CourseUtil.displayCourses(courses);
    }
}
