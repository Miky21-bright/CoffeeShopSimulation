package coffeeshopsimulation;

public class Main {

    public static void main(String[] args) {

    	CoffeeShop coffeeShop = new CoffeeShop(3.0, 10);

        coffeeShop.startSimulation();
        coffeeShop.generateReport();
    }
}
