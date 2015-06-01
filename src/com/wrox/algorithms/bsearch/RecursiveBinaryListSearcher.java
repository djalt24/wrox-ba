package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

public class RecursiveBinaryListSearcher<T extends Comparable<T>> implements ListSearcher<T> {
	
	private Comparator<T> comparator;
	
	public RecursiveBinaryListSearcher(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public int search(List<T> list, T key) {
		return binarySearch(list, 0, list.size() -1, key);
	}
	
	protected int binarySearch(List<T> list, int lowerIndex, int upperIndex, T key) {
		if (lowerIndex > upperIndex) {
			return - (lowerIndex + 1);
		}
		int index = lowerIndex + (upperIndex - lowerIndex) / 2;
		int cmp = comparator.compare(key, list.get(index));
		if (cmp < 0) {
			index = binarySearch(list, lowerIndex, index - 1, key);
		} else if (cmp > 0){
			index = binarySearch(list, index + 1, upperIndex, key);
		}
		
		return index;
	}

}
