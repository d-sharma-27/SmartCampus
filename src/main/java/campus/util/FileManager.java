package campus.util;
import campus.model.Booking;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class FileManager {
    private static final String FILE_NAME = "bookings.txt";
    public static void saveBookings(List<Booking> bookings)
            throws IOException {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Booking booking : bookings) {
                writer.write(
                        booking.getBookingId() + " | "
                        + booking.getUser().getName() + " | "
                        + booking.getResource().getResourceName() + " | "
                        + booking.getDate() + " | "
                        + booking.getStartTime() + " - "
                        + booking.getEndTime() + " | "
                        + booking.getStatus()
                );
                writer.newLine();
            }
        }
    }
    public static void displaySavedBookings()
            throws IOException {
        java.io.File file = new java.io.File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved booking file found.");
            return;
        }
        try (java.io.BufferedReader reader =
                     new java.io.BufferedReader(
                             new java.io.FileReader(FILE_NAME))) {
            String line;
            System.out.println();
            System.out.println("SAVED BOOKINGS");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
