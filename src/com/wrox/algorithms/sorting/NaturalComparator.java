package com.wrox.algorithms.sorting;

public class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {

	@Override
	public int compare(T left, T right) {
		return left.compareTo(right);
	}

}
