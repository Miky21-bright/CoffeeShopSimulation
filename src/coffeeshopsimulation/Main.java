package coffeeshopsimulation;
import java.io.FileInputStream;
import java.util.Properties;
public class Main {

    public static void main(String[] args) {
    	try {
    	    Properties config = new Properties();
    	    config.load(new FileInputStream("config.txt"));

    	    int numberOfCustomers = Integer.parseInt(config.getProperty("numberOfCustomers"));
    	    double serviceTime = Double.parseDouble(config.getProperty("serviceTime"));
    	    double arrivalInterval = Double.parseDouble(config.getProperty("arrivalInterval"));

    	    CoffeeShop coffeeShop = new CoffeeShop(serviceTime, numberOfCustomers, arrivalInterval);

    	    long startTime = System.nanoTime();

    	    coffeeShop.startSimulation();

    	    long endTime = System.nanoTime();
    	    double executionTimeMs = (endTime - startTime) / 1_000_000.0;

    	    coffeeShop.generateReport();
    	    coffeeShop.exportToCSV(executionTimeMs);

    	    System.out.println("Execution Time: " + executionTimeMs + " ms");

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	
    	
    }
}
