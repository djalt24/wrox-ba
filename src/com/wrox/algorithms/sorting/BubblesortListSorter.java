package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * A implementation of the Bubblesort (brute-force) algorithm
 * 
 * @author David Nelson
 *
 * @param <T> the <code>Comparable</code> being sorted
 */
public class BubblesortListSorter<T extends Comparable<T>> implements ListSorter<T>{
	
	/** separates the concern for how to compare T */
	private final Comparator<T> comparator;
	
	/**
	 * Constructor
	 * @param comp the comparator to use for sorting T
	 */
	public BubblesortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		// loop through the entire list item by item
		// we start at "1" 'cause we use this index in
		// the math below
		for (int pass = 1; pass < list.size(); pass++) {
			// loop though the list up until the point
			// where we have already established sorted data
			// (this point moves from the end of the list toward the 
			// front for each pass)
			for (int i = 0; i < (list.size() - pass); i++) {
				T left = list.get(i);
				T right = list.get(i + 1);
				
				// Comparable Decoder:
				// -1 -> left is before right
				//  0 -> left and right are equal
				//  1 -> right is before left
				//
				// in bubble sort we are looking for items to "bubble" toward 
				// the top of the list based upon the comparator
				// that is, we are looking for cases when right is before left, or > 0
				if (comparator.compare(left, right) > 0) {
					// right is before left, swap them
					swap(list, i, i + 1);
				}
			}
		}
		
		// return the now sorted list
		return list;
	}
	
	/**
	 * Swap utility method
	 * @param list the list
	 * @param leftIndex the left index to swap with the right
	 * @param rightIndex the right index to swap with the left
	 */
	private void swap(List<T> list, int leftIndex, int rightIndex) {
		T temp = list.get(leftIndex);
		list.set(leftIndex, list.get(rightIndex));
		list.set(rightIndex, temp);
	}
}
