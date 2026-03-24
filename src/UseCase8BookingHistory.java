public class UseCase8BookingHistory {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Booking History ===");

        BookingHistory history = new BookingHistory();

        // Simulated confirmed bookings (from UC6)
        history.addBooking(new Reservation("Alice", "Single Room", "SI-101"));
        history.addBooking(new Reservation("Bob", "Double Room", "DO-202"));
        history.addBooking(new Reservation("Charlie", "Suite Room", "SU-303"));
        history.addBooking(new Reservation("David", "Single Room", "SI-104"));

        // Display history
        history.displayHistory();

        // Generate report
        BookingReportService reportService =
                new BookingReportService(history);

        reportService.generateSummaryReport();
    }
}