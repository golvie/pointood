package ee.ood.planetsys.tests;

import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;
import ee.ood.planetsys.businesslogic.planets_fascade.PSController;
import junit.framework.TestCase;

public class TestOperatedSpaceShip extends TestCase {

	public TestOperatedSpaceShip(String name) {
		super(name);
	}

	OperatedSpaceShip ship;
	PSController controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = new PSController();
		controller.make_solar_system();
		controller.launchOperated(3, 2, 3);
		ship = (OperatedSpaceShip) controller.getLastSpaceObject();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		ship = null;
		controller = null;
	}

	public final void testTick() {
		assertNotNull("spaceship doesn't initialized", ship);
		assertNotNull("controller doesn't initialized", controller);
		double x = ship.x();
		double y = ship.y();
		ship.tick();
		assertEquals(x+2, ship.x(), 0.00001);
		assertEquals(y+3, ship.y(), 0.00001);
	}

	public final void testWaits() {
		double x = ship.x();
		double y = ship.y();
		controller.operatedWait(3);
		ship.tick();
		ship.tick();
		ship.tick();
		assertEquals(x, ship.x(), 0.00001);
		assertEquals(y, ship.y(), 0.00001);
		ship.tick();
		assertEquals(x+2, ship.x(), 0.00001);
		assertEquals(y+3, ship.y(), 0.00001);
	}

	public final void testChangeSpeed() {
		double x = ship.x();
		double y = ship.y();
		controller.operatedChangeSpeed(2);
		ship.tick();
		assertEquals(x+4, ship.x(), 0.00001);
		assertEquals(y+6, ship.y(), 0.00001);
	}

	public final void testChangeDirection() {
		double x = ship.x();
		double y = ship.y();
		controller.operatedChangeDirection(3.14159); // PI = 180^
		ship.tick();
		assertEquals(x-2, ship.x(), 0.00001);
		assertEquals(y-3, ship.y(), 0.00001);
		
	}

}
