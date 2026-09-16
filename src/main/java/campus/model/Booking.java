package campus.model;
import campus.enums.BookingStatus;
public class Booking {
    private int bookingId;
    private User user;
    private Resource resource;
    private String date;
    private String startTime;
    private String endTime;
    private BookingStatus status;
    public Booking(int bookingId, User user, Resource resource,
                   String date, String startTime, String endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.resource = resource;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = BookingStatus.PENDING;
    }
    public int getBookingId() {
        return bookingId;
    }
    public User getUser() {
        return user;
    }
    public Resource getResource() {
        return resource;
    }
    public String getDate() {
        return date;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public BookingStatus getStatus() {
        return status;
    }
    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    public void displayBookingInfo() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("User: " + user.getName());
        System.out.println("Resource: " + resource.getResourceName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + startTime + " - " + endTime);
        System.out.println("Status: " + status);
    }
}
