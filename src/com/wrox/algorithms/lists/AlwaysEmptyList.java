package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;


/**
 * Chapter 3 Exercise 7
 * Create a list that is always empty and throws UnsupportedOperationException
 * if an attempt is made to modify it.
 * 
 * @author David Nelson
 *
 * @param <T>  the list value type
 */
public class AlwaysEmptyList<T> implements List<T> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(int index, Object value)
			throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		throw new IndexOutOfBoundsException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {		
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(T value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(T value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(T value) {
		assert value != null : "value cannot be null";
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		// do nothing
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
}
