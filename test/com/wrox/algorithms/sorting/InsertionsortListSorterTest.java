package com.wrox.algorithms.sorting;

public class InsertionsortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new InsertionsortListSorter<>(new NaturalComparator<String>());
	}

	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new InsertionsortListSorter<>(new NaturalComparator<Double>());
	}

}
