package com.wrox.algorithms.sorting;

public class QuicksortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new QuicksortListSorter<String>(new NaturalComparator<String>());
	}

	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new QuicksortListSorter<Double>(new NaturalComparator<Double>());
	}

}
