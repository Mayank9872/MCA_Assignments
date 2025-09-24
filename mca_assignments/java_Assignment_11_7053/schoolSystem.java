class Person{
    String name;
    int age;
}

class Teacher extends Person{
    String subject;
    void personDetails(){
        System.out.println("\nPerson details :\n");
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Role : Teacher");
        System.out.println("Subject : "+subject);

    }
}

class Student extends Person{
    char grade;
    void personDetails(){
        System.out.println("\nPerson details :\n");
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Role : Student");
        System.out.println("Grade : "+grade);
       
    }
}

class Staff extends Person{
    String designation;
    void personDetails(){
        System.out.println("\nPerson details :\n");
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Role : Staff");
        System.out.println("Designation : "+designation);
    }
}
public class schoolSystem{
    public static void main(String[] args) {
        Teacher prsn1=new Teacher();
        prsn1.name="Tanya";
        prsn1.age=28;
        prsn1.subject="Maths";
        prsn1.personDetails();

        Student prsn2=new Student();
        prsn2.name="Nimish";
        prsn2.age=17;
        prsn2.grade='B';
        prsn2.personDetails();

        Staff prsn3=new Staff();
        prsn3.name="Mahesh";
        prsn3.age=35;
        prsn3.designation="Lab supervisor";
        prsn3.personDetails();
    }
}