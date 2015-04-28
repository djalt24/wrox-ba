package com.wrox.algorithms.sorting;

public class SelectionsortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new SelectionsortListSorter<>(new NaturalComparator<String>());
	}
	
	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new SelectionsortListSorter<>(new NaturalComparator<Double>());
	}

}
