class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    double fileSize; // in MB

    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    void displayEBookDetails() {
        System.out.println("ISBN (public accessed in subclass): " + ISBN);
        System.out.println("Title (protected accessed in subclass): " + title);
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Author (accessed via public method): " + getAuthor());
    }
}

public class LibraryDemo1 {
    public static void main(String[] args) {
        Book b1 = new Book("ISBN12345", "Java Basics", "Patrick Naughton");
        b1.displayBookDetails();

        b1.setAuthor("James Gosling");
        System.out.println("\nAfter updating author:");
        b1.displayBookDetails();

        EBook ebook = new EBook("ISBN67890", "Advanced Java", "Joshua Bloch", 5.5);
        System.out.println("\nEBook Details:");
        ebook.displayEBookDetails();
    }
}
