package coffeeshopsimulation;

import java.util.PriorityQueue;
import java.util.Random;
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
    private int maximumQueueLength = 0;
    
    private double currentTime = 0;
    private double serviceTime = 3;
    private int numberOfCustomers;
    private double arrivalInterval;
    private Random random;
    
    private double cashierBusyTime = 0;
    private double baristaBusyTime = 0;
    
    public CoffeeShop(
            double serviceTime,
            int numberOfCustomers,
            double arrivalInterval) {

        this(
            serviceTime,
            numberOfCustomers,
            arrivalInterval,
            System.nanoTime()
        );
    }

    public CoffeeShop(
            double serviceTime,
            int numberOfCustomers,
            double arrivalInterval,
            long seed) {

        this.serviceTime = serviceTime;
        this.numberOfCustomers = numberOfCustomers;
        this.arrivalInterval = arrivalInterval;
        this.random = new Random(seed);

        customerQueue = new PriorityQueue<>(
            (a, b) -> Double.compare(
                a.getArrivalTime(),
                b.getArrivalTime()
            )
        );

        cashier = new Cashier(1);
        barista = new Barista(1);
    }
    

    public void startSimulation() {

    	double arrivalClock = 0.0;

    	for (int i = 1; i <= numberOfCustomers; i++) {

    	    if (i > 1) {
    	        double randomGap =
    	            arrivalInterval + (random.nextDouble() - 0.5);

    	        if (randomGap < 0.5) {
    	            randomGap = 0.5;
    	        }

    	        arrivalClock += randomGap;
    	    }

    	    double arrivalTime = arrivalClock;
    	    int priority = (i - 1) % 3 + 1;

    	    Customer customer =
    	        new Customer(i, arrivalTime, priority);

    	    customerQueue.add(customer);
    	}
    	    
    	
    	//System.out.println("Priority Queue Scheduling is running.");
        
       
        

        while (!customerQueue.isEmpty()) {

            Customer customer = customerQueue.poll();
            if (currentTime < customer.getArrivalTime()) {
                currentTime = customer.getArrivalTime();
            }
            double waitTime = Math.max(0, currentTime - customer.getArrivalTime());
            customer.setWaitTime(waitTime);
            customer.placeOrder();

            cashier.takeOrder(customer);
            cashierBusyTime += serviceTime;
            
            Order order = new Order(
                customer.getCustomerID(),
                "Coffee"
            );

            barista.prepareDrink(order);
            baristaBusyTime += serviceTime;
            currentTime += serviceTime;
            customer.leaveShop();
            
            customersServed++;
            
            totalWaitingTime += customer.getWaitTime();
            maximumWaitingTime = Math.max(maximumWaitingTime, customer.getWaitTime());
            int currentQueueLength = 0;

            for (Customer waitingCustomer : customerQueue) {
                if (waitingCustomer.getArrivalTime() <= currentTime) {
                    currentQueueLength++;
                }
            }

            maximumQueueLength = Math.max(maximumQueueLength, currentQueueLength);
            
        }
    }

    public void generateReport() {
        System.out.println("\n===== Simulation Report =====");
        System.out.println("Customers Served: " + customersServed);
        double averageWaitingTime = customersServed > 0
                ? totalWaitingTime / customersServed
                : 0;
        
        double cashierUtilization = currentTime > 0
        	    ? (cashierBusyTime / currentTime) * 100
        	    : 0;

        	double baristaUtilization = currentTime > 0
        	    ? (baristaBusyTime / currentTime) * 100
        	    : 0;

        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Maximum Waiting Time: " + maximumWaitingTime);
        System.out.println("Maximum Queue Length: " + maximumQueueLength);
        
        System.out.println("Cashier Utilization: " + cashierUtilization + "%");
        System.out.println("Barista Utilization: " + baristaUtilization + "%");

        System.out.println("Simulation Complete");
        
    }
    public void exportToCSV(double executionTimeMs) {
        double averageWaitingTime = customersServed > 0
                ? totalWaitingTime / customersServed
                : 0;
        
        double cashierUtilization = currentTime > 0
        	    ? (cashierBusyTime / currentTime) * 100
        	    : 0;
        
        double baristaUtilization = currentTime > 0
        	    ? (baristaBusyTime / currentTime) * 100
        	    : 0;
        
        java.io.File file = new java.io.File("simulation_results.csv");
        boolean newFile = !file.exists() || file.length() == 0;
      
          
        try (FileWriter writer = new FileWriter("simulation_results.csv", true)) {
        	
        	if (newFile) {
        		writer.write("Date_Time,Number_of_Customers,Service_Time,Arrival_Interval,Customers_Served,Average_Waiting_Time,Maximum_Waiting_Time,Maximum_Queue_Length,Cashier_Utilization,Barista_Utilization,Execution_Time_ms\n");
        	}
            writer.write(
                    LocalDateTime.now() + "," +
                    numberOfCustomers + "," +
                    serviceTime + "," +
                    arrivalInterval + "," +
                    
                    customersServed + "," +
     
                    averageWaitingTime + "," +
                    
                    maximumWaitingTime + "," +
                    maximumQueueLength + "," +
                    cashierUtilization + "," +
                    baristaUtilization + "," +
                    executionTimeMs + "\n"
            );

            System.out.println("Results exported to simulation_results.csv");

        } catch (IOException e) {
            System.out.println("Error exporting results: " + e.getMessage());
        }
    
   }  
    

    public double getAverageWaitingTime() {

        if (customersServed == 0) {
            return 0;
        }

        return totalWaitingTime / customersServed;
    }

    }
    
    
    

