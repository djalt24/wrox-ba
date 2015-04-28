package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * A Shellsort implementation
 * 
 * @author David Nelson
 *
 * @param <T> the Comparable being sorted
 */
public class ShellsortListSorter<T extends Comparable<T>> implements ListSorter<T> {
	
	/** separates concern for how to sort T */
	private final Comparator<T> comparator;
	
	/** the h-sort; there are rigorous mathematics behind these numbers */
	private final int[] increments = {121, 40, 13, 4, 1};
	
	/**
	 * Constructor
	 * @param comp the comparator to use for sorting T
	 */
	public ShellsortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		// loop through the h-sort values.
		// h-sort for each; each pass makes the 
		// whole list that much each to sort for
		// each ensuing h-sort effort.
		// note that the last value is 1, ensuring
		// the list is indeed entirely sorted before 
		// returning
		for (int i = 0; i < increments.length; i++) {
			int increment = increments[i];
			hSort(list, increment);
		}
		
		return list;
	}
	
	/**
	 * Perform an h-sort for the increment
	 * @param list the list to h-sort
	 * @param increment the h
	 */
	private void hSort(List<T> list, int increment) {
		// return if list is too small for this increment
		if (list.size() < increment * 2) {
			return;
		}
		
		// effectively create "h" number of sorted
		// sublists
		for (int i = 0; i < increment; i++) {
			sortSubList(list, i, increment);
		}
	}
	
	/**
	 * Sorts a "subList" (increment position + offset) within a given
	 * list
	 * @param list the list to perform the sort in
	 * @param startIndex the starting index
	 * @param increment the offset for sorting
	 */
	private void sortSubList(List<T> list, int startIndex, int increment) {
		// this method uses an in-place variation insertion sort; as such
		// the "first" item in selection sort defaults to "startIndex", so
		// start the loop at "startIndex + increment"
		for (int i = startIndex + increment; i < list.size(); i += increment) {
			
			// the ultimate goal of all of the following code is to find where
			// the "current" item belongs. get it now
			T current = list.get(i);
			
			// j is where the current item needs to be set in our sublist
			int j;
			
			// expand our sorted sublist from left to right (above for loop), 
			// ensuring we are sorted from right to left (this for loop)
			for (j = i; j > startIndex; j -= increment) {
				// get the item one increment just before this index
				T previousValue = list.get(j - increment);
				
				// Comparable Decoder:
				// -1 -> left is before right
				//  0 -> left and right are equal
				//  1 -> right is before left
				//
				// we are looking for the case when the previousValue is in the wrong
				// place and needs to be moved to the right in favor of the current item
				// as an optimization, we know that the list is sorted correctly from one
				// increment back, so if the current item is already placed correctly
				// we can exit the inner loop.
				// that is, looking for when previousValue is before current, or <= 0
				if (comparator.compare(previousValue, current) <= 0) {
					// inner loop is done, current value is at correct j
					break;
				}
				
				// the current value belongs after the current value, put the previous value
				// at j
				list.set(j, previousValue);
				
				// continue on to j + increment, do it again, looking for exact right spot
				// for the current item
			}
			
			// set the current item at j (where at belongs as of now)
			list.set(j, current);
		}
	}
}
