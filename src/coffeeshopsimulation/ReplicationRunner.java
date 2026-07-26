package coffeeshopsimulation;

import java.util.ArrayList;

public class ReplicationRunner {
	public static void runExperiment(
	        String scenario,
	        int customers,
	        double serviceTime,
	        double arrivalInterval) {

	    int replications = 30;

	    ArrayList<Double> averageWaits =
	            new ArrayList<>();

	    for (int seed = 1; seed <= replications; seed++) {

	        CoffeeShop coffeeShop =
	                new CoffeeShop(
	                        serviceTime,
	                        customers,
	                        arrivalInterval,
	                        seed);

	        coffeeShop.startSimulation();

	        averageWaits.add(
	                coffeeShop.getAverageWaitingTime());
	    }

	    double sum = 0;

	    for (double wait : averageWaits) {
	        sum += wait;
	    }

	    double mean = sum / replications;

	    double squaredDifferenceSum = 0;

	    for (double wait : averageWaits) {
	        squaredDifferenceSum +=
	                Math.pow(wait - mean, 2);
	    }

	    double standardDeviation =
	            Math.sqrt(
	                    squaredDifferenceSum /
	                    (replications - 1));

	    double standardError =
	            standardDeviation /
	            Math.sqrt(replications);

	    double tCritical = 2.045;

	    double margin =
	            tCritical * standardError;

	    System.out.println("\n==============================");
	    System.out.println("Scenario: " + scenario);
	    System.out.println("==============================");
	    System.out.println("Mean Waiting Time: " + mean);
	    System.out.println("Standard Deviation: " + standardDeviation);
	    System.out.println("95% Confidence Interval: "
	            + (mean - margin)
	            + " to "
	            + (mean + margin));
	}
	public static void main(String[] args) {


		    
		    runExperiment("Light Load", 10, 2.0, 4.0);

		    
		    runExperiment("Normal Load", 20, 2.0, 3.0);

		    
		    runExperiment("Heavy Load", 30, 3.0, 2.0);
		}
	



    }

		
	


