
/**
 * Use Case 7: Add-On Service Selection
 */

public class UseCase7AddOnService {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Add-On Services ===");

        // Example reservation IDs (from UC6)
        String reservation1 = "SI-101";
        String reservation2 = "DO-202";

        // Create services
        AddOnService wifi = new AddOnService("WiFi", 10.0);
        AddOnService breakfast = new AddOnService("Breakfast", 20.0);
        AddOnService spa = new AddOnService("Spa Access", 50.0);

        // Service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Add services
        manager.addService(reservation1, wifi);
        manager.addService(reservation1, breakfast);

        manager.addService(reservation2, spa);

        // Display services
        manager.displayServices(reservation1);
        manager.displayServices(reservation2);

        // Calculate cost
        System.out.println("\nTotal Add-On Cost for " + reservation1 + ": $" +
                manager.calculateTotalCost(reservation1));

        System.out.println("Total Add-On Cost for " + reservation2 + ": $" +
                manager.calculateTotalCost(reservation2));

        System.out.println("\nNote: Booking and inventory remain unchanged.");
    }
}