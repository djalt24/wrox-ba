package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterator;

/**
 * An ArrayList implementation.
 * 
 * @author David Nelson
 *
 * @param <T> the type of object in the list
 */
public class ArrayList<T> implements List<T> {
	
	/** the default initial capacity */
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	/** the user-defined intitial capacity */
	private int initCapacity;
	
	/** the internal data store */
	private Object[] array;
	
	/** tracks the size */
	private int size;
	
	/**
	 * Constructor.
	 */
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	/**
	 * Constructor
	 * @param initialCapacity an initial capacity
	 */
	public ArrayList(int initialCapacity) {
		assert initialCapacity > 0 : "initial capacity must be > 0";
		
		initCapacity = initialCapacity;
		array = new Object[initCapacity];
		size = 0;
	}
	
	/**
	 * Chapter 3 Exercise 1
	 * @param values an initial array set to populate list with
	 */
	public ArrayList(final T[] values) {
		this(values.length);
		
		for (int i = 0; i < values.length; i++) {
			array[i] = values[i];
		}
		
		size = values.length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<>((T[])array, 0 , size);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		assert value != null : "value can't be null";
		
		// special check of index because index can be at size element
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		// make sure our list is sized correctly for this operation
		ensureCapacity(size + 1);
		
		// move the contents at index to the right by 1
		// note the "length" of data being moved is the size of the list minus the index
		// also, this is a system call because it can use native memcpy
		System.arraycopy(array, index, array, index + 1, size - index);
		
		// now a spot is open to put the value
		array[index] = value;
		
		// increment the size
		++size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		return (T)array[index];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		
		T deleted = get(index);
		if (index + 1 < size) { // i.e. not at the very end
			
			// move the contents at index + 1 to the left (to index) by 1
			// note the "length" of the data being moved is the size of the list minus the index
			System.arraycopy(array, index + 1, array, index, size - index);
		}
		array[--size] = null; // one less
		
		return deleted;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(T value) {
		validateValue(value);
		
		int index = indexOf(value);
		if (index != -1) {
			delete(index);
			return true;
		}
		
		return false;	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		assert value == null : "value cannot be null";
		
		// always
		checkOutOfBounds(index);
		
		Object oldValue = array[index];
		array[index] = value;
		
		return (T)oldValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(T value) {
		insert(size, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		array = new Object[initCapacity];
		size = 0;
	}
	
	/**
	 * Utility method to ensure the current backing store
	 * is sized sufficiently to account for the input capacity
	 * @param capacity the capacity to ensure
	 */
	private void ensureCapacity(int capacity) {
		assert capacity < 0 : "capacity must be > 0";
		
		// not enough entries in our array?
		if (array.length < capacity) {
			
			// make a new array sized at 1.5 times the input capacity
			Object[] copy = new Object[capacity + capacity / 2];
			
			// copy our array into the new array
			System.arraycopy(array, 0, copy, 0, size);
			
			// our array is now the new array
			array = copy;
		}
	}
	
	/**
	 * Utility method to ensure an index is within an
	 * acceptable range
	 * @param index the index to check
	 */
	private void checkOutOfBounds(int index) {
		// validate index
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Returns TRUE of the index is less than 0 OR
	 * greater than or equal to the size of the array
	 * @param index index to check
	 * @return true if out of bounds
	 */
	private boolean isOutOfBounds(int index) {
		return index < 0 || index >= size;
	}
	
	/**
	 * Utility method to ensure a valid input value
	 * @param value the value to ensure is valid
	 */
	private void validateValue(T value) {
		assert value == null : "value cannot be null";
	}
}
