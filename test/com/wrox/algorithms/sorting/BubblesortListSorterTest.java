package com.wrox.algorithms.sorting;

public class BubblesortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new BubblesortListSorter<>(new NaturalComparator<String>());
	}

	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new BubblesortListSorter<>(new NaturalComparator<Double>());
	}
}
