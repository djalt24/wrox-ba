package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;

public interface ListSearcher<T extends Comparable<T>> {

	public int search(List<T> list, T key);
}
