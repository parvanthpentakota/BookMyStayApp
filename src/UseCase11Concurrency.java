import java.util.LinkedList;
import java.util.Queue;

public class UseCase11Concurrency {

    public static void main(String[] args) {

        System.out.println("=== Concurrent Booking ===");

        // Step 1: Shared queue
        Queue<String> queue = new LinkedList<>();

        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        queue.add("David");

        // Step 2: Shared service
        ConcurrentBookingService service =
                new ConcurrentBookingService(queue);

        // Step 3: Create threads
        BookingWorker t1 = new BookingWorker(service, "Thread-1");
        BookingWorker t2 = new BookingWorker(service, "Thread-2");

        // Step 4: Start threads
        t1.start();
        t2.start();
    }
}