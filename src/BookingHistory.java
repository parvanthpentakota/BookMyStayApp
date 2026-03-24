import java.util.*;

public class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addBooking(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllBookings() {
        return history;
    }

    public void displayHistory() {

        System.out.println("\n=== Booking History ===");

        if (history.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : history) {
            r.display();
        }
    }
}
