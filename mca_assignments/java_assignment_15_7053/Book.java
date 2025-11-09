import java.util.ArrayList;


class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println(title + " by " + author);
    }
}


class Library {
    String name;
    ArrayList<Book> books;

    Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    void addBook(Book b) {
        books.add(b);
    }

    void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
       
        Book b1 = new Book("Harry Potter", "J.K. Rowling");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b3 = new Book("1984", "George Orwell");

      
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("School Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); 
        lib2.addBook(b3);

        
        lib1.showBooks();
        lib2.showBooks();
    }
}
