// write a program  to  swap two numbers without suing third varible
class Fourth {
public static void main(String args[])
{
    int a = 5;
    int b = 10;
    System.out.println("before swapping  a= "+a);
    System.out.println("before swapping  b= "+b);
    a = a+b;
    b = a-b;
    a = a-b;

    System.out.println("After swapping  a= "+a);
    System.out.println("After swapping  b= "+b);
}
}