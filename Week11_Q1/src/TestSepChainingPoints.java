import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSepChainingPoints {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_NoCross() throws Exception {
		SepChainingPoints2 sep = new SepChainingPoints2();
		sep.add(new Point(2, 3, 1));
		sep.add(new Point(3, 4, 2));
		sep.add(new Point(4, 1, 3));

		assertFalse(sep.isCrossRoad(new Point(1, 2, 4)));
		sep.add(new Point(1, 2, 4));
		assertFalse(sep.isCrossRoad(new Point(1, 2, 4)));

	}

	@Test
	void test_Cross1() throws Exception {
		SepChainingPoints2 sep = new SepChainingPoints2();
		Point p = new Point(1, 2, 4);
		sep.add(new Point(1, 3, 4));
		sep.add(new Point(3, 4, 2));
		assertTrue(sep.isCrossRoad(p));

		sep = new SepChainingPoints2();
		sep.add(new Point(1, 2, 5));
		sep.add(new Point(3, 4, 2));
		assertTrue(sep.isCrossRoad(p));

		sep = new SepChainingPoints2();
		sep.add(new Point(1, 3, 5));
		sep.add(new Point(3, 4, 2));
		assertTrue(sep.isCrossRoad(p));
		sep.add(new Point(1, 2, 4));
		assertTrue(sep.isCrossRoad(p));

	}

	@Test
	void test_Cross2() throws Exception {
		SepChainingPoints2 sep = new SepChainingPoints2();
		Point p = new Point(1,2,4);

		sep.add(new Point(1,2,4));
		sep.add(new Point(2,4,1));
		sep.add(new Point(4,5,2));
		sep.add(new Point(5,3,4));
		sep.add(new Point(3,4,5));
		sep.add(new Point(4,1,3));
		assertFalse(sep.isCrossRoad(p));
		assertTrue(sep.isCrossRoad(new Point(4,5,2)));
		assertTrue(sep.isCrossRoad(new Point(4,1,3)));
	}

}
