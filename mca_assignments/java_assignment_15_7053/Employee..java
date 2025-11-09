import java.util.ArrayList;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void showEmployee() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees;

    Department(String deptName) {
        this.deptName = deptName;
        employees = new ArrayList<>();
    }

    void addEmployee(String name) {
        employees.add(new Employee(name));
    }

    void showDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.showEmployee();
        }
    }
}

class Company {
    String companyName;
    ArrayList<Department> departments;

    Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    void closeCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments are deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        Company c = new Company("TechCorp");

        Department d1 = new Department("IT");
        d1.addEmployee("Alice");
        d1.addEmployee("Bob");

        Department d2 = new Department("HR");
        d2.addEmployee("Charlie");

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showCompany();

        c.closeCompany();
    }
}
