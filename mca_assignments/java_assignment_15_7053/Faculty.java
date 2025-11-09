import java.util.ArrayList;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void showFaculty() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String deptName;
    ArrayList<Faculty> facultyList;

    Department(String deptName) {
        this.deptName = deptName;
        facultyList = new ArrayList<>();
    }

    void addFaculty(Faculty f) {
        facultyList.add(f);
    }

    void showDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty f : facultyList) {
            f.showFaculty();
        }
        System.out.println();
    }
}

class University {
    String universityName;
    ArrayList<Department> departments;

    University(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showUniversity() {
        System.out.println("University: " + universityName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    void closeUniversity() {
        departments.clear();
        System.out.println("University " + universityName + " and its departments are deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Prof. Johnson");
        Faculty f3 = new Faculty("Dr. Brown");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mathematics");

        d1.addFaculty(f1);
        d2.addFaculty(f2);

        University uni = new University("Global University");
        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.showUniversity();

        System.out.println("Independent Faculty:");
        f3.showFaculty();

        uni.closeUniversity();
    }
}
