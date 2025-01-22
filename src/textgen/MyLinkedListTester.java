/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		list1.add(0, 65);
		list1.add(1, 21);
		int b = list1.remove(2);
		assertEquals("Remove: check b is correct ", 42, b);
		assertEquals("Remove: check element 1 is correct ", (Integer)21, list1.get(1));
		assertEquals("Remove: check size is correct ", 2, list1.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		emptyList.add(0);
		assertEquals("Check empty list add", (Integer)0, emptyList.get(0));
		shortList.add("C");
		assertEquals("Check short list add", "C", shortList.get(2));
		longerList.add(10);
		assertEquals("Check longer list add", (Integer)10, longerList.get(10));
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Check empty list size", 0, emptyList.size());
		assertEquals("Check short list size", 2, shortList.size());
		assertEquals("Check longer list size", 10, longerList.size());
		assertEquals("Check list1 size", 3, list1.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		emptyList.add(0, 0);
		assertEquals("Check empty list add at index", (Integer)0, emptyList.get(0));
		shortList.add(1, "C");
		assertEquals("Check short list add at index", "C", shortList.get(1));
		longerList.add(5, 10);
		assertEquals("Check longer list add at index", (Integer)10, longerList.get(5));
		list1.add(1, 22);
		assertEquals("Check list1 add at index", (Integer)22, list1.get(1));
		try {
			list1.add(-1, 65);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			list1.add(4, 65);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyList.set(0, 0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.set(-1, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.set(2, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		shortList.set(0, "C");
		assertEquals("Check short list set", "C", shortList.get(0));
		longerList.set(5, 10);
		assertEquals("Check longer list set", (Integer)10, longerList.get(5));
		list1.set(1, 22);
		assertEquals("Check list1 set", (Integer)22, list1.get(1));
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
