import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSort {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSort1() {
		int[] a = {1,3,1,1,3,2,2,4,6,8,5,2,6,3};
		int[] ans = Sort.sortFrequency(a);
		assertEquals(7,ans.length);
		assertEquals(1,ans[0]);
		assertEquals(2,ans[1]);
		assertEquals(3,ans[2]);
		assertEquals(6,ans[3]);
		assertEquals(4,ans[4]);
		assertEquals(5,ans[5]);
		assertEquals(8,ans[6]);
		
	}
	
	@Test
	void testSort2() {
		int[] a = {6,7,6,4,3,1,2,3,1,3,1,3,2,3,5};
		int[] ans = Sort.sortFrequency(a);
		assertEquals(7,ans.length);
		assertEquals(3,ans[0]);
		assertEquals(1,ans[1]);
		assertEquals(2,ans[2]);
		assertEquals(6,ans[3]);
		assertEquals(4,ans[4]);
		assertEquals(5,ans[5]);
		assertEquals(7,ans[6]);
		
	}
	
	@Test
	void testSort3() {
		int[] a = {10,5,10,5,10};
		int[] ans = Sort.sortFrequency(a);
		assertEquals(2,ans.length);
		assertEquals(10,ans[0]);
		assertEquals(5,ans[1]);
	}
	
	@Test
	void testSort4() {
		int[] a = {10,5,10,5};
		int[] ans = Sort.sortFrequency(a);
		assertEquals(2,ans.length);
		assertEquals(5,ans[0]);
		assertEquals(10,ans[1]);
	}
	
	@Test
	void testSort5() {
		int[] a = {9,4,8,6,8,6};
		int[] ans = Sort.sortFrequency(a);
		assertEquals(4,ans.length);
		assertEquals(6,ans[0]);
		assertEquals(8,ans[1]);
		assertEquals(4,ans[2]);
		assertEquals(9,ans[3]);
		
	}
	
	
	
	
	
	
	
	

}
