package Level_3;

import java.util.Scanner;

public class SimpleCalendar {

    // Leap year check
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) return false;
        else if (year % 100 != 0) return true;
        else return year % 400 == 0;
    }

    // Days in month
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: return 31;
            case 2: return isLeapYear(year) ? 29 : 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.println("Calendar for " + month + "/" + year);
        for (String day : weekDays) {
            System.out.print(day + "\t");
        }
        System.out.println();

        // Simplified first day as 0 (Sunday) for basic version
        int firstDay = 0;
        for (int i = 0; i < firstDay; i++) System.out.print("\t");

        int days = getDaysInMonth(month, year);
        for (int i = 1; i <= days; i++) {
            System.out.print(i + "\t");
            if ((i + firstDay) % 7 == 0) System.out.println();
        }

        
    }
}
