/**
 * Use Case 9: Validation and Exception Handling
 */

public class UseCase9Validation {

    public static void main(String[] args) {

        System.out.println("=== Booking Validation System ===");

        // Sample inputs
        String guestName = "";  // Invalid
        String roomType = "Deluxe Room"; // Invalid
        int availableRooms = 0; // Invalid

        try {
            // Validate input
            BookingValidator.validate(guestName, roomType, availableRooms);

            // If no exception → success
            System.out.println("Booking is valid!");

        } catch (InvalidBookingException e) {

            // Graceful failure
            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("\nSystem continues running safely...");
    }
}
