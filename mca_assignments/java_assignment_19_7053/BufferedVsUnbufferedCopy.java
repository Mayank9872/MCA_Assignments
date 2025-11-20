import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        File source = new File("largefile.dat");
        File dest1 = new File("copy_unbuffered.dat");
        File dest2 = new File("copy_buffered.dat");

        if (!source.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        long unbufferedTime = copyUnbuffered(source, dest1);
        long bufferedTime = copyBuffered(source, dest2);

        System.out.println("Unbuffered Time (ns): " + unbufferedTime);
        System.out.println("Buffered Time (ns): " + bufferedTime);
    }

    public static long copyUnbuffered(File src, File dst) {
        long start = System.nanoTime();
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dst);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return System.nanoTime() - start;
    }

    public static long copyBuffered(File src, File dst) {
        long start = System.nanoTime();
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dst);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bis.close();
            bos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return System.nanoTime() - start;
    }
}
