# Coffee Shop Simulation

## Project Overview
This project is a Java-based Coffee Shop Simulation developed for CS 4632: Modeling and Simulation. The simulation models a coffee shop where customers arrive, place orders, have their drinks prepared, and leave the shop. The project demonstrates queue-based scheduling techniques and basic performance analysis.

## Features
- Customer class
- Cashier class
- Barista class
- Order class
- First Come First Served (FCFS) Scheduling
- Priority Queue Scheduling
- Customer priority levels
- Customer wait time tracking
- Simulation statistics and reporting

## Technologies Used
- Java
- Eclipse IDE
- GitHub

## Project Structure
- `Customer.java` – Represents customers and stores arrival time, priority, and waiting time.
- `Cashier.java` – Handles customer orders.
- `Barista.java` – Prepares customer drinks.
- `Order.java` – Represents drink orders.
- `CoffeeShop.java` – Runs the coffee shop simulation.
- `Main.java` – Starts the simulation.

## How to Run
1. Open the project in Eclipse.
2. Run `Main.java`.
3. View the simulation output in the Eclipse Console.

## Sample Output
```
Priority Queue Scheduling is running.
Customer 2 placed an order.
Cashier 1 takes order from Customer 2
Barista 1 prepares drink for Order 2
Order 2 completed.
Customer 2 left the shop.
Customer 1 placed an order.
Cashier 1 takes order from Customer 1
Barista 1 prepares drink for Order 1
Order 1 completed.
Customer 1 left the shop.

===== Simulation Report =====
Customers Served: 2
Average Waiting Time: 0.0
Simulation Complete
```

## Current Status
Completed:
- Customer Class
- Cashier Class
- Barista Class
- FCFS Scheduling
- Priority Queue Scheduling
- Data Collection
- Waiting Time Calculation
- Statistics Generation
- Simulation Testing

Remaining:
- Final project documentation


