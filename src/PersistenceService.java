import java.io.*;

/**
 * Handles saving and loading system state
 */
public class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // Save state
    public static void save(BookingHistory history, RoomInventory inventory) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(history);
            out.writeObject(inventory);

            System.out.println("✅ State saved successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error saving state: " + e.getMessage());
        }
    }

    // Load state
    public static Object[] load() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            BookingHistory history = (BookingHistory) in.readObject();
            RoomInventory inventory = (RoomInventory) in.readObject();

            System.out.println("✅ State loaded successfully.");

            return new Object[]{history, inventory};

        } catch (Exception e) {
            System.out.println("⚠ No previous data found. Starting fresh.");
            return null;
        }
    }
}
