import java.util.Queue;

/**
 * Thread-safe booking service
 */
public class ConcurrentBookingService {

    private Queue<String> queue;
    private int availableRooms = 2; // simple inventory

    public ConcurrentBookingService(Queue<String> queue) {
        this.queue = queue;
    }

    // synchronized = critical section
    public synchronized void processBooking() {

        if (queue.isEmpty()) return;

        String guest = queue.poll();

        if (guest == null) return;

        if (availableRooms > 0) {

            try {
                Thread.sleep(100); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            availableRooms--;

            System.out.println(Thread.currentThread().getName() +
                    " booked for " + guest);

        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED for " + guest + " (No rooms)");
        }
    }
}