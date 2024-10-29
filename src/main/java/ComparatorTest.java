import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComparatorTest 
{

	@Test
	void test()
	{
		Customer a = new Customer(10, 0, 1);
		Customer b = new Customer(0, 10, 0);
		Customer c = new Customer(10, 0, 0);
		Customer d = new Customer(10, 0, 1);
		Customer e = new Customer(11, 0, 1);
		Customer f = new Customer(5, 0, 1);
		
		Customer.WorthComparator a1 = new Customer.WorthComparator();
		Customer.LoyaltyComparator b1 = new Customer.LoyaltyComparator();
		Customer.WorthPoliteComparator c1 = new Customer.WorthPoliteComparator();
		
		assertTrue(a1.compare(a, b) > 0);
		assertTrue(a1.compare(b, a) < 0);
		assertTrue(a1.compare(a, c) == 0);
		assertTrue(b1.compare(b, a) > 0);
		assertTrue(b1.compare(a, b) < 0);
		assertTrue(c1.compare(a, b) > 0);
		assertTrue(c1.compare(b, a) < 0);
		assertTrue(c1.compare(a, c) > 0);
		assertTrue(c1.compare(c, a) < 0);
		assertTrue(c1.compare(a, d) == 0);
		/*
		assertEquals(10, a1.compare(a, b));
		assertEquals(-10, a1.compare(b,  a));
		assertEquals(0, a1.compare(a,  c));
		assertEquals(10, b1.compare(b,  a));
		assertEquals(-10, b1.compare(a,  b));
		assertEquals(10, c1.compare(a,  b));
		assertEquals(-10, c1.compare(b, a));
		assertEquals(1, c1.compare(a, c));
		assertEquals(-1, c1.compare(c, a));
		assertEquals(0, c1.compare(a, d));
		*/
		PriorityQueue<Customer> p1 = new PriorityQueue<Customer>(a1);
		assertThrows(QueueUnderFlowException.class, () -> p1.pop());
		p1.push(a); //10	a
		p1.push(b); //10, 0		 a, b
		p1.push(e); //11, 10, 0		e, a, b
		p1.push(f); //11, 10, 5, 0		e, a, f, b
		assertEquals(e, p1.pop());
		assertEquals(a, p1.pop());
		assertEquals(f, p1.pop());
		assertEquals(b, p1.pop());
		assertThrows(QueueUnderFlowException.class, () -> p1.pop());
	}

}
