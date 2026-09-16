package campus.model;
import campus.enums.UserRole;
public class Student extends User {
    private String studentId;
    private String program;
    public Student(int userId, String name, String email,
                   String password, String studentId,
                   String program) {
        super(userId, name, email, password, UserRole.STUDENT);
        this.studentId = studentId;
        this.program = program;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getProgram() {
        return program;
    }
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Program: " + program);
    }
}
