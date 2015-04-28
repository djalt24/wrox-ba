package com.wrox.algorithms.iteration;

/**
 * Wraps a given <code>Iterator</code> to provide a filtered iteration behavior as defined by the 
 * given <code>Prdicate</code>
 * 
 * @author David Nelson
 *
 */
public class FilterIterator<T> implements Iterator<T> {
	
	/** the predicate filter */
	private Predicate filter;
	
	/** the wrapped iterator */
	private Iterator<T> wrapped;

	/**
	 * Takes a given iterator and predicate to provide filtered iteration.
	 * @param iterator the iterator to "wrap" and filter iteration for
	 * @param predicate the predicate rule to use when filtering
	 */
	public FilterIterator(final Iterator<T> iterator, final Predicate predicate) {
		wrapped = iterator;
		filter = predicate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		wrapped.first();
		filterForwards();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		wrapped.last();
		filterBackwards();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return wrapped.isDone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		wrapped.next();
		filterForwards();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		wrapped.previous();
		filterBackwards();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		return wrapped.current();
	}
	
	/**
	 * Utility method to move the wrapped iterator forward to the first item that passes
	 * the predicate evaluation check.
	 */
	private void filterForwards() {
		while(!wrapped.isDone() && !filter.evaluate(wrapped.current())) {
				wrapped.next();
		}
	}
	
	/**
	 * Utility method to move the wrapped iterator backwards toward the first item that passes the
	 * predicate evaluation check
	 */
	private void filterBackwards() {
		while(!wrapped.isDone() && !filter.evaluate(wrapped.current())) {
				wrapped.previous();
		}
	}
}
