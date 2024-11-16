import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHeap {
	Heap h;

	@BeforeEach
	void setUp() throws Exception {
		h = new Heap();
	}

	@Test
	void testAddSimple() {
		h.add(1);
		h.add(9);
		h.add(8);
		assertEquals(3,h.size);
		assertEquals(1,h.mData[0]);
		assertEquals(8,h.mData[1]);
		assertEquals(9,h.mData[2]);
		
	}
	
	@Test
	void testAdd2() {
		h.add(1);
		h.add(9);
		h.add(8);
		
		h.add(7);
		assertEquals(4,h.size);
		assertEquals(1,h.mData[0]);
		assertEquals(7,h.mData[1]);
		assertEquals(8,h.mData[2]);
		assertEquals(9,h.mData[3]);
		
	}
	
	@Test
	void testAdd3() {
		h.add(1);
		h.add(9);
		h.add(8);
		h.add(7);
		
		h.add(10);
		assertEquals(5,h.size);
		assertEquals(1,h.mData[0]);
		assertEquals(7,h.mData[1]);
		assertEquals(8,h.mData[2]);
		assertEquals(9,h.mData[3]);
		assertEquals(10,h.mData[4]);
		
		h.add(0);
		assertEquals(6,h.size);
		assertEquals(0,h.mData[0]);
		assertEquals(7,h.mData[1]);
		assertEquals(1,h.mData[2]);
		assertEquals(9,h.mData[3]);
		assertEquals(8,h.mData[4]);
		assertEquals(10,h.mData[5]);
		
	}
	
	@Test
	void testAdd4() {
		h.add(1);
		h.add(9);
		h.add(8);
		h.add(7);
		h.add(10);
		h.add(0);
		
		h.add(-5);
		assertEquals(7,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(7,h.mData[1]);
		assertEquals(0,h.mData[2]);
		assertEquals(9,h.mData[3]);
		assertEquals(8,h.mData[4]);
		assertEquals(1,h.mData[5]);
		assertEquals(10,h.mData[6]);
		
	}
	
	@Test
	void testAdd5() {
		h.add(1);
		h.add(9);
		h.add(8);
		h.add(7);
		h.add(10);
		h.add(0);
		h.add(-5);
		
		h.add(15);
		assertEquals(8,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(7,h.mData[1]);
		assertEquals(0,h.mData[2]);
		assertEquals(9,h.mData[3]);
		assertEquals(8,h.mData[4]);
		assertEquals(1,h.mData[5]);
		assertEquals(10,h.mData[6]);
		assertEquals(15,h.mData[7]);
		
		h.add(-1);
		assertEquals(9,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(-1,h.mData[1]);
		assertEquals(0,h.mData[2]);
		assertEquals(7,h.mData[3]);
		assertEquals(8,h.mData[4]);
		assertEquals(1,h.mData[5]);
		assertEquals(10,h.mData[6]);
		assertEquals(9,h.mData[7]);
		assertEquals(15,h.mData[8]);
		
		h.add(11);
		assertEquals(10,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(-1,h.mData[1]);
		assertEquals(0,h.mData[2]);
		assertEquals(7,h.mData[3]);
		assertEquals(8,h.mData[4]);
		assertEquals(1,h.mData[5]);
		assertEquals(10,h.mData[6]);
		assertEquals(9,h.mData[7]);
		assertEquals(11,h.mData[8]);
		assertEquals(15,h.mData[9]);
		
		h.add(2);
		assertEquals(11,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(-1,h.mData[1]);
		assertEquals(0,h.mData[2]);
		assertEquals(7,h.mData[3]);
		assertEquals(2,h.mData[4]);
		assertEquals(1,h.mData[5]);
		assertEquals(10,h.mData[6]);
		assertEquals(9,h.mData[7]);
		assertEquals(11,h.mData[8]);
		assertEquals(8,h.mData[9]);
		assertEquals(15,h.mData[10]);
		
		h.add(-2);
		assertEquals(12,h.size);
		assertEquals(-5,h.mData[0]);
		assertEquals(-1,h.mData[1]);
		assertEquals(-2,h.mData[2]);
		assertEquals(7,h.mData[3]);
		assertEquals(1,h.mData[4]);
		assertEquals(0,h.mData[5]);
		assertEquals(10,h.mData[6]);
		assertEquals(9,h.mData[7]);
		assertEquals(11,h.mData[8]);
		assertEquals(8,h.mData[9]);
		assertEquals(2,h.mData[10]);
		assertEquals(15,h.mData[11]);
		
	}
	
	

}
