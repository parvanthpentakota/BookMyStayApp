import java.util.*;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    public void generateSummaryReport() {

        System.out.println("\n=== Booking Summary Report ===");

        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : history.getAllBookings()) {

            String type = r.getRoomType();

            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        for (String type : countMap.keySet()) {
            System.out.println(type + " booked: " + countMap.get(type));
        }
    }
}