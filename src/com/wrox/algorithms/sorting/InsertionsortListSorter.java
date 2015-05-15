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
		LinkedList<T> sorted = new LinkedList<>();
		
		// iterate over every item in the input list
		Iterator<T> outer = list.iterator();
		outer.first();
		
		// the return list will be sorted, add the first item now
		sorted.insert(0, outer.current());
		
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
			for (int i = 0; i < sorted.size(); i++) {
				// check if outer.current belongs BEFORE sorted(i)
				if (comparator.compare(outer.current(), sorted.get(i)) < 0) {
					// insert outer.current before rv(i)
					sorted.insert(i, outer.current());
					inserted = true;
					break; // makes this sorting algorithm adaptive
				}				
			}
			
			// the case when the current input list item belongs at the very end of our
			// return list at this time
			if (!inserted) {
				sorted.add(outer.current());
			}
			
			// next input item
			outer.next();
		}
		
		// return the sorted list
		return sorted;
	}
}
