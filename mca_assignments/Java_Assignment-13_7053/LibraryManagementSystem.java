 import java.util.Scanner;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private BookNode head = null;
    private BookNode tail = null;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning.");
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Book added at position " + pos);
        }
    }

    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = head;
        while (temp != null && temp.bookId != bookId)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found.");
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

        System.out.println("Book removed successfully.");
    }

    public void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No books found by this author.");
    }

    public void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No books to display.");
            return;
        }
        System.out.println("\n--- Books in Forward Order ---");
        BookNode temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books to display.");
            return;
        }
        System.out.println("\n--- Books in Reverse Order ---");
        BookNode temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    private void printBook(BookNode book) {
        System.out.println("Book ID: " + book.bookId +
                ", Title: " + book.title +
                ", Author: " + book.author +
                ", Genre: " + book.genre +
                ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Book Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Author, Genre, ID, Available(true/false): ");
                    library.addAtBeginning(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;
                case 2:
                    System.out.print("Enter Title, Author, Genre, ID, Available(true/false): ");
                    library.addAtEnd(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;
                case 3:
                    System.out.print("Enter Position, Title, Author, Genre, ID, Available(true/false): ");
                    library.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeByBookId(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Book Title: ");
                    library.searchByTitle(sc.next());
                    break;
                case 6:
                    System.out.print("Enter Author Name: ");
                    library.searchByAuthor(sc.next());
                    break;
                case 7:
                    System.out.print("Enter Book ID and Availability(true/false): ");
                    library.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    library.countBooks();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
 
