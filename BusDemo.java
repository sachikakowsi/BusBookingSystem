package Busresv;
import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        Scanner scanner = new Scanner(System.in);

        // Ask user to enter buses at runtime
        System.out.println("How many buses do you want to add?");
        int numBuses = scanner.nextInt();

        for (int i = 0; i < numBuses; i++) {
            System.out.println("Enter bus details (BusNo AC[true/false] Capacity): ");
            int busNo = scanner.nextInt();
            boolean ac = scanner.nextBoolean();
            int capacity = scanner.nextInt();

            buses.add(new Bus(busNo, ac, capacity));
        }

        // Display buses after adding
        System.out.println("\nAvailable Buses:");
        for (Bus b : buses) {
            b.displayBusInfo();
        }

        int userOpt = 1;

        while (userOpt == 1) {
            System.out.println("\nEnter 1 to Book Ticket, 2 to Exit");
            userOpt = scanner.nextInt();
            if (userOpt == 1) {
                Booking booking = new Booking();
                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    System.out.println("✅ Your booking is confirmed");
                } else {
                    System.out.println("❌ Sorry. Bus is full. Try another bus or date.");
                }
            }
        }

        scanner.close(); // prevent resource leak
    }
}
