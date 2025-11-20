// UserRegistrationTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    UserRegistration ur = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> ur.registerUser("User123", "test@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("123User", "test@example.com", "Password1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("User123", "testexample.com", "Password1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("User123", "test@example.com", "pass"));
    }
}
