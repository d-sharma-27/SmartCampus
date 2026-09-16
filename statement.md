# Smart Campus Resource Manager

## 1. Problem Statement
Managing campus resources such as classrooms, laboratories, seminar halls, and other facilities manually can lead to scheduling conflicts, inefficient resource utilization, and difficulty in maintaining booking records.
The Smart Campus Resource Manager aims to provide a simple command-line based system for managing campus resources and their bookings. The system allows authorized users to view available resources, create and cancel bookings, and maintain booking records efficiently.

## 2. Scope of the Project
The scope of the project includes the management of campus users, resources, and bookings through a Java-based command-line application.
The system covers:
* Registration and management of students and faculty members.
* Management of different campus resources.
* Checking resource availability.
* Creating and cancelling resource bookings.
* Preventing conflicting bookings.
* Generating booking reports.
* Saving and retrieving booking information using file handling.
* Demonstrating multithreading and synchronization for concurrent booking requests.
* Providing input validation and exception handling.
* Providing a foundation for future database-based resource management.
The project is designed as a modular system that can be extended with features such as authentication, advanced search, notifications, and a graphical or web-based interface in the future.

## 3. Target Users
The primary target users of the system are:
Students
Faculty Members
Administrators

## 4. High-Level Features

### User Management
* Student registration.
* Faculty registration.
* Role-based user representation.
* User information management.

### Resource Management
* Add campus resources.
* Categorize resources by type.
* Store resource location and capacity.
* View available resources.

### Booking Management
* Create resource bookings.
* Check resource availability.
* Prevent conflicting bookings.
* Cancel bookings.
* View booking details.

### Reporting
* Generate booking reports.
* Display total, confirmed, and cancelled bookings.

### File Management
* Save booking information to a file.
* Read and display saved booking information.

### Multithreading and Synchronization
* Handle concurrent booking requests.
* Use synchronization to prevent conflicting simultaneous bookings.

### Exception Handling
* Validate user input.
* Handle invalid data.
* Handle booking conflicts.
* Handle missing resources.
* Handle file-related errors.
