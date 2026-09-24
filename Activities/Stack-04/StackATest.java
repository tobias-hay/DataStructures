package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackATest {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	void initStack() {
		StackA<String> s = new StackA<>();
		
		assertNotNull(s);
	}
	
	@Test
	void emptyPop() {
		StackA<String> s = new StackA<>();
		
		assertNull(s.pop());
	}
	
	@Test
	void pushPopSingleTest() {
		StackA<String> s = new StackA<>();
		
		String[] n = {"ONE","TWO","THREE"};
		
		s.push(n[0]);
		
		String ret = s.pop();
		
		assertEquals(ret, n[0]);
		
		assertNull(s.pop());
	}
	
	@Test
	void pushPopMultiTest() {
		StackA<String> s = new StackA<>();
		
		String[] n = {"ONE","TWO","THREE","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
		
		for(String str : n) {
			s.push(str);
		}
			
		for(int i = n.length - 1; i > -1; i--) {
			String ret = s.pop();
			
			assertEquals(ret, n[i]);
		}
		
		assertNull(s.pop());
	}
	
	@Test
	void sizeTest() {
		StackA<String> s = new StackA<>();
		
		String[] n = {"ONE","TWO","THREE","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
		
		for(String str : n) {
			s.push(str);
		}
		
		assertEquals(s.size(), n.length);
	}
}
