// write a program to show the difference between static and intance vaiable.
//Piyush
class Thirteen {
    static int staticVar = 0;
    int instanceVar = 0;

    public void increment() {
        staticVar++;
        instanceVar++;
    }

    public static void main(String[] args) {
        Thirteen obj1 = new Thirteen();
        Thirteen obj2 = new Thirteen();

        obj1.increment();
        obj2.increment();

        System.out.println("After incrementing using obj1 and obj2:");
        System.out.println("obj1 - staticVar: " + Thirteen.staticVar);
        System.out.println("obj1 - instanceVar: " + obj1.instanceVar);
        System.out.println("obj2 - staticVar: " + Thirteen.staticVar);
        System.out.println("obj2 - instanceVar: " + obj2.instanceVar);
        System.out.println("Access staticVar via class: " + Thirteen.staticVar);
    }
}
