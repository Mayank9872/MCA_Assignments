import java.util.Scanner;

public class Twentyeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ')
                break;
            System.out.print(str.charAt(i));
        }
        sc.close();
    }
}
