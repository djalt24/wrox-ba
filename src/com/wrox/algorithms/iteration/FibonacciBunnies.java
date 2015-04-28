package com.wrox.algorithms.iteration;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is written as a demonstration of where recursive logic is warranted,
 * but not used. Look at the complexity; one solution uses OO (memory, overhead)
 * the other is limited by the size of the data structure holding values unnecessarily.
 * 
 * @author David Nelson
 *
 */
public class FibonacciBunnies {
	
	/** number of months in the problem */
	private static final int MONTHS = 12;
	
	/** bunnies take this long to mature */
	private static final int MONTHS_TO_MATURE = 1;
	
	/** bunnies take this long to make a baby */
	private static final int MONTHS_TO_PRODUCE = 1;
	
	/** the field of bunnies */
	private static final List<BunnyPair> BUNNIES = new ArrayList<BunnyPair>();
	
	/** a data structure for calculating the solution using fibonacci sequence approach */
	private static int[] sequence = new int[13];

	/**
	 * A test main
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The year is 1202, and Fibonacci posed the following quesiton: ");
		System.out.println("\"Ahem...in perfect conditions, given one male and one female soft and"
						+ " cuddly bunny pair, after one year of non-stop mating, how many"
						+ " bunnies would there be?\"");
		System.out.println("Let's work through it. There are " + MONTHS + " months in Fibanacci's question");
		System.out.println("It takes " + MONTHS_TO_MATURE + " month(s) for the bunnies to get old enough to mate");
		System.out.println("After mating, it takes " + MONTHS_TO_PRODUCE + " month(s) for the bunnies to be born");
		
		System.out.println("Before day 1, there were " +  BUNNIES.size() + " bunny pairs");
		
		BUNNIES.add(new BunnyPair());
		
		for (int i = 0; i <= MONTHS; i++) {
			System.out.println("After month " + i +", there are " + BUNNIES.size() +" pairs");
			matureBunnies();
		}
				
		System.out.println("\nThere is another way to do this, recognize this problem as Fibanacci sequence..." +
				           "althougth slightly modified since the initial condition is 1 not 0\n");
		sequence[0] = 1;
		sequence[1] = 1;
		
		for (int i=2; i < MONTHS + 1; i++) {
			sequence[i] = sequence[i-2] + sequence[i-1];
		}
		
		for (int i=0; i < MONTHS + 1; i++) {
			System.out.println("After month " + i +", there are " + sequence[i] +" pairs");
		}
		
	}
	
	/**
	 * Populates the bunny field
	 */
	private static void matureBunnies() {
		List<BunnyPair> newBunnies = new ArrayList<BunnyPair>();
		for (BunnyPair pair : BUNNIES) {
			pair.age += 1; // aged
			if (pair.age >= 2) {
				newBunnies.add(new BunnyPair()); // born
			}
		}
		
		for (BunnyPair pair : newBunnies) {
			BUNNIES.add(pair);
		}
	}
	
	/**
	 * A pair of bunnies of a certain age
	 * @author David Nelson
	 *
	 */
	private static class BunnyPair {
		/** the age of the pair */
		int age = 0;
	}
}
