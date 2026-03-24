
import java.util.*;

/**
 * BookingService processes booking requests and allocates rooms safely.
 */
public class BookingService {

    private RoomInventory inventory;
    private Queue<Reservation> requestQueue;

    // Track assigned room IDs (global uniqueness)
    private Set<String> assignedRoomIds;

    // Map room type → assigned room IDs
    private Map<String, Set<String>> allocationMap;

    public BookingService(RoomInventory inventory, Queue<Reservation> requestQueue) {
        this.inventory = inventory;
        this.requestQueue = requestQueue;
        this.assignedRoomIds = new HashSet<>();
        this.allocationMap = new HashMap<>();
    }

    // Process all booking requests
    public void processBookings() {

        System.out.println("\n=== Processing Booking Requests ===");

        while (!requestQueue.isEmpty()) {

            Reservation request = requestQueue.poll();
            String roomType = request.getRoomType();

            System.out.println("\nProcessing request for: " + request.getGuestName());

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Ensure uniqueness
                while (assignedRoomIds.contains(roomId)) {
                    roomId = generateRoomId(roomType);
                }

                // Add to set
                assignedRoomIds.add(roomId);

                // Map room type → assigned IDs
                allocationMap.putIfAbsent(roomType, new HashSet<>());
                allocationMap.get(roomType).add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking CONFIRMED for " + request.getGuestName());
                System.out.println("Assigned Room ID: " + roomId);

            } else {
                System.out.println("Booking FAILED for " + request.getGuestName());
                System.out.println("No rooms available for: " + roomType);
            }
        }
    }

    // Generate room ID
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + (int)(Math.random() * 1000);
    }

    // Display allocation summary
    public void displayAllocations() {

        System.out.println("\n=== Allocation Summary ===");

        for (String type : allocationMap.keySet()) {
            System.out.println(type + " → " + allocationMap.get(type));
        }
    }
}