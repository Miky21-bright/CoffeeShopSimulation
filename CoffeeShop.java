package coffeeshopsimulation;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private Queue<Customer> customerQueue;
    private Cashier cashier;
    private Barista barista;

    public CoffeeShop() {
        customerQueue = new LinkedList<>();
        cashier = new Cashier(1);
        barista = new Barista(1);
    }

    public void startSimulation() {

        Customer c1 = new Customer(1, 0.0);
        Customer c2 = new Customer(2, 1.0);

        customerQueue.add(c1);
        customerQueue.add(c2);

        while (!customerQueue.isEmpty()) {

            Customer customer = customerQueue.poll();

            customer.placeOrder();

            cashier.takeOrder(customer);

            Order order = new Order(
                customer.getCustomerID(),
                "Coffee"
            );

            barista.prepareDrink(order);

            customer.leaveShop();
        }
    }

    public void generateReport() {
        System.out.println("\n===== Simulation Report =====");
        System.out.println("Customers Served: 2");
        System.out.println("Average Waiting Time: 0");
        System.out.println("Simulation Complete");
    }
}
