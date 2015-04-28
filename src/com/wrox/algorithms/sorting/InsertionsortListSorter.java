package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

/**
 * An implementation of Insertionsort
 * 
 * @author David Nelson
 *
 * @param <T> the <code>Comparable</code> we are sorting
 */
public class InsertionsortListSorter<T extends Comparable<T>> implements ListSorter<T> {
	
	/** separates the concern for how to order T */
	private final Comparator<T> comparator;
	
	/**
	 * Constructor
	 * @param comp the comparator to use for sorting T
	 */
	public InsertionsortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		// linked lists are great for insertion
		LinkedList<T> rv = new LinkedList<>();
		
		// iterate over every item in the input list
		Iterator<T> outer = list.iterator();
		outer.first();
		
		// the return list will be sorted, add the first item now
		rv.insert(0, outer.current());
		
		// next object in input list
		outer.next();
		
		// while we have items remaining in our input list
		while(!outer.isDone()) {
			
			// need to handle case where the item belongs at the
			// very end of our return list
			boolean inserted = false;
			
			// loop through all the items in our RETURN list
			// looking for the correct spot to insert the current
			// iteration item
			for (int i = 0; i < rv.size(); i++) {
				// Comparable decoder:
				// -1 -> left is before right
				//  0 -> left and right are equal
				//  1 -> right is before left
				//
				// in our case, we are looking for cases where the item
				// we are processing belongs in an insertion spot
				// that is, the case where the LEFT (input item) should be before the
				// RIGHT (return value item), or < 0
				// 
				// note: the comparator separates the concern of how to determine
				// what item should be before another
				//
				// check if outer.current belongs BEFORE rv(i)
				if (comparator.compare(outer.current(), rv.get(i)) < 0) {
					// insert outer.current before rv(i)
					rv.insert(i, outer.current());
					inserted = true;
					break; // makes this sorting algorithm adaptive
				}				
			}
			
			// the case when the current input list item belongs at the very end of our
			// return list at this time
			if (!inserted) {
				rv.add(outer.current());
			}
			
			// next input item
			outer.next();
		}
		
		// return the sorted list
		return rv;
	}
}
