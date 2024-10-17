import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPointsLinkedList2 {

	@Test
	void testPointValueExist_NoCross() throws Exception {
		PointsLinkedList2 list = new PointsLinkedList2();
		PointListIterator itr = new PointListIterator(list.header); 
		
		Point p = new Point(3,6,9);
		list.insert(new Point(27,2,4),itr);
		list.insert(new Point(8,2,4),itr);
		assertFalse(list.pointValueExist(p));
		
		list.insert(new Point(3,6,9),itr);
		assertFalse(list.pointValueExist(p));
	}
	
	@Test
	void testPointValueExist_Cross() throws Exception {
		PointsLinkedList2 list = new PointsLinkedList2();
		PointListIterator itr = new PointListIterator(list.header); 
		
		Point p = new Point(9,2,4);
		list.insert(new Point(9,3,4),itr);
		list.insert(new Point(12,2,4),itr);
		assertTrue(list.pointValueExist(p));
		
		list.insert(new Point(9,2,5),itr);
		list.insert(new Point(12,2,4),itr);
		assertTrue(list.pointValueExist(p));
		
		list.insert(new Point(9,3,5),itr);
		list.insert(new Point(12,2,4),itr);
		assertTrue(list.pointValueExist(p));
		list.insert(new Point(9,2,4),itr);
		assertTrue(list.pointValueExist(p));

	}

}
