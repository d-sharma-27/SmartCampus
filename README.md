# SmartCampus

## 1. Project Title
**Smart Campus Resource Manager**

## 2. Project Overview
Smart Campus Resource Manager is a command-line based Java application designed to manage campus resources and their bookings.
The system allows students, faculty members, and administrators to manage campus resources such as classrooms, laboratories, seminar halls, and other facilities. Users can view available resources, create bookings, cancel bookings, generate reports, and save booking information.
The project demonstrates core Java programming concepts including Object-Oriented Programming, inheritance, polymorphism, collections, exception handling, file handling, multithreading, synchronization, and JDBC.

## 3. Features

### User Management
* Register students.
* Register faculty members.
* Support different user roles.
* Display user information.

### Resource Management
* Add campus resources.
* View available resources.
* Categorize resources by type.
* Store resource location and capacity.

### Booking Management
* Book available campus resources.
* Check resource availability.
* Prevent conflicting bookings.
* Cancel bookings.
* View all bookings.

### Reporting
* Generate booking reports.
* Display total bookings.
* Display confirmed bookings.
* Display cancelled bookings.

### File Handling
* Save booking information to a text file.
* Read and display saved booking information.

### Multithreading
* Demonstrate concurrent booking requests.
* Use synchronization to prevent conflicting simultaneous bookings.

### Exception Handling
* Validate user input.
* Handle invalid inputs.
* Handle booking conflicts.
* Handle missing resources.
* Handle file-related errors.

## 4. Technologies / Tools Used

* **Programming Language:** Java
* **JDK:** Java 17 or later
* **Collections:** Java Collections Framework
* **File Handling:** Java I/O
* **Multithreading:** Java Threads and Runnable
* **Synchronization:** Synchronized methods
* **Database Connectivity:** JDBC
* **Database:** SQLite
* **Version Control:** Git and GitHub
* **Execution:** Command Line / Terminal

## 5. Project Structure

```text
SmartCampus/
│
├── README.md
├── statement.md
│
└── src/
    └── main/
        └── java/
            └── campus/
                ├── Main.java
                │
                ├── model/
                │   ├── User.java
                │   ├── Student.java
                │   ├── Faculty.java
                │   ├── Admin.java
                │   ├── Resource.java
                │   └── Booking.java
                │
                ├── enums/
                │   ├── UserRole.java
                │   ├── ResourceType.java
                │   └── BookingStatus.java
                │
                ├── service/
                │   ├── UserService.java
                │   ├── ResourceService.java
                │   ├── BookingService.java
                │   └── ReportService.java
                │
                ├── exception/
                │   ├── BookingConflictException.java
                │   ├── ResourceNotFoundException.java
                │   └── InvalidInputException.java
                │
                ├── database/
                │   └── DatabaseManager.java
                │
                ├── util/
                │   ├── InputValidator.java
                │   ├── FileManager.java
                │   └── AppConfig.java
                │
                └── thread/
                    └── BookingTask.java
```

# 6. Installation and Setup

## Requirements
Before running the project, install:
* Java Development Kit (JDK) 17 or later
* Git (optional)
* A command-line terminal such as Windows PowerShell, Command Prompt, Linux Terminal, or macOS Terminal
Check the Java installation using:

java -version
and:
javac -version

## 7. Clone the Repository

Clone the GitHub repository using:

```bash
git clone <repository-url>
```

Move into the project directory:

```bash
cd SmartCampus
```

# 8. Compile the Project

The project is designed to be compiled and executed completely through the command line.

## Windows PowerShell

Create an output directory:
```powershell
mkdir out
```
Compile all Java source files:
```powershell
javac -d out (Get-ChildItem -Recurse src\main\java\*.java).FullName
```
## Linux / macOS
Create an output directory:
```bash
mkdir -p out
```
Compile the project:
```bash
javac -d out $(find src/main/java -name "*.java")
```
If compilation completes without errors, the project has been successfully compiled.

