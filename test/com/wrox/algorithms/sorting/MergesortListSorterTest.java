package com.wrox.algorithms.sorting;

public class MergesortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new MergesortListSorter<String>(new NaturalComparator<String>());
	}

	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new MergesortListSorter<Double>(new NaturalComparator<Double>());
	}

}
