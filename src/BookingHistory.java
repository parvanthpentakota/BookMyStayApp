import java.io.Serializable;
import java.util.*;

public class BookingHistory implements Serializable {

    private List<Reservation> history = new ArrayList<>();

    public void addBooking(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAllBookings() {
        return history;
    }

    public void displayHistory() {
        System.out.println("\n=== Booking History ===");
        for (Reservation r : history) {
            r.display();
        }
    }
}