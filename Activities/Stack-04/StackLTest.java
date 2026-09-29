import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StackLTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void initStack() {
		StackL<String> s = new StackL<>();
		
		assertNotNull(s);
	}
	
	@Test
	public void emptyPop() {
		StackL<String> s = new StackL<>();
		
		assertNull(s.pop());
	}
	
	@Test
	public void pushPopSingleTest() {
		StackL<String> s = new StackL<>();
		
		String[] n = {"ONE","TWO","THREE"};
		
		s.push(n[0]);
		
		String ret = s.pop();
		
		assertEquals(n[0], ret);
		
		assertNull(s.pop());
	}
	
	@Test
	public void pushPopMultiTest() {
		StackL<String> s = new StackL<>();
		
		String[] n = {"ONE","TWO","THREE","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
		
		for(String str : n) {
			s.push(str);
		}
			
		for(int i = n.length - 1; i > -1; i--) {
			String ret = s.pop();
			
			assertEquals(n[i], ret);
		}
		
		assertNull(s.pop());
	}
	
	@Test 
	public void sizeTest() {
		StackL<String> s = new StackL<>();
		
		String[] n = {"ONE","TWO","THREE","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
		
		for(String str : n) {
			s.push(str);
		}
		
		assertEquals(n.length, s.size());
	}
}
