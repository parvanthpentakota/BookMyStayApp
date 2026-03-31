public class UseCase12Persistence {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Persistence System ===");

        BookingHistory history;
        RoomInventory inventory;

        // Load previous state
        Object[] data = PersistenceService.load();

        if (data != null) {
            history = (BookingHistory) data[0];
            inventory = (RoomInventory) data[1];
        } else {
            history = new BookingHistory();
            inventory = new RoomInventory();

            // Sample data (first run)
            history.addBooking(new Reservation("Alice", "Single Room", "SI-101"));
            history.addBooking(new Reservation("Bob", "Double Room", "DO-202"));
        }

        // Display current state
        history.displayHistory();
        inventory.displayInventory();

        // Save before exit
        PersistenceService.save(history, inventory);
    }
}
