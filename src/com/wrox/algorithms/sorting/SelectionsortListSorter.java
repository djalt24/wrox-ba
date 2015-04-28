package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * An implementation of Selection sort
 * 
 * @author David Nelson
 *
 * @param <T> the type being sorted
 */
public class SelectionsortListSorter<T extends Comparable<T>> implements ListSorter<T> {
	
	/** separates the concern for how to sort T */
	private final Comparator<T> comparator;
	
	/**
	 * Constructor
	 * @param comp the comparator to use for sorting T
	 */
	public SelectionsortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		// loop through entire list, left to right, sorting
		// smallest to largest
		for (int i = 0; i < list.size() - 1; i++) {
			
			// so far this is the smallest
			int smallestIndex = i;
			
			// getting an item could be expensive depending on 
			// list implementation; get it now
			T smallest = list.get(i);
			
			// loop through the remaining items, looking for
			// even smaller items
			for (int j = i + 1; j < list.size(); j++) {
				
				// look at this item
				T current = list.get(j);
				
				// Comparable Decoder:
				// -1 -> left is before right
				//  0 -> left and right are equal
				//  1 -> right is before left
				//
				// in selection sort we are looking for the next smallest item
				// that is, we are looking for cases when current is before right, or < 0
				if (comparator.compare(current, smallest) < 0) {
					smallest = current;
					smallestIndex = j;
				}
			}
			
			// did we find a smaller one? if so then swap
			if (list.get(i) != smallest) {
				swap(list, i, smallestIndex);
			}
		}
		
		return list;
	}
	
	/**
	 * Swap utility function
	 * @param list the list to do the swap in
	 * @param leftIndex the left to swap with the right
	 * @param rightIndex the right to swap with the left
	 */
	private void swap(List<T> list, int leftIndex, int rightIndex) {
		T temp = list.get(leftIndex);
		list.set(leftIndex, list.get(rightIndex));
		list.set(rightIndex, temp);
	}
}
