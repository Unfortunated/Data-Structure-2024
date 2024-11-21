import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNonAVLNodes {

	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	@Test
	void testNonAVLNodes_SmallTree() {
		BSTNode r = new BSTNode(8);
		BSTRecursive t = new BSTRecursive(r, 1);

		// 1 node
		int[] a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 2 nodes
		t.insert(2);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

	}

	@Test
	void testNonAVLNodes_3Nodes() {

		// 1st case
		BSTNode r = new BSTNode(8);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(1);
		t.insert(10);
		int[] a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 2nd case
		r = new BSTNode(8);
		t = new BSTRecursive(r, 1);
		t.insert(15);
		t.insert(11);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i <= 8; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(8, a[9]);

		// 3rd case
		r = new BSTNode(15);
		t = new BSTRecursive(r, 1);
		t.insert(10);
		t.insert(5);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i <= 8; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(15, a[9]);

	}

	@Test
	void testNonAVLNodes_5Nodes() {

		// 1st case
		BSTNode r = new BSTNode(5);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(9);
		t.insert(8);
		t.insert(10);
		int[] a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 2nd case
		r = new BSTNode(5);
		t = new BSTRecursive(r, 1);
		t.insert(2);
		t.insert(3);
		t.insert(10);
		t.insert(12);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 3rd case
		r = new BSTNode(10);
		t = new BSTRecursive(r, 1);
		t.insert(8);
		t.insert(12);
		t.insert(5);
		t.insert(6);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i <= 7; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(8, a[8]);
		assertEquals(10, a[9]);

		// 4th case
		r = new BSTNode(10);
		t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(6);
		t.insert(8);
		t.insert(7);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i <= 6; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(3, a[7]);
		assertEquals(6, a[8]);
		assertEquals(10, a[9]);

	}

	@Test
	void testNonAVLNodes_7Nodes() {

		// 1st case
		BSTNode r = new BSTNode(5);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(4);
		t.insert(3);
		t.insert(8);
		t.insert(10);
		t.insert(6);
		t.insert(7);
		int[] a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 2nd case
		r = new BSTNode(5);
		t = new BSTRecursive(r, 1);
		t.insert(1);
		t.insert(4);
		t.insert(3);
		t.insert(6);
		t.insert(7);
		t.insert(8);
		a = t.nonAVLNodes(t.root);
		// printArray(a);
		for (int i = 0; i <= 7; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(1, a[8]);
		assertEquals(6, a[9]);

		// 3rd case
		r = new BSTNode(10);
		t = new BSTRecursive(r, 1);
		t.insert(5);
		t.insert(1);
		t.insert(6);
		t.insert(8);
		t.insert(7);
		t.insert(15);
		a = t.nonAVLNodes(t.root);
		// printArray(a);
		for (int i = 0; i <= 6; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(5, a[7]);
		assertEquals(6, a[8]);
		assertEquals(10, a[9]);

	}

	@Test
	void testNonAVLNodes_10Nodes() {

		// 1st case
		BSTNode r = new BSTNode(5);
		BSTRecursive t = new BSTRecursive(r, 1);
		t.insert(3);
		t.insert(1);
		t.insert(2);
		t.insert(4);
		t.insert(7);
		t.insert(6);
		t.insert(9);
		t.insert(8);
		t.insert(10);
		int[] a = t.nonAVLNodes(t.root);
		for (int i = 0; i < a.length; i++) {
			assertEquals(0, a[i]);
		}

		// 2nd case
		r = new BSTNode(6);
		t = new BSTRecursive(r, 1);
		t.insert(2);
		t.insert(1);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(10);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		a = t.nonAVLNodes(t.root);
		for (int i = 0; i <=5; i++) {
			assertEquals(0, a[i]);
		}
		assertEquals(2, a[6]);
		assertEquals(3, a[7]);
		assertEquals(7, a[8]);
		assertEquals(10, a[9]);

	}

}
