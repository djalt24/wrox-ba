package com.wrox.algorithms.sorting;

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
		return null;
	}
}
