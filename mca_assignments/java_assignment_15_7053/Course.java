import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
        System.out.println();
    }
}

class Student {
    String name;
    ArrayList<Course> courses;

    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void enroll(Course c) {
        courses.add(c);
        c.addStudent(this);
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println(" - " + c.courseName);
        }
        System.out.println();
    }
}

class School {
    String schoolName;
    ArrayList<Student> students;

    School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Green Valley School");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);

        school.addStudent(s1);
        school.addStudent(s2);

        school.showStudents();

        s1.showCourses();
        s2.showCourses();

        c1.showStudents();
        c2.showStudents();
    }
}
