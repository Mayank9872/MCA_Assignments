import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        File source = new File("input.txt");
        File dest = new File("output.txt");

        if (!source.exists()) {
            System.out.println("Source file not found.");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(source), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"));

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase(ch));
            }

            br.close();
            bw.close();

            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
