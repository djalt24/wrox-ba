package com.wrox.algorithms.iteration;

/**
 * An <code>Iterator</code> that only visits every n values during iteration.
 * 
 * @author David Nelson
 *
 */
public class NthArrayIterator<T> implements Iterator<T> {
	
	/** the skip */
	int nVal = 1;
	
	/** a delegate iterator (Decorator Pattern) */
	Iterator<T> wrapped;
	
	/**
	 * Constructor.
	 * @param values the values to iterator over
	 * @param n the 'nth' value to process for each iteration
	 */
	public NthArrayIterator(T[] values, int n) {
		wrapped = new ArrayIterator<>(values);
		nVal = n;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		wrapped.first();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		wrapped.last();
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
		for (int i = 0; i < nVal - 1; i++) {
			wrapped.next();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		wrapped.previous();
		for (int i = 0; i < nVal - 1; i++) {
			wrapped.previous();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		return wrapped.current();
	}

}
