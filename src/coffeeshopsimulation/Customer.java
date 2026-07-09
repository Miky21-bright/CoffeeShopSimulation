package coffeeshopsimulation;

public class Customer {

    private int customerID;
    private double arrivalTime;
    private double waitTime;
  
    private int priority;

    public Customer(int customerID, double arrivalTime, int priority) {
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.waitTime = 0;
        this.priority = priority;
        
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

    public int getPriority() {
        return priority;
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
