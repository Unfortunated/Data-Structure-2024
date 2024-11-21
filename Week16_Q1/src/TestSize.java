import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSize { //5 marks total

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSizeZeroAndOne() { // 1 mark
		BSTRecursive t = new BSTRecursive(null, 0);
		assertEquals(0, t.size(t.root));
		
		t.root = t.insert(3);
		assertEquals(1, t.size(t.root));
	}
	
	@Test
	void testSizeTwoAndThree() { // 1 mark
		BSTRecursive t = new BSTRecursive(null, 0);
		t.root = t.insert(3);
		t.root = t.insert(1);
		assertEquals(2, t.size(t.root));
		assertEquals(1, t.size(t.root.left));
		
		t = new BSTRecursive(null, 0);
		t.root = t.insert(3);
		t.root = t.insert(5);
		assertEquals(2, t.size(t.root));
		assertEquals(1, t.size(t.root.right));
		
		
		t = new BSTRecursive(null, 0);
		t.root = t.insert(3);
		t.root = t.insert(1);
		t.root = t.insert(5);
		assertEquals(3, t.size(t.root));
		assertEquals(1, t.size(t.root.right));
		assertEquals(1, t.size(t.root.left));
				
	}
	
	@Test
	void testSizeFour() { // 1 mark
		BSTRecursive t = new BSTRecursive(null, 0);
		t.root = t.insert(5);
		t.root = t.insert(8);
		t.root = t.insert(2);
		t.root = t.insert(1);
		assertEquals(4, t.size(t.root));
		assertEquals(1, t.size(t.root.right));
		assertEquals(2, t.size(t.root.left));
		
		t = new BSTRecursive(null, 0);
		t.root = t.insert(10);
		t.root = t.insert(2);
		t.root = t.insert(5);
		t.root = t.insert(4);
		assertEquals(4, t.size(t.root));
		assertEquals(3, t.size(t.root.left));
		assertEquals(2, t.size(t.root.left.right));
		
		
	}
	
	@Test
	void testSizeFive() { // 1 mark
		BSTRecursive t = new BSTRecursive(null, 0);
		t.root = t.insert(10);
		t.root = t.insert(3);
		t.root = t.insert(6);
		t.root = t.insert(4);
		t.root = t.insert(8);
		assertEquals(5, t.size(t.root));
		assertEquals(4, t.size(t.root.left));
		assertEquals(0, t.size(t.root.right));
		assertEquals(3, t.size(t.root.left.right));
		
		
		t = new BSTRecursive(null, 0);
		t.root = t.insert(4);
		t.root = t.insert(8);
		t.root = t.insert(10);
		t.root = t.insert(6);
		t.root = t.insert(9);
		assertEquals(5, t.size(t.root));
		assertEquals(4, t.size(t.root.right));
		assertEquals(2, t.size(t.root.right.right));
		
	}
	
	@Test
	void testSizeGeneric() { // 1 mark
		BSTRecursive t = new BSTRecursive(null, 0);
		t.root = t.insert(8);
		t.root = t.insert(4);
		t.root = t.insert(14);
		t.root = t.insert(2);
		t.root = t.insert(1);
		t.root = t.insert(3);
		t.root = t.insert(6);
		t.root = t.insert(5);
		t.root = t.insert(7);
		t.root = t.insert(9);
		t.root = t.insert(20);
		t.root = t.insert(13);
		t.root = t.insert(11);
		t.root = t.insert(10);
		t.root = t.insert(12);
		assertEquals(15, t.size(t.root));
		assertEquals(7, t.size(t.root.left));
		assertEquals(7, t.size(t.root.right));
		assertEquals(3, t.size(t.root.left.right));
		assertEquals(5, t.size(t.root.right.left));
	
	}
	
}
