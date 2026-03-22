/**
 * Use Case 5: Booking Request Queue
 * Demonstrates fair request handling using FIFO queue
 */

public class UseCase5BookingRequest {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Booking Request Intake ===");

        // Initialize queue
        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Simulate guest booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        // Add to queue
        requestQueue.addRequest(r1);
        requestQueue.addRequest(r2);
        requestQueue.addRequest(r3);

        // Display queue
        requestQueue.displayQueue();

        System.out.println("\nAll requests are stored in arrival order.");
        System.out.println("No booking or inventory updates performed.");
    }
}
