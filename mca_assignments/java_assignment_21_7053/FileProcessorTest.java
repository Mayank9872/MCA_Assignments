// FileProcessorTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class FileProcessorTest {
    FileProcessor fp = new FileProcessor();
    String filename = "testfile.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello World";
        fp.writeToFile(filename, content);
        assertTrue(new File(filename).exists());
        String readContent = fp.readFromFile(filename);
        assertEquals(content, readContent);
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> fp.readFromFile("nofile.txt"));
    }
}
