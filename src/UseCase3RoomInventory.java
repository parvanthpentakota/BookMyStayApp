public class UseCase3RoomInventory {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Room Inventory Management ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current availability
        inventory.displayInventory();

        // Check availability
        System.out.println("\nChecking availability for Single Room:");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));

        // Update availability (simulate booking)
        System.out.println("\nBooking a Single Room...");
        int current = inventory.getAvailability("Single Room");
        inventory.updateAvailability("Single Room", current - 1);

        // Display updated inventory
        inventory.displayInventory();
    }
}