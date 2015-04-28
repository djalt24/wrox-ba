package com.wrox.algorithms.iteration;

/**
 * A <code>Predicate</code> that is the logical 'and' (&&) between two <code>Predicate</code>'s.
 * 
 * @author David Nelson
 *
 */
public class AndPredicate implements Predicate {
	
	/** the left value */
	private final Predicate lValue;
	
	/** the right value */
	private final Predicate rValue;
	
	/**
	 * Constructor. 
	 * Creates a <code>Predicate</code> that is the logical and between the left and right inputs
	 * @param left the left predicate
	 * @param right the right predicate
	 */
	public AndPredicate(final Predicate left, final Predicate right) {
		lValue = left;
		rValue = right;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean evaluate(final Object o) {
		return lValue.evaluate(o) && rValue.evaluate(o);
	}

}
