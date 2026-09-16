package campus.model;
import campus.enums.UserRole;
public class Faculty extends User {
    private String employeeId;
    private String department;
    public Faculty(int userId, String name, String email,
                   String password, String employeeId,
                   String department) {
        super(userId, name, email, password, UserRole.FACULTY);
        this.employeeId = employeeId;
        this.department = department;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getDepartment() {
        return department;
    }
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
    }
}
