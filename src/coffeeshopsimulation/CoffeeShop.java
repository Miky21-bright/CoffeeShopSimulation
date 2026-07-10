package coffeeshopsimulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;



public class CoffeeShop {

    private Queue<Customer> customerQueue;
    private Cashier cashier;
    private Barista barista;
    
    private int customersServed = 0;
    private double totalWaitingTime = 0;
    private double maximumWaitingTime = 0;
    
    private double currentTime = 0;
    private double serviceTime = 3;
    private int numberOfCustomers;
    private double arrivalInterval;
    
    public CoffeeShop(double serviceTime, int numberOfCustomers, double arrivalInterval) {
    	this.serviceTime = serviceTime;
    	this.numberOfCustomers = numberOfCustomers;
    	this.arrivalInterval = arrivalInterval;
    	customerQueue = new PriorityQueue<>((a, b) -> a.getPriority() - b.getPriority());
        cashier = new Cashier(1);
        barista = new Barista(1);
    }

    public void startSimulation() {

    	for (int i = 1; i <= numberOfCustomers; i++) {
    		double arrivalTime = (i - 1) * arrivalInterval;
    	    int priority = ((i - 1) % 3) + 1;

    	    Customer customer = new Customer(i, arrivalTime, priority);
    	    customerQueue.add(customer);
    	}
    	System.out.println("Priority Queue Scheduling is running.");
        
       
        

        while (!customerQueue.isEmpty()) {

            Customer customer = customerQueue.poll();
            double waitTime = Math.max(0, currentTime - customer.getArrivalTime());
            customer.setWaitTime(waitTime);
            customer.placeOrder();

            cashier.takeOrder(customer);

            Order order = new Order(
                customer.getCustomerID(),
                "Coffee"
            );

            barista.prepareDrink(order);
            currentTime += serviceTime;
            customer.leaveShop();
            
            customersServed++;
            
            totalWaitingTime += customer.getWaitTime();
            maximumWaitingTime = Math.max(maximumWaitingTime, customer.getWaitTime());
            
        }
    }

    public void generateReport() {
        System.out.println("\n===== Simulation Report =====");
        System.out.println("Customers Served: " + customersServed);
        double averageWaitingTime = customersServed > 0
                ? totalWaitingTime / customersServed
                : 0;

        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Maximum Waiting Time: " + maximumWaitingTime);
        
        System.out.println("Simulation Complete");
    }
    public void exportToCSV() {
        double averageWaitingTime = customersServed > 0
                ? totalWaitingTime / customersServed
                : 0;
        java.io.File file = new java.io.File("simulation_results.csv");
        boolean newFile = !file.exists() || file.length() == 0;
      
          
        try (FileWriter writer = new FileWriter("simulation_results.csv", true)) {
        	
        	if (newFile) {
        	    writer.write("Date_Time,Number_of_Customers,Service_Time,Arrival_Interval,Customers_Served,Average_Waiting_Time,Maximum_Waiting_Time\n");
        	}
            writer.write(
                    LocalDateTime.now() + "," +
                    numberOfCustomers + "," +
                    serviceTime + "," +
                    arrivalInterval + "," +
                    
                    customersServed + "," +
     
                    averageWaitingTime + "," +
                    maximumWaitingTime + "\n"
            );

            System.out.println("Results exported to simulation_results.csv");

        } catch (IOException e) {
            System.out.println("Error exporting results: " + e.getMessage());
        }
    }  
}
