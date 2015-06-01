package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public abstract class AbstractStringListSearcherTestCase extends AbstractListSearcherTestCase<String> {

	private static final String[] VALUES = {"B", "C", "D", "F", "H", "I", "J", "K", "L", "M", "P", "Q"};

	@Override
	protected List<String> getTestList() {
		return new ArrayList<String>(VALUES);
	}

	@Override
	protected String getNonExistentMaxValue() {
		return "Z";
	}

	@Override
	protected String getNonExistentMinValue() {
		return "A";
	}

	@Override
	protected int getArbitraryNonExistentIndex() {
		return -4;
	}

	@Override
	protected String getArbitraryNonExistentValue() {
		return "E";
	}

}
