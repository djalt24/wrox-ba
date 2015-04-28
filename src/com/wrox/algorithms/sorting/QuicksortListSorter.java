package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * An implementation of the Quicksort algorithm
 * @author David Nelson
 * 
 * @param <T> the <code>Comparable</code> being sorted
 */
public class QuicksortListSorter<T extends Comparable<T>> implements ListSorter<T> {
	
	/** separates the concern for how to sort T **/
	Comparator<T> comparator;
	
	/**
	 * Constructor
	 * @param comp the comparator to use for sorting T
	 */
	public QuicksortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		quicksort(list, 0, list.size() - 1);
		return list;
	}
	
	/**
	 * The delegate sorting method. Divides and conquers the task
	 * of sorting the entire list into smaller and smaller lists,
	 * with each recursion ultimately finding the final resting
	 * spot of one item in the list
	 * @param list the list being sorted
	 * @param startIndex the start index for the sublist
	 * @param endIndex the end index for the sublist
	 */
	private void quicksort(List<T> list, int startIndex, int endIndex) {
		
		// this is mainly protection to simplify recursion logic
		if (startIndex < 0 || endIndex >= list.size()) {
			return;
		}
		
		// this is the main recursion exit condition
		// indicates sublist is size of 1, already sorted
		if (endIndex <= startIndex) {
			return;
		}
		
		// use the item at endIndex as partition
		T partitionValue = list.get(endIndex);
		
		// partition the list into the two halves, returning
		// the new partition point (the two pointers move toward eachother)
		int newPartitionIndex = partition(list, partitionValue, startIndex, endIndex - 1);
		
		// we want to swap the item at newPartitionIndex with the partitionValue.
		// we haven't determined where the value at newPartitionIndex belongs relative
		// to partitionValue; we can be assured, however, that the item to the right of the
		// partition index indeed belongs AFTER the partitionValue (that's how we got here)
		// so, if the value at newPartitionIndex belongs BEFORE partitionValue, increment
		// newPartitionIndex and swap; otherwise just swap
		// looking for when left is before right, or <0
		if (comparator.compare(list.get(newPartitionIndex), partitionValue) < 0) {
			// move one over, guaranteed to belong AFTER partionValue, so we can swap
			newPartitionIndex++;
		}
		
		// swap the newPartionIndex and endIndex values
		// the value at endIndex will now be in it's final
		// sorted place
		swap(list, newPartitionIndex, endIndex);
		
		// the newPartion has created two sublists at this point
		// quicksort them both
		
		// left sublist
		quicksort(list, startIndex, newPartitionIndex - 1);
		
		// right sublist
		quicksort(list, newPartitionIndex + 1, endIndex);	
	}
	
	/**
	 * Partitions the values in a list between startIndex and endIndex
	 * such that the "left partition" of the list are values belong 
	 * before the value, and the "right partition" of the list are
	 * values belonging after the value. Thus, the final position of
	 * value is where the seam between the two partitions meet.
	 * @param list the list being sorted
	 * @param value the value for which the final position will be found
	 * @param startIndex the start index within the list to work from
	 * @param endIndex the end index within the list to work from
	 * @return the final position in the list for the input value
	 */
	private int partition(List<T> list, T value, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		
		// until left == right
		while (left < right) {
			// if left is already correct, kick out and try the next 
			// left
			if (comparator.compare(list.get(left), value) < 0) {
				left++;
				continue;
			}
			
			// if right is already correct, kick out and try the next
			// right
			if (comparator.compare(list.get(right), value) >= 0) {
				right--;
				continue;
			}
			
			// both left and right are one the wrong sides of value
			// swap them
			swap(list, left, right);
			
			// move left forward and repeat
			left++;	
		}
		
		// technically left == right here, we could return either
		return left;
	}
	
	/**
	 * Utility method to swap two values in the list
	 * @param list the list
	 * @param leftIndex the left item to swap with the right
	 * @param rightIndex the right item to swap with the left
	 */
	private void swap(List<T> list, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) return;
		
		T left = list.get(leftIndex);
		list.set(leftIndex, list.get(rightIndex));
		list.set(rightIndex,  left);
	}
}
