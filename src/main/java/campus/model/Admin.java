package campus.model;
import campus.enums.UserRole;
public class Admin extends User {
    public Admin(int userId, String name, String email,
                 String password) {
        super(userId, name, email, password, UserRole.ADMIN);
    }
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Access Level: Full Administrative Access");
    }
}
