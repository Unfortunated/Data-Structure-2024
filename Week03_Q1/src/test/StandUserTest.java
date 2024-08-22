package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import forStudent.Stand;
import forStudent.StandUser;

class StandUserTest {

	@Test
	void testConstructor() {
		// Every variable class
		StandUser user1 = new StandUser("Test1", 500, "T1", 100, 50);
		assertEquals("Test1", user1.getName());
		assertEquals("T1", user1.getQuote());
		assertEquals(100, user1.getStrength());
		assertEquals(50, user1.getDefense());
		assertEquals(500, user1.getMaxHp());
		assertEquals(500, user1.getCurrentHp());
		// Negative Class
		StandUser user2 = new StandUser("Test2", -1000, "T2", -80, -40);
		assertEquals("Test2", user2.getName());
		assertEquals("T2", user2.getQuote());
		assertEquals(0, user2.getStrength());
		assertEquals(0, user2.getDefense());
		assertEquals(1, user2.getMaxHp());
		assertEquals(1, user2.getCurrentHp());
	}

	@Test
	void testTakeDamageWithoutStand_NoGuard() {
		// Test StandUser takeDamage without stand and guard function
		StandUser user1 = new StandUser("Test1", 1000, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 800, "T2", 100, 50);
		// StandUser with no defense
		assertEquals(100, user1.takeDamage(100));
		assertEquals(900, user1.getCurrentHp());
		// StandUser with defense
		assertEquals(150, user2.takeDamage(200));
		assertEquals(650, user2.getCurrentHp());

	}

	@Test
	void testTakeDamageWithoutStand_Guard() {
		// Test StandUser takeDamage without stand but with guard function
		StandUser user1 = new StandUser("Test1", 1000, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 800, "T2", 100, 50);

		// StandUser with no defense + Guard
		user1.setGuard(true);
		assertEquals(250, user1.takeDamage(250));
		assertEquals(750, user1.getCurrentHp());
		
		// StandUser with defense + Guard
		user2.setGuard(true);
		assertEquals(100, user2.takeDamage(200));
		assertEquals(700, user2.getCurrentHp());
	}

	@Test
	void testTakeDamageWithStand_NoGuard() {
		// Test StandUser takeDamage with stand but without guard function
		StandUser user1 = new StandUser("Test1", 1000, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 800, "T2", 100, 50);
		Stand stand1 = new Stand("STest1", "", 50, 20, 4);
		Stand stand2 = new Stand("STest2", "", 40, 40, 4);
		user1.setStand(stand1);
		user2.setStand(stand2);

		// StandUser with no defense
		assertEquals(100, user1.takeDamage(100));
		assertEquals(900, user1.getCurrentHp());
		// StandUser with no defense + Stand
		stand1.setIsActive(true);
		assertEquals(80, user1.takeDamage(100));
		assertEquals(820, user1.getCurrentHp());

		// StandUser with defense
		assertEquals(150, user2.takeDamage(200));
		assertEquals(650, user2.getCurrentHp());
		// StandUser with defense + Stand
		stand2.setIsActive(true);
		assertEquals(110, user2.takeDamage(200));
		assertEquals(540, user2.getCurrentHp());
	}

	@Test
	void testTakeDamageWithStand_Guard() {
		// Test StandUser takeDamage with stand and guard function
		StandUser user1 = new StandUser("Test1", 1000, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 800, "T2", 100, 50);
		Stand stand1 = new Stand("STest1", "", 50, 20, 4);
		Stand stand2 = new Stand("STest2", "", 40, 40, 4);
		user1.setStand(stand1);
		user2.setStand(stand2);

		// StandUser with no defense + guard
		user1.setGuard(true);
		assertEquals(200, user1.takeDamage(200));
		assertEquals(800, user1.getCurrentHp());
		
		// StandUser with no defense + guard + stand
		stand1.setIsActive(true);
		assertEquals(160, user1.takeDamage(200));
		assertEquals(640, user1.getCurrentHp());

		// StandUser with defense + guard
		user2.setGuard(true);
		assertEquals(100, user2.takeDamage(200));
		assertEquals(700, user2.getCurrentHp());
		// StandUser with defense + guard + stand
		stand2.setIsActive(true);
		assertEquals(20, user2.takeDamage(200));
		assertEquals(680, user2.getCurrentHp());
	}

