package com.wrox.algorithms.iteration;

/**
 * A silly exercise in implementing an iterator that is always done iterating
 * 
 * @author David Nelson
 *
 */
public class AlwaysDoneIterator<T> implements Iterator<T> {
	
	/**
	 * Constructor. Almost unnecessary.
	 * @param value some irrelevant value
	 */
	public AlwaysDoneIterator(T[] value) {
		// irrelevant
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		// irrelevant
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		// irrelevant
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		// see the name of this class
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		// irrelevant
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		// irrelevant
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		// we always throw the exception
		throw new IteratorOutOfBoundsException();
	}

}
