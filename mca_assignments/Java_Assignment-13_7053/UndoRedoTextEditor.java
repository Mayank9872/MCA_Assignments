import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (head == null) {
            head = newState;
            current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("State added: " + content);
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed. Current state: " + current.content);
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo");
            return;
        }
        current = current.next;
        System.out.println("Redo performed. Current state: " + current.content);
    }

    public void showCurrentState() {
        if (current == null) {
            System.out.println("No content yet.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    public void showAllStates() {
        if (head == null) {
            System.out.println("No states in history.");
            return;
        }
        TextState temp = head;
        while (temp != null) {
            String mark = (temp == current) ? " <== current" : "";
            System.out.println(temp.content + mark);
            temp = temp.next;
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n1. Add new text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show current text");
            System.out.println("5. Show all states");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrentState();
                    break;
                case 5:
                    editor.showAllStates();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
