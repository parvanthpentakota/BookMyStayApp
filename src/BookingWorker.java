public class BookingWorker extends Thread {

    private ConcurrentBookingService service;

    public BookingWorker(ConcurrentBookingService service, String name) {
        super(name);  // sets thread name (Thread-1, Thread-2)
        this.service = service;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            service.processBooking();
        }
    }
}