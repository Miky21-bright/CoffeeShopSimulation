package coffeeshopsimulation;

public class Customer {

    private int customerID;
    private double arrivalTime;
    private double waitTime;

    public Customer(int customerID, double arrivalTime) {
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.waitTime = 0;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(double waitTime) {
        this.waitTime = waitTime;
    }

    public void placeOrder() {
        System.out.println("Customer " + customerID + " placed an order.");
    }

    public void leaveShop() {
        System.out.println("Customer " + customerID + " left the shop.");
    }
}
