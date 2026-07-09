package coffeeshopsimulation;

public class Order {

    private int orderID;
    private String drinkType;
    private boolean completed;

    public Order(int orderID, String drinkType) {
        this.orderID = orderID;
        this.drinkType = drinkType;
        this.completed = false;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void completeOrder() {
        completed = true;
        System.out.println("Order " + orderID + " completed.");
    }

    public boolean isCompleted() {
        return completed;
    }
}
