# Coffee Shop Simulation

## Project Overview
This project is a Java-based discrete event simulation of a coffee shop. It models customer arrivals, ordering, waiting in line, service by baristas, and departure from the coffee shop. The simulation collects performance statistics to evaluate the efficiency of the system under different workloads.

## Features
- Discrete-event coffee shop simulation
- Customer queue management
- Configurable simulation parameters
- Multiple statistical replications
- Mean waiting time calculation
- Standard deviation calculation
- 95% confidence interval calculation
- CSV output of simulation results

## Technologies Used
- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure
- `src/` – Java source code
- `config.txt` – Simulation configuration
- `simulation_results.csv` – Simulation output
- `.project` and `.classpath` – Eclipse project files

## Configuration
The simulation parameters are stored in `config.txt`.

Example:

numberOfCustomers=10
serviceTime=2.0
arrivalInterval=4.0
randomSeed=100

These values can be modified to test different simulation scenarios.

## Build and Run Instructions

1. Clone the repository.
2. Open the project in Eclipse.
3. Ensure Java JDK 21 (or your installed version) is configured.
4. Run `Main.java` or `ReplicationRunner.java`.
5. View the simulation results in the console and in `simulation_results.csv`.

## Output
The simulation reports:
- Mean Waiting Time
- Standard Deviation
- 95% Confidence Interval

Results are also exported to a CSV file for further analysis.

## Repository

GitHub Repository:
https://github.com/Miky21-bright/CoffeeShopSimulation

## Author

Milcyas Amualto

## License

This project was developed as part of the CS 4632 Simulation and Modeling course at Kennesaw State University.
