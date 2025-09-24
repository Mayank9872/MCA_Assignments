class Order{
    String orderId;
    String orderDate;
}
class ShippedOrder extends Order{
    int trackingNumber;
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;
    void getOrderStatus(){
        System.out.println("\nOrder details :\n");
        System.out.println("Order ID : "+orderId);
        System.out.println("Order date : "+orderDate);
        System.out.println("Tracking number : "+trackingNumber);
        System.out.println("Delivary date : "+deliveryDate);
    }
}
public class onlineRetail{
    public static void main(String[] args) {
        DeliveredOrder order=new DeliveredOrder();
        order.orderId="23A6";
        order.orderDate="12-07-2025";
        order.trackingNumber=345;
        order.deliveryDate="03-8-2025";
        order.getOrderStatus();
    }
}