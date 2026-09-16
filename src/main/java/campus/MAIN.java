package campus;
import campus.enums.ResourceType;
import campus.exception.BookingConflictException;
import campus.exception.InvalidInputException;
import campus.model.Admin;
import campus.model.Booking;
import campus.model.Faculty;
import campus.model.Resource;
import campus.model.Student;
import campus.model.User;
import campus.service.BookingService;
import campus.service.ReportService;
import campus.service.ResourceService;
import campus.service.UserService;
import campus.thread.BookingTask;
import campus.util.FileManager;
import campus.util.InputValidator;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final ResourceService resourceService =
            new ResourceService();
    private static final BookingService bookingService =
            new BookingService();
    private static final ReportService reportService =
            new ReportService();
    public static void main(String[] args) {
        loadSampleData();
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        registerStudent();
                        break;
                    case 2:
                        registerFaculty();
                        break;
                    case 3:
                        addResource();
                        break;
                    case 4:
                        viewResources();
                        break;
                    case 5:
                        bookResource();
                        break;
                    case 6:
                        cancelBooking();
                        break;
                    case 7:
                        viewBookings();
                        break;
                    case 8:
                        generateReport();
                        break;
                    case 9:
                        saveBookings();
                        break;
                    case 10:
                        viewSavedBookings();
                        break;
                    case 11:
                        testMultithreading();
                        break;
                    case 12:
                        System.out.println(
                                "\nThank you for using Smart Campus!"
                        );
                        running = false;
                        break;
                    default:
                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid number."
                );
            } catch (Exception e) {
                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }
        scanner.close();
    }
    private static void displayMenu() {
        System.out.println();
        System.out.println("SMART CAMPUS RESOURCE MANAGER");
        System.out.println("1. Register Student");
        System.out.println("2. Register Faculty");
        System.out.println("3. Add Resource");
        System.out.println("4. View Resources");
        System.out.println("5. Book Resource");
        System.out.println("6. Cancel Booking");
        System.out.println("7. View All Bookings");
        System.out.println("8. Generate Report");
        System.out.println("9. Save Bookings");
        System.out.println("10. View Saved Bookings");
        System.out.println("11. Test Multithreading");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void registerStudent()
            throws InvalidInputException {
        System.out.println("\nRegister Student: ");
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        InputValidator.validateName(name);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        InputValidator.validateEmail(email);
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Program: ");
        String program = scanner.nextLine();
        Student student = new Student(
                userId,
                name,
                email,
                password,
                studentId,
                program
        );
        userService.addUser(student);
        System.out.println(
                "Student registered successfully."
        );
    }
    private static void registerFaculty()
            throws InvalidInputException {
        System.out.println("\n--- Register Faculty ---");
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        InputValidator.validateName(name);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        InputValidator.validateEmail(email);
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Employee ID: ");
        String employeeId = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        Faculty faculty = new Faculty(
                userId,
                name,
                email,
                password,
                employeeId,
                department
        );
        userService.addUser(faculty);
        System.out.println(
                "Faculty registered successfully."
        );
    }
    private static void addResource()
            throws InvalidInputException {
        System.out.println("\n--- Add Resource ---");
        System.out.print("Resource ID: ");
        int resourceId = Integer.parseInt(scanner.nextLine());
        System.out.print("Resource Name: ");
        String resourceName = scanner.nextLine();
        System.out.println("\nResource Types:");
        ResourceType[] types = ResourceType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println(
                    (i + 1) + ". " + types[i]
            );
        }
        System.out.print("Select resource type: ");
        int typeChoice = Integer.parseInt(scanner.nextLine());
        if (typeChoice < 1 || typeChoice > types.length) {
            throw new InvalidInputException(
                    "Invalid resource type."
            );
        }
        ResourceType resourceType =
                types[typeChoice - 1];
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        InputValidator.validatePositiveNumber(capacity);
        Resource resource = new Resource(
                resourceId,
                resourceName,
                resourceType,
                location,
                capacity
        );
        resourceService.addResource(resource);
    }
    private static void viewResources() {
        System.out.println( "\nAvailable Campus Resources");
        resourceService.displayAvailableResources();
    }
    private static void bookResource()
            throws BookingConflictException {
        System.out.println("\nBook Resource");
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        User user = userService.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Resource ID: ");
        int resourceId = Integer.parseInt(scanner.nextLine());
        Resource resource = resourceService.findResourceById(resourceId);
        if (resource == null) {
            System.out.println("Resource not found.");
            return;
        }
        System.out.print("Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Start Time: ");
        String startTime = scanner.nextLine();
        System.out.print("End Time: ");
        String endTime = scanner.nextLine();
        InputValidator.validateTime(
                startTime,
                endTime
        );
        Booking booking = bookingService.createBooking(
                        user,
                        resource,
                        date,
                        startTime,
                        endTime
                );
        System.out.println("\nBooking created successfully!");
        booking.displayBookingInfo();
    }
    private static void cancelBooking() {
        System.out.println("\nCancel Booking");
        System.out.print("Enter Booking ID: ");
        int bookingId =
                Integer.parseInt(scanner.nextLine());
        bookingService.cancelBooking(bookingId);
    }
    private static void viewBookings() {
        System.out.println("\nAll Bookings");
        bookingService.displayAllBookings();
    }
    private static void generateReport() {
        System.out.println("\nBooking Report");
        reportService.generateBookingReport(
                bookingService.getBookings()
        );
    }
    private static void saveBookings() {
        try {
            FileManager.saveBookings(
                    bookingService.getBookings()
            );
            System.out.println("Bookings saved successfully.");
        } catch (IOException e) {
            System.out.println(
                    "Unable to save bookings: "
                    + e.getMessage()
            );
        }
    }
    private static void viewSavedBookings() {
        try {
            FileManager.displaySavedBookings();
        } catch (IOException e) {
            System.out.println(
                    "Unable to read saved bookings: "
                    + e.getMessage()
            );
        }
    }
    private static void testMultithreading() {
        System.out.println("\nMultithreading Test");
        if (userService.getUsers().size() < 2
                || resourceService.getResources().isEmpty()) {
            System.out.println("Not enough data for multithreading test.");
            return;
        }
        User user1 = userService.getUsers().get(0);
        User user2 = userService.getUsers().get(1);
        Resource resource =
                resourceService.getResources().get(0);
        resource.setAvailable(true);
        BookingTask task1 = new BookingTask(
                bookingService,
                user1,
                resource,
                "20-09-2026",
                "10:00",
                "11:00"
        );
        BookingTask task2 = new BookingTask(
                bookingService,
                user2,
                resource,
                "20-09-2026",
                "10:00",
                "11:00"
        );
        Thread thread1 =
                new Thread(task1, "Booking-Thread-1");
        Thread thread2 =
                new Thread(task2, "Booking-Thread-2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread execution interrupted.");
        }
        System.out.println("Multithreading test completed.");
    }
    private static void loadSampleData() {
        Student student = new Student(
                1,
                "Aarav Sharma",
                "aarav@example.com",
                "pass123",
                "ST101",
                "B.Tech CSE"
        );
        Faculty faculty = new Faculty(
                2,
                "Dr. Mehta",
                "mehta@example.com",
                "faculty123",
                "FAC101",
                "Computer Science"
        );
        Admin admin = new Admin(
                3,
                "Campus Admin",
                "admin@example.com",
                "admin123"
        );
        userService.addUser(student);
        userService.addUser(faculty);
        userService.addUser(admin);
        Resource lab = new Resource(
                101,
                "AI/ML Lab",
                ResourceType.LAB,
                "AB2-101",
                40
        );
        Resource classroom = new Resource(
                102,
                "Smart Classroom",
                ResourceType.CLASSROOM,
                "AB2-201",
                60
        );
        Resource seminarHall = new Resource(
                103,
                "Seminar Hall",
                ResourceType.SEMINAR_HALL,
                "AB2 Auditorium",
                200
        );
        resourceService.addResource(lab);
        resourceService.addResource(classroom);
        resourceService.addResource(seminarHall);
    }
}
