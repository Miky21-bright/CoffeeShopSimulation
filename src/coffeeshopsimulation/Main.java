package coffeeshopsimulation;

public class Main {

    public static void main(String[] args) {

    	CoffeeShop coffeeShop = new CoffeeShop(2.0, 10, 3.0);

    	long startTime = System.nanoTime();

    	coffeeShop.startSimulation();

    	long endTime = System.nanoTime();
    	double executionTimeMs = (endTime - startTime) / 1_000_000.0;

    	coffeeShop.generateReport();
    	coffeeShop.exportToCSV(executionTimeMs);

    	System.out.println("Execution Time: " + executionTimeMs + " ms");
    }
}
