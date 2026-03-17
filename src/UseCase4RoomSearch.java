/**
 * Use Case 4: Room Search
 * Guests can view available rooms without modifying inventory.
 */

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Room Search ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize search service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Guest performs search
        searchService.searchAvailableRooms(singleRoom, doubleRoom, suiteRoom);

        System.out.println("\nSearch completed. No system state was modified.");
    }
}