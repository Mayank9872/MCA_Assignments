class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    void displayManagerDetails() {
        System.out.println("Employee ID (public accessed in subclass): " + employeeID);
        System.out.println("Department (protected accessed in subclass): " + department);
        System.out.println("Team Name: " + teamName);
        System.out.println("Salary (accessed via public method): " + getSalary());
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "IT", 50000);
        emp1.displayEmployeeDetails();

        emp1.setSalary(55000);
        System.out.println("\nAfter Salary Update:");
        emp1.displayEmployeeDetails();

        Manager mgr = new Manager(201, "HR", 75000, "Recruitment Team");
        System.out.println("\nManager Details:");
        mgr.displayManagerDetails();
    }
}
