package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

public class CompoundComparator<T extends Comparable<T>> implements Comparator<T> {
	
	private final List<Comparator<T>> comparators;
	
	public CompoundComparator(List<Comparator<T>> compoundComp) {
		comparators = compoundComp;
	}

	@Override
	public int compare(T left, T right) {
		int rv = 0;
		for (int i = 0; i < comparators.size(); i++) {
			Comparator<T> comparator = comparators.get(i);
			rv = comparator.compare(left, right);
			if (rv != 0) {
				break;
			}
		}
		
		return rv;
	}
}
