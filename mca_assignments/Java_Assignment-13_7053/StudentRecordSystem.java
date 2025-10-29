import java.util.Scanner;

class Node {
    int rollNo;
    String name;
    int age;
    char grade;
    Node next;

    Node(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Node head;

    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at the beginning.");
    }

    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Student added at the end.");
    }

    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at position " + pos);
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Student added at position " + pos);
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student with Roll No " + rollNo + " deleted.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;
        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with Roll No " + rollNo + " deleted.");
        }
    }

    public void searchByRollNo(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade(int rollNo, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Node temp = head;
        System.out.println("\n--- Student Records ---");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n=== Student Record Menu ===");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    list.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 2:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    list.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 3:
                    System.out.print("Enter Position, Roll No, Name, Age, Grade: ");
                    list.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRollNo(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.searchByRollNo(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Roll No and new Grade: ");
                    list.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
