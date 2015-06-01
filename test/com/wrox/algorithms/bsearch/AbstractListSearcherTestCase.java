package com.wrox.algorithms.bsearch;

import junit.framework.TestCase;

import com.wrox.algorithms.lists.List;

public abstract class AbstractListSearcherTestCase<T extends Comparable<T>> extends TestCase {

	private ListSearcher<T> searcher;
	
	private List<T> list;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		searcher = createSearcher();
		list = getTestList();
		
	}
	
	protected abstract List<T> getTestList();
	
	protected abstract ListSearcher<T> createSearcher();
	
	protected abstract T getNonExistentMaxValue();
	
	protected abstract T getNonExistentMinValue();
	
	protected abstract int getArbitraryNonExistentIndex();
	
	protected abstract T getArbitraryNonExistentValue();
	
	public void testSearchAllValues() {
		for (int i = 0; i < list.size(); i++) {
			assertEquals(i, searcher.search(list, list.get(i)));
		}
	}
	
	public void testSearchNonExistentMax() {
		assertEquals(-(list.size() + 1), searcher.search(list, getNonExistentMaxValue()));
	}
	
	public void testSearchNonExistentMin() {
		assertEquals(-1, searcher.search(list, getNonExistentMinValue()));
	}
	
	public void testSearchArbitraryNonExistent() {
		assertEquals(getArbitraryNonExistentIndex(), searcher.search(list, getArbitraryNonExistentValue()));
	}
}
