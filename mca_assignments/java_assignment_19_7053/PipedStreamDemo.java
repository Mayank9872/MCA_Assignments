import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new Thread(() -> {
                try {
                    String msg = "Hello from writer thread";
                    pos.write(msg.getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            Thread reader = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            writer.start();
            reader.start();

            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
