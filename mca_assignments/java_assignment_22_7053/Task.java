// Task.java
public class Task {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}
