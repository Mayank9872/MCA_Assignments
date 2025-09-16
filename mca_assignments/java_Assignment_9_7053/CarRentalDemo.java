class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    CarRental() {
        this("Unknown", "Standard", 1);
    }

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    void calculateTotalCost() {
        double ratePerDay;
        switch (carModel.toLowerCase()) {
            case "suv":
                ratePerDay = 3000;
                break;
            case "sedan":
                ratePerDay = 2000;
                break;
            case "hatchback":
                ratePerDay = 1500;
                break;
            default:
                ratePerDay = 1000;
        }
        totalCost = ratePerDay * rentalDays;
    }

    void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + totalCost);
    }
}

public class CarRentalDemo {
    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Piyush", "SUV", 5);

        System.out.println("Default Rental:");
        rental1.displayRentalDetails();

        System.out.println("\nCustomer Rental:");
        rental2.displayRentalDetails();
    }
}
