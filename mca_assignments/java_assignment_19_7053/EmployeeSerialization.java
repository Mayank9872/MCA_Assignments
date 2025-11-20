import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Salary: ");
            double sal = sc.nextDouble();
            sc.nextLine();
            employees.add(new Employee(id, name, dept, sal));
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
            oos.writeObject(employees);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"));
            List<Employee> list = (List<Employee>) ois.readObject();
            ois.close();

            for (Employee e : list) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
