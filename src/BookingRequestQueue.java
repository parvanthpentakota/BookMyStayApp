import java.util.LinkedList;
import java.util.Queue;

/**
 * BookingRequestQueue manages incoming booking requests using FIFO
 */
public class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request to queue
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added: " + reservation.getGuestName());
    }

    // Display all queued requests
    public void displayQueue() {
        System.out.println("\n=== Booking Request Queue ===");

        if (queue.isEmpty()) {
            System.out.println("No requests in queue.");
            return;
        }

        for (Reservation r : queue) {
            r.displayRequest();
        }
    }
}
