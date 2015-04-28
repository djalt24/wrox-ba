package com.wrox.algorithms.iteration;

/**
 * A simple power calculater. Maintains multiple strategy (see Design Patterns) objects depending on which instance
 * (approach) is used for the calculation.
 * 
 * @author David Nelson
 *
 */
public class PowerCalculator {

	/** an iterative power calculator */
	public static final PowerCalculator INSTANCE_ITER = new PowerCalculator(Approach.iterative);
	
	/** a recursive power calculator */
	public static final PowerCalculator INSTANCE = new PowerCalculator(Approach.recursive);
	
	/** the different approaches to performing the calculation */
	public enum Approach {iterative, recursive};
	
	/** the strategy for a given power calculator object */
	private Strategy strategy;
	
	/** hide the constructor for this singleton class */
	private PowerCalculator(Approach approach){
		if (approach == Approach.iterative) {
			strategy = new Iterative();
		} else if (approach == Approach.recursive) {
			strategy = new Recursive();
		}
	}
	
	/**
	 * Perform the power calculation.
	 * @param base the base
	 * @param exponent the exponent
	 * @return base^exponent
	 */
	public int calculate(int base, int exponent) {
		return strategy.calculate(base, exponent);
	}
	
	/**
	 * An abstract strategy, to be implemented by children
	 * 
	 * @author David Nelson
	 *
	 */
	private abstract class Strategy {
		/**
		 * Perform the power calculation.
		 * @param base the base
		 * @param exponent the exponent
		 * @return base^exponent
		 */
		public abstract int calculate(int base, int exponent);
	}
	
	/**
	 * An iterative stratgey for calculating x^y
	 * 
	 * @author David Nelson
	 *
	 */
	private class Iterative extends Strategy {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int calculate(int base, int exponent) {
			if (exponent == 0) return 1;
			
			if (exponent == 1) return base;
			
			int rv = 1;
			for (int i = 0; i < exponent; i++) {
				rv *= base;
			}
			
			return rv;
		}	
	}
	
	/**
	 * A recursive strategy for calculating x^y
	 * 
	 * @author David Nelson
	 *
	 */
	private class Recursive extends Strategy {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int calculate(int base, int exponent) {
			if (exponent == 0) return 1;
			
			if (exponent == 1) {
				return base;
			} else {
				return base * calculate(base, exponent - 1);
			}
		}
	}
}
