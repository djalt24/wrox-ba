package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.sorting.NaturalComparator;

public class IterativeBinaryListSearcherTest extends AbstractStringListSearcherTestCase {

	@Override
	protected ListSearcher<String> createSearcher() {
		return new IterativeBinaryListSearcher<>(new NaturalComparator<String>());
	}

}
