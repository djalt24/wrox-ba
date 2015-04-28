package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterable;
import com.wrox.algorithms.iteration.Iterator;

/**
 * An interface for a list.
 * 
 * @author David Nelson
 *
 * @param <T> a type of object in the list
 */
public interface List<T> extends Iterable<T> {

	// four core list operations
	
	/**
	 * Inserts value at index
	 * @param index the value
	 * @param value the index
	 * @throws IndexOutOfBoundsException if index is not valid
	 */
	void insert(int index, T value) throws IndexOutOfBoundsException;
	
	/**
	 * Returns a value at index
	 * @param index the index
	 * @return the value at index
	 * @throws IndexOutOfBoundsException
	 */
	T get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Deletes (and returns) a value at index
	 * @param index the index
	 * @return the value at index after deletion
	 * @throws IndexOutOfBoundsException
	 */
	T delete(int index) throws IndexOutOfBoundsException; 
	
	/**
	 * Returns the size of the list
	 * @return the size of the list
	 */
	int size();
	
	// 8 convenience operations
	
	/**
	 * Sets the value at the index, returning the replaced value
	 * @param index the index
	 * @param value the value
	 * @return the original value which was replaced
	 * @throws IndexOutOfBoundsException
	 */
	T set(int index, T value) throws IndexOutOfBoundsException;
	
	/**
	 * Adds a value to the end of the list
	 * @param value the value
	 */
	void add(T value);
	
	/**
	 * Deletes a value from the list
	 * @param value the value to delete
	 * @return TRUE if successful, otherwise FALSE
	 */
	boolean delete(T value);
	
	/**
	 * Returns TRUE if the value is in the list
	 * @param value the value to search for
	 * @return TRUE if the value is in the list
	 */
	boolean contains(T value);
	
	/**
	 * Chapter 3 Exercise 6
	 * Re-write indexOf so it can work on any list
	 * @param value the value to search for
	 * @return the index of the value, or -1 if it's not found
	 */
	default int indexOf(T value) {
		
		// note, this isn't always the most efficient, it
		// will work for any list, perhaps at great cost
		// i.e. LinkedList
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(value)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns TRUE if the list is empty
	 * @return TRUE if the list is empty
	 */
	boolean isEmpty();
	
	/**
	 * Clears the list
	 */
	void clear();
	
	// the eighth is Iterator iterator() inherited from Iterator<T>
	
	/**
	 * Chapter 3 Exercise 2
	 * Write an equals that works for any list implementation
	 * @param value the value to check
	 * @return true if the list is equal
	 */
	default boolean equalsHelper(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).equals(get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Chapter 3 Exercise 2
	 * If you override equals, override hashCode
	 * you can't do that in default method, but can write a matching
	 * helper
	 * @return
	 */
	default int hashCodeHelper() {
		int rv = 0;
		for (int i = 0; i < size(); i++) {
			rv ^= get(i).hashCode();
		}

		return rv;
	}
	
	/**
	 * Chapter 3 Exercise 3
	 * Write a toString that will work for any List implementation
	 * @return [A, B, C], or [] for empty list
 	 */
	default String toStringHelper() {
		StringBuffer rv = new StringBuffer();
		rv.append("[");
		for (int i = 0; i < size(); i++) {
			rv.append(get(i).toString());
			if (i != size() - 1) {
				rv.append(", ");
			}
		}
		
		rv.append("]");
		return rv.toString();
	}
	
	/**
	 * Chapter 3 Exercise 4
	 * Write an Iterator implementation that will work for any List implementation
	 * {@inheritDoc}
	 */
	default Iterator<T> iterator() {
		// performance implication: have to choose an iterator implementation,
		// then ensure we give it what it needs no matter what kind of list
		// we are
		final Object[] array = new Object[size()];
		for (int i = 0; i < size(); i++) {
			array[i] = get(i);
		}
		
		return new ArrayIterator<T>((T[])array, 0, size());
	}
}