# 9. Run the Project
Run the application using:
```bash
java -cp out campus.Main
```
The application will start in the terminal and display the main menu.
```text
 SMART CAMPUS RESOURCE MANAGER
1. Register Student
2. Register Faculty
3. Add Resource
4. View Resources
5. Book Resource
6. Cancel Booking
7. View All Bookings
8. Generate Report
9. Save Bookings
10. View Saved Bookings
11. Test Multithreading
12. Exit
Enter your choice:
```

# 10. Instructions for Testing

The following test cases can be used to verify the major features of the application.

## Test Case 1: View Resources
1. Run the application.
2. Select option `4`.
3. Verify that available campus resources are displayed.

Expected result:
```text
AI/ML Lab
Smart Classroom
Seminar Hall
```

## Test Case 2: Register Student
1. Select option `1`.
2. Enter a valid User ID.
3. Enter the student's name.
4. Enter a valid email.
5. Enter a password.
6. Enter Student ID and program.

Expected result:
```text
Student registered successfully.
```

## Test Case 3: Register Faculty
1. Select option `2`.
2. Enter the required faculty information.
3. Submit the details.
Expected result:
```text
Faculty registered successfully.
```

## Test Case 4: Book a Resource
1. Select option `5`.
2. Enter a valid User ID.
3. Enter an available Resource ID.
4. Enter the booking date.
5. Enter start and end time.

Expected result:
```text
Booking created successfully!
```
The booking status should be:
```text
CONFIRMED
```

## Test Case 5: View Bookings
1. Select option `7`.
2. Verify that existing bookings are displayed.
The booking information should include:
* Booking ID
* User
* Resource
* Date
* Time
* Status

## Test Case 6: Cancel Booking
1. Select option `6`.
2. Enter a valid Booking ID.
3. Verify that the booking is cancelled.

Expected result:
```text
Booking cancelled successfully.
```
The booking status should change to:
```text
CANCELLED
```

## Test Case 7: Generate Report
1. Select option `8`.
2. Verify the booking statistics.
The report displays:
* Total bookings
* Confirmed bookings
* Cancelled bookings

## Test Case 8: File I/O
1. Select option `9`.
2. Verify that booking information is saved to `bookings.txt`.
3. Select option `10`.
4. Verify that saved booking information is displayed.

## Test Case 9: Multithreading
1. Ensure that at least two users and one resource are available.
2. Select option `11`.
3. The application creates two concurrent booking requests.

Expected behavior:
* The synchronized booking system prevents conflicting simultaneous bookings.
* The successful booking receives a booking ID.
* The conflicting request displays an appropriate error message.
* 
## Test Case 10: Invalid Input
Test the application with invalid values such as:
* Empty name
* Invalid email
* Negative capacity
* Invalid resource type
* Non-existent user
* Non-existent resource
  
Expected behavior:

The application displays an appropriate error message instead of terminating unexpectedly.

# 11. Sample Data
The application loads sample data when it starts.

### Users

| User         | Role          |
| ------------ | ------------- |
| Aarav Sharma | Student       |
| Dr. Mehta    | Faculty       |
| Campus Admin | Administrator |

### Resources

| Resource        | Type         | Location       |
| --------------- | ------------ | -------------- |
| AI/ML Lab       | Lab          | AB2-101        |
| Smart Classroom | Classroom    | AB2-201        |
| Seminar Hall    | Seminar Hall | AB2 Auditorium |

# 12. Key Java Concepts Demonstrated

Object-Oriented Programming
Inheritance
Polymorphism
Collections
Exception Handling
File I/O
Multithreading
Synchronization
JDBC

# 13. Expected Outcome

The Smart Campus Resource Manager provides a modular command-line application for managing campus resources and bookings.
It demonstrates the practical application of Java programming concepts while providing features for resource management, booking management, reporting, file handling, exception handling, and multithreading.
The application can be compiled and executed directly from a terminal without requiring a GUI-based setup.
