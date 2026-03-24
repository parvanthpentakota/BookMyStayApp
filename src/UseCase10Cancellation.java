public class UseCase10Cancellation {

    public static void main(String[] args) {

        System.out.println("=== Booking Cancellation System ===");

        // Setup inventory
        RoomInventory inventory = new RoomInventory();

        // Setup booking history
        BookingHistory history = new BookingHistory();

        // Add confirmed bookings (simulate UC8)
        history.addBooking(new Reservation("Alice", "Single Room", "SI-101"));
        history.addBooking(new Reservation("Bob", "Double Room", "DO-202"));
        history.addBooking(new Reservation("Charlie", "Suite Room", "SU-303"));

        // Display before cancellation
        history.displayHistory();

        // Cancellation service
        CancellationService cancelService =
                new CancellationService(history, inventory);

        // Cancel a booking
        cancelService.cancelBooking("DO-202");

        // Try invalid cancellation
        cancelService.cancelBooking("XX-999");

        // Display after cancellation
        history.displayHistory();

        // Show rollback stack
        cancelService.displayRollbackStack();

        // Show updated inventory
        inventory.displayInventory();
    }
}