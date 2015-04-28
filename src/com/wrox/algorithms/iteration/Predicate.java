package com.wrox.algorithms.iteration;

/**
 * An interface to support predicate (logic) evaluation.
 * 
 * @author David Nelson
 *
 */
public interface Predicate {

	/**
	 * Returns whether or not the given object passes evaluation
	 * @param o the object to evaluate
	 * @return TRUE if the object passes the evaluation criteria
	 */
	boolean evaluate(Object o);
}
