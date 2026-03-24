
import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 6: Booking Allocation System
 */

public class UseCase6BookingAllocation {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Booking Allocation ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create request queue
        Queue<Reservation> queue = new LinkedList<>();

        // Add booking requests
        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Double Room"));
        queue.add(new Reservation("Charlie", "Suite Room"));
        queue.add(new Reservation("David", "Single Room"));

        // Initialize booking service
        BookingService bookingService = new BookingService(inventory, queue);

        // Process bookings
        bookingService.processBookings();

        // Show results
        bookingService.displayAllocations();

        System.out.println("\nFinal Inventory State:");
        inventory.displayInventory();
    }
}