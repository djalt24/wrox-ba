package com.wrox.algorithms.sorting;

public class ShellsortListSorterTest extends AbstractListSorterTest {

	@Override
	public ListSorter<String> createListSorter() {
		return new ShellsortListSorter<>(new NaturalComparator<String>());
	}

	@Override
	public ListSorter<Double> createDoubleListSorter() {
		return new ShellsortListSorter<>(new NaturalComparator<Double>());
	}

}
