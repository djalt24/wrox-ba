package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class MergesortListSorter<T extends Comparable<T>> implements ListSorter<T> {
	
	private final Comparator<T> comparator;
	
	public MergesortListSorter(Comparator<T> comp) {
		comparator = comp;
	}

	@Override
	public List<T> sort(List<T> list) {
		return mergesort(list, 0, list.size() -1);
	}
	
	public List<T> mergesort(List<T> list, int startIndex, int endIndex) {
		
		// base condition: only one item, which is by definition sorted
		if (startIndex == endIndex) {
			List<T> result = new ArrayList<>();
			result.add(list.get(startIndex));
			return result;
		}
		
		int splitIndex = startIndex + (endIndex - startIndex) / 2;
		
		List<T> left  = mergesort(list, startIndex, splitIndex);
		List<T> right = mergesort(list, splitIndex + 1, endIndex);
		
		return merge(left,right);
	}
	
	private List<T> merge(List<T> left, List<T> right) {
		Iterator<T> leftIter = left.iterator();
		Iterator<T> rightIter = right.iterator();
		
		List<T> result = new ArrayList<>();
		
		leftIter.first();
		rightIter.first();
		
		while (!(leftIter.isDone() && rightIter.isDone())) {
			if (leftIter.isDone()) {
				result.add(rightIter.current());
				rightIter.next();
			} else if (rightIter.isDone()) {
				result.add(leftIter.current());
				leftIter.next();
			} else if (comparator.compare(leftIter.current(), rightIter.current()) < 0) {
				result.add(leftIter.current());
				leftIter.next();
			} else {
				result.add(rightIter.current());
				rightIter.next();
			}
		}
		
		return result;
	}
}
