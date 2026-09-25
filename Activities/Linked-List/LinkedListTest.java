import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testInit() {
		LinkedList<String> list = new LinkedList<>();
		assertNotNull(list);	
	}
	
	@Test
	public void testAddFront() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addFront(elements.substring(i, i+1));
		}
		
	}
	
	@org.junit.Test
	public void testRemoveBack() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addFront(elements.substring(i, i+1));
		}

		System.out.println(list);
		
		for(int i = 0; i < elements.length(); i++) {
			String tmp = list.removeBack();
			
			System.out.println(elements.charAt(i));
			System.out.println(tmp.charAt(0));

			assertEquals(tmp.charAt(0), elements.charAt(i));
		}
	}
	
	@org.junit.Test
	public void testRemoveLast() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addFront(elements.substring(i, i+1));
		}
		
		for(int i = 0; i < elements.length(); i++) {
			String tmp = list.removeBack();
			
			assertEquals(tmp.charAt(0), elements.charAt(i));
		}
	}
	
	@org.junit.Test
	public void testGet() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addBack(elements.substring(i, i+1));
		}
		
		for(int i = 0; i < elements.length(); i++) {
			String tmp = list.get(i);
			
			assertEquals(tmp.charAt(0), elements.charAt(i));
		}
	}
	
	@org.junit.Test
	public void testContains() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addBack(elements.substring(i, i+1));
		}
		
		for(int i = 0; i < elements.length(); i++) {
			assertTrue(list.contains(elements.substring(i, i+1)));
		}
	}
	
	@org.junit.Test
	public void testSize() {
		String elements = "ABCDEFGHI";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < elements.length(); i++) {
			list.addBack(elements.substring(i, i+1));
		}
		
		assertEquals(list.size(), elements.length());
	}
}
