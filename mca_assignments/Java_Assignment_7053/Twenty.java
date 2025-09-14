// write a program to declare a volatile variable and explain its use in multithreading.
class Twenty {
    private static volatile boolean running = true;
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started...");
            while (running) {
            }
            System.out.println("Worker thread stopped.");
        });

        worker.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread setting running = false");
        running = false;
    }
}

