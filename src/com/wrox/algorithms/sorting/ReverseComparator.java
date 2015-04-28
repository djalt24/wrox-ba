package com.wrox.algorithms.sorting;

public class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {

	@Override
	public int compare(T left, T right) {
		return right.compareTo(left);
	}
}
