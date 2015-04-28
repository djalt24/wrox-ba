package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

/**
 * An implementation of a LinkedList
 * 
 * @author David Nelson
 *
 * @param <T> the type of value in the linked list
 */
public class LinkedList<T> implements List<T> {
	
	/** all hail the SENTINAL */
	private final Element SENTINAL = new Element(null);
	
	/** tracking the list size */
	private int size;
	
	/**
	 * Constructor
	 */
	public LinkedList() {
		clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<T> iterator() {
		// create a special iterator optimized for linked lists
		return new ValueIterator<T>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		assert value != null : "value cannot be null";
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		Element element = new Element(value);
		element.insertIntoListBefore(getElement(index));
		++size;
	}
	
	/**
	 * Chapter 3 Exercise 5<br>
	 * Implement the core LinkedList method getElement
	 * with consideration of the placement of index with
	 * respect to the size of the list.
	 * 
	 * @return the element at index
	 */
	private Element getElement(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		Element element;
		
		if (index > size / 2) {
			// set element to the SENTINAL for backwards iterating
			//    A <- SENT -> B
			// this accounts for the fact that index 0 is really the first
			// element in the list when the list is not empty
			element = SENTINAL; // accounts for index 0
			
			// loop the distance between the total size and the index
			// moving backward (starting from the sentinal, accounts for 0 index)
			// each time
			for (int i = size - index; i > 0; --i) {
				element = element.previous; 
			}
		} else {			
			// set element to the first entry AFTER SENTINAL
			// this accounts for the fact that index 0 is really the first
			// element in the list, or the SENTINAL if the list is empty
			element = SENTINAL.next; // accounts for index 0
			
			// loop from index back to 0, moving forward each time
			for (int i = index; i > 0; --i) {
				element = element.next;
			}
		}
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		return (T)getElement(index).value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		Element remove = getElement(index);
		remove.detach();
		--size;
		return (T)remove.value;
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
		assert value != null : "value cannot be null";		
		checkOutOfBounds(index);
		
		Element element = getElement(index);
		T oldValue = (T)element.value;
		element.value = value;
		
		return oldValue;
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
	public boolean delete(T value) {
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
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(T value) {
		assert value != null : "value cannot be null";
		
		int index = 0;
		
		for (Element e = SENTINAL.next; e != SENTINAL; e = e.next) {
			if (value.equals(e.value)) {
				return index;
			}
			
			++index;
		}
		
		return -1;
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
		SENTINAL.previous = SENTINAL;
		SENTINAL.next = SENTINAL;
		size = 0;
		
	}
	
	/**
	 * Utility to bounds check the index
	 * @param index the index to check
	 */
	private void checkOutOfBounds(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * An element of the linked list.
	 * @author David Nelson
	 *
	 */
	private static final class Element<T> {
		/** the value */
		private T value;
		
		/** the previous element */
		private Element previous;
		
		/** the next element */
		private Element next;
		
		/**
		 * Constructor
		 * @param inputValue the element value
		 */
		public Element(T inputValue) {
			value = inputValue;
		}
		
		/**
		 * The key method of Element; inserts an Element into the
		 * list just before the input element
		 * @param element the element to be inserted in front of
		 */
		public void insertIntoListBefore(Element element) {
			assert element != null : "element cannot be null";
			
			Element rightSide = element;
			Element leftSide = element.previous;
			
			this.next     = rightSide;
			this.previous = leftSide;
			
			rightSide.previous = this;
			leftSide.next = this;
		}
		
		/**
		 * Removes an element from the list
		 */
		public void detach() {
			previous.next = next;
			next.previous = previous;
		}
	}
	
	/**
	 * An iterator optimized for LinkedList
	 * 
	 * @author David Nelson
	 *
	 * @param <T> the type being iterated over
	 */
	private final class ValueIterator<T> implements Iterator<T> {
		
		/** starts with the sentinal */
		Element current = SENTINAL;

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void first() {
			current = SENTINAL.next;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void last() {
			current = SENTINAL.previous;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isDone() {
			return current == SENTINAL;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void next() {
			current = current.next;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void previous() {
			current = current.previous;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public T current() throws IteratorOutOfBoundsException {
			if (isDone()) {
				throw new IteratorOutOfBoundsException();
			}
			
			return (T)current.value;
		}		
	}
}
