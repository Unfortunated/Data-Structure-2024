package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import forStudent.Stand;

class StandTest {

	@Test
	void testStandConstructor() {
		// Every variable class
		Stand stand1 = new Stand("Test1", "T1", 50, 20, 4);
		assertEquals("Test1", stand1.getName());
		assertEquals("T1", stand1.getQuote());
		assertEquals(50, stand1.getStrength());
		assertEquals(20, stand1.getDefense());
		assertEquals(4, stand1.getMaxChargeTurn());
		assertEquals(0, stand1.getCurrentChargeTurn());
		// Negative Class
		Stand stand2 = new Stand("Test2", "T2", -60, -10, -4);
		assertEquals("Test2", stand2.getName());
		assertEquals("T2", stand2.getQuote());
		assertEquals(0, stand2.getStrength());
		assertEquals(0, stand2.getDefense());
		assertEquals(1, stand2.getMaxChargeTurn());
		assertEquals(0, stand2.getCurrentChargeTurn());
	}

}
