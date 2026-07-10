package coffeeshopsimulation;

public class Main {

    public static void main(String[] args) {

    	CoffeeShop coffeeShop = new CoffeeShop(4.0, 20);

        coffeeShop.startSimulation();
        coffeeShop.generateReport();
        coffeeShop.exportToCSV();
    }
}
