/**
 * RoomSearchService provides read-only access to available rooms.
 * It retrieves availability from inventory and displays only rooms
 * that currently have available units.
 */

public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(Room single, Room doubleRoom, Room suite) {

        System.out.println("\n=== Available Rooms ===");

        if (inventory.getAvailability("Single Room") > 0) {
            single.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Single Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Double Room") > 0) {
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Double Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Suite Room") > 0) {
            suite.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite Room"));
            System.out.println();
        }
    }
}