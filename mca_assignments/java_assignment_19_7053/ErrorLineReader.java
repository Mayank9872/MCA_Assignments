import java.io.*;

public class ErrorLineReader {
    public static void main(String[] args) {
        File file = new File("largefile.txt");

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
