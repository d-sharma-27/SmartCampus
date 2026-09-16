package campus.thread;
import campus.exception.BookingConflictException;
import campus.model.Booking;
import campus.model.Resource;
import campus.model.User;
import campus.service.BookingService;
public class BookingTask implements Runnable {
    private final BookingService bookingService;
    private final User user;
    private final Resource resource;
    private final String date;
    private final String startTime;
    private final String endTime;
    public BookingTask(
            BookingService bookingService,
            User user,
            Resource resource,
            String date,
            String startTime,
            String endTime) {
        this.bookingService = bookingService;
        this.user = user;
        this.resource = resource;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void run() {
        try {
            Booking booking = bookingService.createBooking(
                    user,
                    resource,
                    date,
                    startTime,
                    endTime
            );
            System.out.println(
                    "Thread " + Thread.currentThread().getName()
                    + " created booking ID: "
                    + booking.getBookingId()
            );
        } catch (BookingConflictException e) {
            System.out.println(
                    "Thread " + Thread.currentThread().getName()
                    + " failed: "
                    + e.getMessage()
            );
        }
    }
}
