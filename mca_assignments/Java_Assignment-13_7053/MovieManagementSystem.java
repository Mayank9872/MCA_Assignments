import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at the beginning.");
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at the end.");
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null)
            temp.next.prev = newNode;
        else
            tail = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println("Movie added at position " + pos);
    }

    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp == head)
            head = head.next;
        if (temp == tail)
            tail = tail.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        System.out.println("Movie removed successfully.");
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found by that director.");
    }

    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found with that rating.");
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = head;
        System.out.println("\n--- Movies (Forward) ---");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = tail;
        System.out.println("\n--- Movies (Reverse) ---");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        while (true) {
            System.out.println("\n=== Movie Management Menu ===");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter Position, Title, Director, Year, Rating: ");
                    list.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    list.removeByTitle(sc.next());
                    break;
                case 5:
                    System.out.print("Enter Director name: ");
                    list.searchByDirector(sc.next());
                    break;
                case 6:
                    System.out.print("Enter Rating: ");
                    list.searchByRating(sc.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter Movie Title and new Rating: ");
                    list.updateRating(sc.next(), sc.nextDouble());
                    break;
                case 8:
                    list.displayForward();
                    break;
                case 9:
                    list.displayReverse();
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
