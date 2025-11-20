// PasswordValidatorTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPasswords() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("Abcdefg9H"));
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(validator.isValid("password")); // no uppercase, no digit
        assertFalse(validator.isValid("PASSWORD")); // no digit
        assertFalse(validator.isValid("Pass1"));    // too short
    }
}
