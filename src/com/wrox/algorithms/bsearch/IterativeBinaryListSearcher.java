package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

public class IterativeBinaryListSearcher<T extends Comparable<T>> implements ListSearcher<T> {
	
	private final Comparator<T> comparator;
	
	public IterativeBinaryListSearcher(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public int search(List<T> list, T key) {
		int lowerIndex = 0;
		int upperIndex = list.size() - 1;
		while (lowerIndex <= upperIndex) {
			int index = lowerIndex + (upperIndex - lowerIndex) /2;
			int cmp = comparator.compare(key, list.get(index));
			if (cmp == 0) {
				return index;
			} else if (cmp < 0) {
				upperIndex = index - 1;
			} else if (cmp > 0) {
				lowerIndex = index + 1;
			}
		}
		
		return - (lowerIndex + 1);
	}

}
