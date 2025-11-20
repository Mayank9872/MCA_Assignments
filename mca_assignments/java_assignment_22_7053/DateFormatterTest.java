// DateFormatterTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    DateFormatter df = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2023", df.formatDate("2023-12-25"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> df.formatDate("12/25/2023"));
        assertThrows(IllegalArgumentException.class, () -> df.formatDate("2023-13-01"));
    }
}