	@Test
	void testTakeDamageWithStand_NegativeHP() {
		// Test StandUser takeDamage with stand and guard function
		StandUser user1 = new StandUser("Test1", 100, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 90, "T2", 100, 50);
		Stand stand1 = new Stand("STest1", "", 50, 20, 4);
		Stand stand2 = new Stand("STest2", "", 40, 40, 4);
		user1.setStand(stand1);
		user2.setStand(stand2);

		// StandUser with no defense + guard
		user1.setGuard(true);
		assertEquals(200, user1.takeDamage(200));
		assertEquals(0, user1.getCurrentHp());
		// StandUser with no defense + guard + stand
		stand1.setIsActive(true);
		user1.setCurrentHp(100);
		assertEquals(160, user1.takeDamage(200));
		assertEquals(0, user1.getCurrentHp());

		// StandUser with defense + guard
		user2.setGuard(true);
		assertEquals(100, user2.takeDamage(200));
		assertEquals(0, user2.getCurrentHp());
		// StandUser with defense + guard + stand
		stand2.setIsActive(true);
		user2.setCurrentHp(10);
		assertEquals(20, user2.takeDamage(200));
		assertEquals(0, user2.getCurrentHp());
	}

	@Test
	void testTakeDamageWithStand_NegativeDamage() {
		// Test StandUser takeDamage with stand and guard function
		StandUser user1 = new StandUser("Test1", 100, "T1", 80, 0);
		StandUser user2 = new StandUser("Test2", 90, "T2", 100, 50);
		Stand stand1 = new Stand("STest1", "", 50, 20, 4);
		Stand stand2 = new Stand("STest2", "", 40, 40, 4);
		user1.setStand(stand1);
		user2.setStand(stand2);

		// no guard yet
		assertEquals(10, user1.takeDamage(10));
		assertEquals(90, user1.getCurrentHp());

		// StandUser with no defense + guard
		user1.setGuard(true);
		user1.setCurrentHp(100);
		assertEquals(10, user1.takeDamage(10));
		assertEquals(90, user1.getCurrentHp());

		// StandUser with no defense + guard + stand
		stand1.setIsActive(true);
		user1.setCurrentHp(100);
		assertEquals(0, user1.takeDamage(10));
		assertEquals(100, user1.getCurrentHp());

		// StandUser with defense + guard
		user2.setGuard(true);
		assertEquals(0, user2.takeDamage(90));
		assertEquals(90, user2.getCurrentHp());

		// StandUser with defense + guard + stand
		stand2.setIsActive(true);
		user2.setCurrentHp(10);
		assertEquals(0, user2.takeDamage(170));
		assertEquals(10, user2.getCurrentHp());
	}

	@Test
	void testDoDamage_StandNotActive() {
		// Test StandUser doDamage without stand
		StandUser target = new StandUser("target", 800, "", 100, 60);
		StandUser attacker = new StandUser("attacker", 1000, "", 150, 0);
		Stand standTarget = new Stand("sTarget", "", 50, 20, 4);
		Stand standAttacker = new Stand("sAttacker", "", 40, 40, 4);
		target.setStand(standTarget);
		attacker.setStand(standAttacker);
		standTarget.setIsActive(false);
		standAttacker.setIsActive(false);

		// Attack StandUser
		assertEquals(90, attacker.doDamage(target));
		assertEquals(710, target.getCurrentHp());
		// Attack StandUser + guard
		target.setGuard(true);
		assertEquals(30, attacker.doDamage(target));
		assertEquals(680, target.getCurrentHp());
	}

	@Test
	void testDoDamage_StandActive() {
		// Test StandUser doDamage with stand
		StandUser target = new StandUser("target", 800, "", 100, 60);
		StandUser attacker = new StandUser("attacker", 1000, "", 150, 0);
		Stand standTarget = new Stand("sTarget", "", 50, 20, 4);
		Stand standAttacker = new Stand("sAttacker", "", 40, 40, 4);
		target.setStand(standTarget);
		attacker.setStand(standAttacker);
		standTarget.setIsActive(true);
		standAttacker.setIsActive(true);
		target.setGuard(false);
		// Attack StandUser with both stand activate
		assertEquals(110, attacker.doDamage(target));
		assertEquals(690, target.getCurrentHp());
		// Attack StandUser with both stand activate + guard
		target.setGuard(true);
		assertEquals(30, attacker.doDamage(target));
		assertEquals(660, target.getCurrentHp());
	}

}
