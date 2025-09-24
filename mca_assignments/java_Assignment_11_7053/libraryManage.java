class Book{
   String title;
   int publicationYear;
}
class Author extends Book{
     String name;
     String bio;
     void displayInfo(){
        System.out.println("Book details :\n");
        System.out.println("Title : "+title);
        System.out.println("Publication year : "+publicationYear);
        System.out.println("Author name : "+name);
        System.out.println("Author bio : "+bio);
     }
}
public class libraryManage{
    public static void main(String[] args) {
        Author book=new Author();
        book.title="Harry Potter";
        book.publicationYear=2016;
        book.name="J.K. Rowling";
        book.bio="British author and philanthropist best known for the Harry Potter fantasy series.";
        book.displayInfo();
    }
}