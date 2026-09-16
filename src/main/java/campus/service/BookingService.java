package campus.service;
import campus.enums.BookingStatus;
import campus.exception.BookingConflictException;
import campus.exception.ResourceNotFoundException;
import campus.model.Booking;
import campus.model.Resource;
import campus.model.User;
import java.util.ArrayList;
import java.util.List;
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    private int nextBookingId = 1;
    public synchronized Booking createBooking(
            User user,
            Resource resource,
            String date,
            String startTime,
            String endTime)
            throws BookingConflictException {
        if (resource == null) {
            throw new ResourceNotFoundException(
                    "Resource does not exist."
            );
        }
        if (!resource.isAvailable()) {
            throw new BookingConflictException(
                    "Resource is currently unavailable."
            );
        }
        for (Booking booking : bookings) {
            if (booking.getResource().getResourceId()
                    == resource.getResourceId()
                    && booking.getDate().equals(date)
                    && booking.getStatus() != BookingStatus.CANCELLED) {
                throw new BookingConflictException(
                        "Resource is already booked for this date."
                );
            }
        }
        Booking booking = new Booking(
                nextBookingId++,
                user,
                resource,
                date,
                startTime,
                endTime
        );
        booking.setStatus(BookingStatus.CONFIRMED);
        resource.setAvailable(false);
        bookings.add(booking);
        return booking;
    }
    public void cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                if (booking.getStatus()
                        == BookingStatus.CANCELLED) {
                    System.out.println("Booking is already cancelled.");
                    return;
                }
                booking.setStatus(BookingStatus.CANCELLED);
                booking.getResource().setAvailable(true);
                System.out.println("Booking cancelled successfully.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }
    public void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking booking : bookings) {
            booking.displayBookingInfo();
        }
    }
    public List<Booking> getBookings() {
        return bookings;
    }
}
