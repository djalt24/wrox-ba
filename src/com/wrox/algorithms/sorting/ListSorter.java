package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

public interface ListSorter<T extends Comparable<T>> {

	List<T> sort(List<T> list);
}
