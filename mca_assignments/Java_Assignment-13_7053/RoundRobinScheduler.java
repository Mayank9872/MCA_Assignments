import java.util.Scanner;

class ProcessNode {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularQueue {
    private ProcessNode head = null;

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head; // circular link
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Process added: PID=" + pid + ", BT=" + burstTime + ", Priority=" + priority);
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        ProcessNode curr = head, prev = null;

        while (curr.next != head) {
            if (curr.pid == pid) break;
            prev = curr;
            curr = curr.next;
        }

        if (curr.pid != pid) {
            System.out.println("Process not found.");
            return;
        }

        // Single node case
        if (curr == head && curr.next == head) {
            head = null;
            return;
        }

        // Head node case
        if (curr == head) {
            ProcessNode last = head;
            while (last.next != head)
                last = last.next;
            head = head.next;
            last.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode temp = head;
        System.out.println("\nCurrent Process Queue:");
        do {
            System.out.print("[PID=" + temp.pid + ", RT=" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0, totalTurnAroundTime = 0, currentTime = 0, count = 0;
        ProcessNode current = head;

        System.out.println("\n=== Starting Round Robin Simulation ===");
        while (head != null) {
            displayProcesses();

            int execTime = Math.min(current.remainingTime, timeQuantum);
            current.remainingTime -= execTime;
            currentTime += execTime;

            System.out.println("Executing PID=" + current.pid + " for " + execTime + " units.");

            if (current.remainingTime == 0) {
                System.out.println("Process PID=" + current.pid + " completed at time " + currentTime);
                totalTurnAroundTime += currentTime;
                totalWaitingTime += currentTime - current.burstTime;
                removeProcess(current.pid);

                if (head == null) break;
                current = head;
            } else {
                current = current.next;
            }
            count++;
        }

        double avgWT = (double) totalWaitingTime / count;
        double avgTAT = (double) totalTurnAroundTime / count;

        System.out.println("\n=== Simulation Complete ===");
        System.out.println("Average Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();

        while (true) {
            System.out.println("\n=== Round Robin CPU Scheduler ===");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Simulate Round Robin");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    queue.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    queue.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    queue.simulateRoundRobin(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
