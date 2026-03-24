import java.util.*;

/**
 * Handles booking cancellations with rollback
 */
public class CancellationService {

    private BookingHistory history;
    private RoomInventory inventory;

    // Stack to track released room IDs (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService(BookingHistory history, RoomInventory inventory) {
        this.history = history;
        this.inventory = inventory;
        this.rollbackStack = new Stack<>();
    }

    // Cancel booking
    public void cancelBooking(String roomId) {

        System.out.println("\nAttempting cancellation for Room ID: " + roomId);

        List<Reservation> bookings = history.getAllBookings();

        Reservation found = null;

        // Find reservation
        for (Reservation r : bookings) {
            if (r.getRoomId().equals(roomId)) {
                found = r;
                break;
            }
        }

        // Validation
        if (found == null) {
            System.out.println("Cancellation FAILED: Reservation not found.");
            return;
        }

        // Push to stack (rollback tracking)
        rollbackStack.push(roomId);

        // Restore inventory
        String roomType = found.getRoomType();
        int current = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // Remove from history
        bookings.remove(found);

        System.out.println("Cancellation SUCCESS for " + found.getGuestName());
        System.out.println("Room ID released: " + roomId);
    }

    // Show rollback stack
    public void displayRollbackStack() {

        System.out.println("\n=== Rollback Stack (LIFO) ===");

        if (rollbackStack.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        for (String id : rollbackStack) {
            System.out.println(id);
        }
    }
}