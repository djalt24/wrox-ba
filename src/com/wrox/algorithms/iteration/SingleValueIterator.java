package com.wrox.algorithms.iteration;

/**
 * A silly exercise in creating an iterator with only one single value
 * 
 * @author David Nelson
 *
 */
public class SingleValueIterator<T> implements Iterator<T> {
	
	/** our one and only value */
	private T theValue;
	
	/** our done state */
	private boolean isDone = false;
	
	/**
	 * Constructor
	 * @param obj the single value of our iterator
	 */
	public SingleValueIterator(T obj) {
		theValue = obj;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		// first is always theValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		// last is always the Value
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return isDone;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		// next mean's we are done
		isDone = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		// previous means we are done
		isDone = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		// if we are done throw exception
		if (isDone) throw new IteratorOutOfBoundsException();
		
		// return our value
		return theValue;
	}
}
