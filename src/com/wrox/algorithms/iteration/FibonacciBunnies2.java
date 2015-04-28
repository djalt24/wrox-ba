package com.wrox.algorithms.iteration;

/**
 * This class solves the Fibonacci Bunnies problem using recursion. So simple.
 * 
 * @author David Nelson
 *
 */
public class FibonacciBunnies2 {

	/**
	 * Simple test harness
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Fibonacci[12] is " + rabbits(12));
		System.out.println("Fibonacci[30] is " + rabbits(30));
		
		for (int i=0; i <= 12; i++) {
			System.out.println("F[" + i + "] is " + rabbits(i));
		}
	}
	
	/**
	 * Calculates the fibanocci value of month recursively.
	 * EXITS on month == 0 or month == 1.
	 * 
	 * @param month the month to calculated F[n] of.
	 * @return the value F[month]
	 */
	public static int rabbits(int month) {
		// exits recursion
		if (month == 0) {
			return 0;
		}
		
		// exits recursion
		if (month == 1) {
			return 1;
		}
		return rabbits(month-2) + rabbits(month-1);
	}
}
