import java.util.ArrayList;

class Professor {
    String name;
    ArrayList<Course> courses;

    Professor(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void assignCourse(Course c) {
        courses.add(c);
        c.assignProfessor(this);
        System.out.println("Professor " + name + " is assigned to " + c.courseName);
    }

    void showCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course c : courses) {
            System.out.println(" - " + c.courseName);
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

    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
        System.out.println(name + " enrolled in " + c.courseName);
    }

    void showCourses() {
        System.out.println("Student: " + name + " enrolled in:");
        for (Course c : courses) {
            System.out.println(" - " + c.courseName);
        }
        System.out.println();
    }
}

class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    void assignProfessor(Professor p) {
        this.professor = p;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null)
            System.out.println("Professor: " + professor.name);
        else
            System.out.println("Professor: Not assigned");
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
        System.out.println();
    }
}

class University {
    String universityName;
    ArrayList<Student> students;
    ArrayList<Professor> professors;
    ArrayList<Course> courses;

    University(String universityName) {
        this.universityName = universityName;
        students = new ArrayList<>();
        professors = new ArrayList<>();
        courses = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void addProfessor(Professor p) {
        professors.add(p);
    }

    void addCourse(Course c) {
        courses.add(c);
    }

    void showUniversity() {
        System.out.println("University: " + universityName);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println(" - " + p.name);
        }
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.courseName);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Global University");

        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Brown");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Computer Science");
        Course c2 = new Course("Mathematics");

        uni.addProfessor(prof1);
        uni.addProfessor(prof2);
        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        prof1.assignCourse(c1);
        prof2.assignCourse(c2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c2);
        s2.enrollCourse(c1);

        uni.showUniversity();

        prof1.showCourses();
        s1.showCourses();

        c1.showCourseDetails();
        c2.showCourseDetails();
    }
}
