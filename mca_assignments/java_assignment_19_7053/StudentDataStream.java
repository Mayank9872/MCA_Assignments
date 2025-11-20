import java.io.*;
import java.util.*;

public class StudentDataStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"));

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("GPA: ");
                double gpa = sc.nextDouble();
                sc.nextLine();
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }

            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"));

            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + " | " + name + " | " + gpa);
            }

            dis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
