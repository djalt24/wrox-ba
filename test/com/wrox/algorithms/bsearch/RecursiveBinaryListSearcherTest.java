package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.sorting.NaturalComparator;

public class RecursiveBinaryListSearcherTest extends AbstractStringListSearcherTestCase {
	
	@Override
	protected ListSearcher<String> createSearcher() {
		return new RecursiveBinaryListSearcher<>(new NaturalComparator<String>());
	}

}
