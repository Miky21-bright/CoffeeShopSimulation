
package coffeeshopsimulation;

public class Barista {

    private int baristaID;
    private boolean available;

    public Barista(int baristaID) {
        this.baristaID = baristaID;
        this.available = true;
    }

    public void prepareDrink(Order order) {
        System.out.println("Barista " + baristaID +
                " prepares drink for Order " +
                order.getOrderID());
        order.completeOrder();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}