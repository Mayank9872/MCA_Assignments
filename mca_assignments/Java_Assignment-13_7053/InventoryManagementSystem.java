import java.util.Scanner;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    private ItemNode head = null;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Item added at end.");
    }

    public void addAtPosition(int pos, String itemName, int itemId, int quantity, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Item added at position " + pos);
    }

    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId)
            temp = temp.next;
        if (temp.next == null)
            System.out.println("Item not found.");
        else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByItemId(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found -> ID: " + temp.itemId + ", Name: " + temp.itemName +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByItemName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                System.out.println("Item Found -> ID: " + temp.itemId + ", Name: " + temp.itemName +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        ItemNode temp = head;
        System.out.println("\n--- Inventory Items ---");
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName +
                    ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void totalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total inventory value = " + total);
    }

    public void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
        System.out.println("Inventory sorted by name " + (ascending ? "ascending." : "descending."));
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
        System.out.println("Inventory sorted by price " + (ascending ? "ascending." : "descending."));
    }

    private ItemNode mergeSortByName(ItemNode head, boolean ascending) {
        if (head == null || head.next == null)
            return head;
        ItemNode mid = getMiddle(head);
        ItemNode nextToMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSortByName(head, ascending);
        ItemNode right = mergeSortByName(nextToMid, ascending);
        return mergeByName(left, right, ascending);
    }

    private ItemNode mergeByName(ItemNode a, ItemNode b, boolean ascending) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ItemNode result;
        int cmp = a.itemName.compareToIgnoreCase(b.itemName);
        if ((ascending && cmp <= 0) || (!ascending && cmp > 0)) {
            result = a;
            result.next = mergeByName(a.next, b, ascending);
        } else {
            result = b;
            result.next = mergeByName(a, b.next, ascending);
        }
        return result;
    }

    private ItemNode mergeSortByPrice(ItemNode head, boolean ascending) {
        if (head == null || head.next == null)
            return head;
        ItemNode mid = getMiddle(head);
        ItemNode nextToMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSortByPrice(head, ascending);
        ItemNode right = mergeSortByPrice(nextToMid, ascending);
        return mergeByPrice(left, right, ascending);
    }

    private ItemNode mergeByPrice(ItemNode a, ItemNode b, boolean ascending) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ItemNode result;
        if ((ascending && a.price <= b.price) || (!ascending && a.price > b.price)) {
            result = a;
            result.next = mergeByPrice(a.next, b, ascending);
        } else {
            result = b;
            result.next = mergeByPrice(a, b.next, ascending);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null)
            return head;
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList list = new InventoryList();

        while (true) {
            System.out.println("\n=== Inventory Management Menu ===");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    list.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    list.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter Position, Name, ID, Quantity, Price: ");
                    list.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    list.removeByItemId(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID and new Quantity: ");
                    list.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    list.searchByItemId(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    list.searchByItemName(sc.next());
                    break;
                case 8:
                    list.displayAll();
                    break;
                case 9:
                    list.totalValue();
                    break;
                case 10:
                    System.out.print("1 for Ascending, 2 for Descending: ");
                    list.sortByName(sc.nextInt() == 1);
                    break;
                case 11:
                    System.out.print("1 for Ascending, 2 for Descending: ");
                    list.sortByPrice(sc.nextInt() == 1);
                    break;
                case 12:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
