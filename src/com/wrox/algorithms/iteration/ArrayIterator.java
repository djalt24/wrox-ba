package com.wrox.algorithms.iteration;

/**
 * An Iterator to iterate over an Object array (<code>Object[]</code>)
 * 
 * @author David Nelson
 *
 */
public class ArrayIterator<T> implements Iterator<T> {
	
	/** a reference to the array being iterated over */
	private final T[] internal;
	
	/** the start index of the iteration */
	private final int start;
	
	/** the end index of the iteration */
	private final int end;
	
	/** the current index of iteration */
	private  int current = -1;
	
	/**
	 * Constructor.
	 * Initializes iterator to iterate over the specified range.
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	public ArrayIterator(T[] array, int startIndex, int length){
		assert array != null : "array can't be null";
		assert startIndex >= 0 : "start can't be < 0";
		assert startIndex < array.length : "start can't be > array.length";
		assert length >= 0: "length can't be < 0";
		
		internal = array;
		start = startIndex;
		end = start + length - 1;
		
		assert end < array.length : "end cannot be greater than length";
	}
	
	/**
	 * Constructor. 
	 * Initializes iterator to iterate over entire array.
	 * @param array
	 */
	public ArrayIterator(T[] array) {
		assert array != null : "array can't be null";
		
		internal = array;
		start = 0;
		end = array.length - 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void first() {
		current = start;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void last() {
		current = end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDone() {
		return current < start || current > end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		++current;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous() {
		--current;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T current() throws IteratorOutOfBoundsException {
		if (isDone()) {
			throw new IteratorOutOfBoundsException();
		}
		return (T)internal[current];
	}
}
