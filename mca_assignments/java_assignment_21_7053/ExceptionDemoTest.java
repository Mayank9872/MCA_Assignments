// ExceptionDemoTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionDemoTest {
    ExceptionDemo demo = new ExceptionDemo();

    @Test
    void testDivideNormal() {
        assertEquals(2, demo.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> demo.divide(5, 0));
    }
}
