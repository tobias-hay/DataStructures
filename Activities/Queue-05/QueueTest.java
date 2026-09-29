import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void initQueue() {
		QueueA<String> q = new QueueA<>(10);
		
		assertNotNull(q);
	}
	
	@Test
	public void emptyDequeue() {
		QueueA<String> q = new QueueA<>(10);
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void isEmpty() {
		QueueA<String> q = new QueueA<>(10);
		assertTrue(q.isEmpty());
		
		q.enqueue("A");
		assertFalse(q.isEmpty());
		
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void isFull() {
		QueueA<String> q = new QueueA<>(10);
		
		while(!q.isFull()) {
			q.enqueue((Math.random() * 10) + "");
		}
		
		assertTrue(q.isFull());
	}
	
	@Test
	public void enqueueAndDequeueSingle() {
		QueueA<String> q = new QueueA<>(10);
		
		q.enqueue("ONE");
		
		String str = q.dequeue();
		
		assertNotNull(str);
		assertEquals(str, "ONE");
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void enqueueAndDequeueMany() {
		String[] numbers = {"ONE","TWO","THREE","FOUR","FIVE","SIX"};
		
		QueueA<String> q = new QueueA<>(10);
		
		for(String s : numbers)
			q.enqueue(s);
		
		for(int i = 0; i < numbers.length; i++) {
			String ret = q.dequeue();
			
			assertNotNull(ret);
			assertEquals(ret, numbers[i]);
		}
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void testPeek() {
		String[] numbers = {"ONE","TWO","THREE","FOUR","FIVE","SIX"};
		
		QueueA<String> q = new QueueA<>(10);
		
		for(String s : numbers)
			q.enqueue(s);
		
		for(int i = 0; i < numbers.length; i++) {
			assertEquals(q.peek(), numbers[i]);
			String ret = q.dequeue();
			
			assertNotNull(ret);
			assertEquals(ret, numbers[i]);
		}
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void testSize() {
		String[] numbers = {"ONE","TWO","THREE","FOUR","FIVE","SIX"};
		
		QueueA<String> q = new QueueA<>(10);
		
		for(String s : numbers)
			q.enqueue(s);
		
		for(int i = 0; i < numbers.length; i++) {
			assertEquals(q.size(), numbers.length - i);
			String ret = q.dequeue();
			
			assertNotNull(ret);
			assertEquals(ret, numbers[i]);
		}
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}

}
