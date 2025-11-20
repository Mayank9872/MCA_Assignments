import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        File source = new File("image.jpg");
        File output = new File("image_copy.jpg");

        if (!source.exists()) {
            System.out.println("Source image not found.");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(source);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            fis.close();

            byte[] imgBytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(imgBytes);
            FileOutputStream fos = new FileOutputStream(output);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bais.close();

            System.out.println("Image conversion completed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
