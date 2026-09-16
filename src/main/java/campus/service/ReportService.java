package campus.service;
import campus.enums.BookingStatus;
import campus.model.Booking;
import java.util.List;
public class ReportService {
    public void generateBookingReport(List<Booking> bookings) {
        int total = bookings.size();
        int confirmed = 0;
        int cancelled = 0;
        for (Booking booking : bookings) {
            if (booking.getStatus() == BookingStatus.CONFIRMED) {
                confirmed++;
            }
            if (booking.getStatus() == BookingStatus.CANCELLED) {
                cancelled++;
            }
        }
        System.out.println();
        System.out.println("BOOKING REPORT");
        System.out.println("Total Bookings     : " + total);
        System.out.println("Confirmed Bookings : " + confirmed);
        System.out.println("Cancelled Bookings : " + cancelled);
    }
}
