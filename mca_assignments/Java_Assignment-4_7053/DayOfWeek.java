public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }

        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        if (m < 1 || m > 12) {
            System.out.println("Invalid month. Use 1 for January, 2 for February, ..., 12 for December.");
            return;
        }

        if (d < 1 || d > 31) {
            System.out.println("Invalid day.");
            return;
        }

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int h = (d + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        int dayOfWeek = ((h + 6) % 7);

        System.out.println("Day of the week: " + dayOfWeek);
    }
}
