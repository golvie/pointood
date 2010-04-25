/**
 * 
 */
package ee.ood.planetsys.tests;

import ee.ood.planetsys.businesslogic.planetary.SpaceShip;
import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * Mar 22, 2010
 */
public class TestSpaceShip extends TestCase {

	/**
	 * @param name
	 */
	public TestSpaceShip(String name) {
		super(name);
	}
	
	SpaceShip ship;
	
	protected void setUp() throws Exception {
		super.setUp();
		ship = new SpaceShip(3.0, 4.0, 1.0, 1.0);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		ship = null;
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.planetary.SpaceShip#tick()}.
	 */
	public final void testTick() {
		assertNotNull(ship);
		assertEquals(ship.rho(), 5.0, 0.0001);
		assertEquals(ship.x(), 3.0, 0.0001);
		assertEquals(ship.y(), 4.0, 0.0001);
		ship.tick();
		assertEquals(ship.rho(), 6.403, 0.001);
		assertEquals(ship.x(), 4.0, 0.0001);
		assertEquals(ship.y(), 5.0, 0.0001);
	}

}
