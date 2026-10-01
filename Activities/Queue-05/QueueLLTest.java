import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class QueueLLTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void initQueue() {
		QueueLL<String> q = new QueueLL<>();
		
		assertNotNull(q);
	}
	
	@Test
	public void emptyDequeue() {
		QueueLL<String> q = new QueueLL<>();
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void isEmpty() {
		QueueLL<String> q = new QueueLL<>();
		assertTrue(q.isEmpty());
		
		q.enqueue("A");
		assertFalse(q.isEmpty());
		
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void enQueueLLndDequeueSingle() {
		QueueLL<String> q = new QueueLL<>();
		
		q.enqueue("ONE");
		
		String str = q.dequeue();
		
		assertNotNull(str);
		assertEquals(str, "ONE");
		
		assertNull(q.dequeue());
		assertNull(q.dequeue());
	}
	
	@Test
	public void enQueueLLndDequeueMany() {
		String[] numbers = {"ONE","TWO","THREE","FOUR","FIVE","SIX"};
		
		QueueLL<String> q = new QueueLL<>();
		
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
		
		QueueLL<String> q = new QueueLL<>();
		
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
		
		QueueLL<String> q = new QueueLL<>();
		
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
