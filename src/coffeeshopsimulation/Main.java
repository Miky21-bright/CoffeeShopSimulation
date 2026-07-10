package coffeeshopsimulation;

public class Main {

    public static void main(String[] args) {

    	CoffeeShop coffeeShop = new CoffeeShop(2.0, 10, 3.0);

        coffeeShop.startSimulation();
        coffeeShop.generateReport();
        coffeeShop.exportToCSV();
    }
}
