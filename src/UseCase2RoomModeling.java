/**
 * Use Case 2: Room Modeling with Inheritance and Abstraction
 */

public class UseCase2RoomModeling {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Room Availability ===\n");

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Display details
        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);
        System.out.println();

        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);
        System.out.println();

        System.out.println("Suite Room Details:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
    }
}