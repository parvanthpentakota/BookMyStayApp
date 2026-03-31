import java.io.Serializable;
import java.util.*;

public class RoomInventory implements Serializable {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void updateAvailability(String type, int count) {
        inventory.put(type, count);
    }

    public void displayInventory() {
        System.out.println("\n=== Inventory ===");
        for (String key : inventory.keySet()) {
            System.out.println(key + ": " + inventory.get(key));
        }
    }
}