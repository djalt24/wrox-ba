package com.wrox.algorithms.lists;

public class ArrayListTest extends AbstractListTestCase<String> {
	
	private static final String VALUE_A = "A";
	
	private static final String VALUE_B = "B";
	
	private static final String VALUE_C = "C";
	
	public ArrayListTest() {
		super(VALUE_A, VALUE_B, VALUE_C);
	}
	
	@Override
	public List<String> getList() {
		return new ArrayList<String>();
	}

	public void testResizeBeyondInitialCapacity() {
		List<String> list = new ArrayList<String>(1);
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertSame(3, list.size());
		assertSame(list.get(0), VALUE_A);
		assertSame(list.get(1), VALUE_B);
		assertSame(list.get(2), VALUE_C);
	}
	
	public void testDeleteFromLastEntryOfArray() {
		List<String> list = new ArrayList<>(1);
		
		list.add(VALUE_A);
		list.delete(VALUE_A);
	}
}
