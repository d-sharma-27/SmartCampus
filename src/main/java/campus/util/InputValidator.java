package campus.util;
import campus.exception.InvalidInputException;
public class InputValidator {
    public static void validateName(String name)
            throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException(
                    "Name cannot be empty."
            );
        }
    }
    public static void validateEmail(String email)
            throws InvalidInputException {
        if (email == null
                || !email.contains("@")
                || !email.contains(".")) {
            throw new InvalidInputException(
                    "Invalid email address."
            );
        }
    }
    public static void validatePositiveNumber(int number)
            throws InvalidInputException {
        if (number <= 0) {
            throw new InvalidInputException(
                    "Value must be greater than zero."
            );
        }
    }
    public static void validateTime(
            String startTime,
            String endTime)
            throws InvalidInputException {
        if (startTime == null
                || endTime == null
                || startTime.trim().isEmpty()
                || endTime.trim().isEmpty()) {
            throw new InvalidInputException(
                    "Start time and end time are required."
            );
        }
    }
}
