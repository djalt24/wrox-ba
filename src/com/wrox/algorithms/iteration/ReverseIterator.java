package com.wrox.algorithms.iteration;

/**
 * An Iterator to iterate in reverse over a given <code>Iterator</code>
 * @author David Nelson
 *
 */
public class ReverseIterator<T> implements Iterator<T> {
	
	/** a reference to the iterator being reversed */
	private final Iterator<T> internal;
	
	/**
	 * Constructor.
	 * Provides for a reverse iteration for a given <code>Iterator</code>
	 * @param iterator the iterator to reverse iteration upon
	 */
	public ReverseIterator(Iterator<T> iterator){
		internal = iterator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		internal.last();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		internal.first();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return internal.isDone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		internal.previous();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		internal.next();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		return internal.current();
	}
}
