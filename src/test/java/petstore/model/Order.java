package petstore.model;

public class Order {
    public Long id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public Boolean complete;

    public static Order createDefault() {
        Order order = new Order();
        order.id = System.currentTimeMillis();
        order.petId = order.id + 1;
        order.quantity = 1;
        order.shipDate = "2025-04-23T00:00:00.000Z";
        order.status = "placed";
        order.complete = true;
        return order;
    }
}
