class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = -1; 
        this.price = 0.0;
    }

    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    void displayTicket() {
        if (seatNumber == -1) {
            System.out.println("No ticket booked yet for " + movieName);
        } else {
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        }
    }
}

public class MovieBooking {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Inception");
        ticket1.displayTicket();

        ticket1.bookTicket(12, 250.0);
        ticket1.displayTicket();
    }
}
