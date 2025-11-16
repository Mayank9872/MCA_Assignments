abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) { items.add(item); }
    List<T> getItems() { return items; }
}

class WarehouseUtil {
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem i : items) {
            System.out.println(i);
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> e = new Storage<>();
        e.addItem(new Electronics("Laptop"));
        e.addItem(new Electronics("Phone"));

        Storage<Groceries> g = new Storage<>();
        g.addItem(new Groceries("Rice"));
        g.addItem(new Groceries("Milk"));

        Storage<Furniture> f = new Storage<>();
        f.addItem(new Furniture("Chair"));
        f.addItem(new Furniture("Table"));

        WarehouseUtil.displayItems(e.getItems());
        WarehouseUtil.displayItems(g.getItems());
        WarehouseUtil.displayItems(f.getItems());
    }
}
