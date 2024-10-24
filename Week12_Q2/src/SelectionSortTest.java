

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
     int[] a = {7,6,5,4,3,2,1};
	
	
	@BeforeEach
	void setUp() throws Exception {
		a[0] = 5;
		a[1] = 3;
		a[2] = 7;
		a[3] = 1;
		a[4] = 6;
		a[5] = 4;
		a[6] = 2;
		
	}

	@Test
	void testSortRange1() {
		SelectionSort.selectionSort(a, 2, 2);
		assertEquals(5,a[0]);
		assertEquals(3,a[1]);
		assertEquals(7,a[2]);
		assertEquals(1,a[3]);
		assertEquals(6,a[4]);
		assertEquals(4,a[5]);
		assertEquals(2,a[6]);
		
		SelectionSort.selectionSort(a, 5, 5);
		assertEquals(5,a[0]);
		assertEquals(3,a[1]);
		assertEquals(7,a[2]);
		assertEquals(1,a[3]);
		assertEquals(6,a[4]);
		assertEquals(4,a[5]);
		assertEquals(2,a[6]);
		
	}
	
	@Test
	void testSortRange2() {
		SelectionSort.selectionSort(a, 1, 3);
		assertEquals(5,a[0]);
		assertEquals(1,a[1]);
		assertEquals(3,a[2]);
		assertEquals(7,a[3]);
		assertEquals(6,a[4]);
		assertEquals(4,a[5]);
		assertEquals(2,a[6]);
		
	}
	
	@Test
	void testSortRange3() {
		SelectionSort.selectionSort(a, 2, 5);
		assertEquals(5,a[0]);
		assertEquals(3,a[1]);
		assertEquals(1,a[2]);
		assertEquals(4,a[3]);
		assertEquals(6,a[4]);
		assertEquals(7,a[5]);
		assertEquals(2,a[6]);
		
	}
	
	@Test
	void testSortRange4() {
		SelectionSort.selectionSort(a, 0, 3);
		assertEquals(1,a[0]);
		assertEquals(3,a[1]);
		assertEquals(5,a[2]);
		assertEquals(7,a[3]);
		assertEquals(6,a[4]);
		assertEquals(4,a[5]);
		assertEquals(2,a[6]);		
	}
	
	@Test
	void testSortRange5() {
		SelectionSort.selectionSort(a, 0, 6);
		assertEquals(1,a[0]);
		assertEquals(2,a[1]);
		assertEquals(3,a[2]);
		assertEquals(4,a[3]);
		assertEquals(5,a[4]);
		assertEquals(6,a[5]);
		assertEquals(7,a[6]);		
	}
	
	
	

}
