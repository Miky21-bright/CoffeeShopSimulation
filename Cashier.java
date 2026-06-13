
package coffeeshopsimulation;

public class Cashier {

    private int cashierID;
    private boolean available;

    public Cashier(int cashierID) {
        this.cashierID = cashierID;
        this.available = true;
    }

    public void takeOrder(Customer customer) {
        System.out.println("Cashier " + cashierID +
                " takes order from Customer " +
                customer.getCustomerID());
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}