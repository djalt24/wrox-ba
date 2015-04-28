package com.wrox.algorithms.iteration;

/**
 * An interface to define clear iteration behavior for an object
 * 
 * @author David Nelson
 *
 */
public interface Iterator<T> {
	
	/** sets the iterator to the first item */
	void first();
	
	/** sets the iterator to the last item */
	void last();
	
	/**
	 * Returns true if the iterator has no items left to iterate over.
	 * @return true if the iterator has no items left to iterate over.
	 */
	boolean isDone();
	
	/** 
	 * Moves the iterator to the next item.
	 */
	void next();
	
	/**
	 * Moves the iterato to the previous item.
	 */
	void previous();
	
	/**
	 * Returns the current item of iteration
	 * @return the current item of iteration
	 * @throws IteratorOutOfBoundsException
	 */
	T current() throws IteratorOutOfBoundsException;
}
