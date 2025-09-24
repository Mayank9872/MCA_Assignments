class person{
   String name;
   int id;
}

interface Worker{
    void performDuties();
}

class Chef extends person implements Worker{
    String dish;
    public void performDuties(){
        System.out.println("The chef is cooking "+dish+".");
    }
    void show(){
        System.out.println("Chef details :\n");
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
        
    }
}
class Waiter extends person implements Worker{
    int tableNo;
    public void performDuties(){
        System.out.println("\nServing table number "+tableNo+".");
    }
    void show(){
        System.out.println("Waiter details :\n");
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
        
    }
}
public class restaurentManagement{
    public static void main(String[] args) {
        Chef chf=new Chef();
        chf.name="Jatin";
        chf.id=123;
        chf.dish="Steak";
        chf.show();
        chf.performDuties();

        Waiter wtr=new Waiter();
        wtr.name="Suman";
        wtr.id=90;
        wtr.tableNo=6;
        wtr.show();
        wtr.performDuties();
    }
}