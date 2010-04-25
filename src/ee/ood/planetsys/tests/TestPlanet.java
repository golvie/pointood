/**
 * 
 */
package ee.ood.planetsys.tests;

import ee.ood.planetsys.businesslogic.planetary.Planet;
import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * Mar 21, 2010
 */
public class TestPlanet extends TestCase {

	/**
	 * @param name
	 */
	public TestPlanet(String name) {
		super(name);
	}

	private Planet planet;
	
	protected void setUp() throws Exception {
		super.setUp();
		planet = new Planet(5.0, 0.0, 0.1);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		planet = null;
	}

	public void testPlanet() {
		assertNotNull("planet is initialized", planet);
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.planetary.Planet#tick()}.
	 */
	public final void testTick() {
		assertEquals(planet.rho(), 5.0, 0.0001);
		assertEquals(planet.theta(), 0.0, 0.0001);
		planet.tick();
		assertEquals(planet.rho(), 5.0, 0.0001);
		assertEquals(planet.theta(), 0.1, 0.0001);
		planet.tick();
		assertEquals(planet.rho(), 5.0, 0.0001);
		assertEquals(planet.theta(), 0.2, 0.0001);
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.geom.Point#translate(double, double)}.
	 */
	public final void testTranslate() {
		assertEquals(planet, new Planet(5.0, 0.0, 0.1));
		planet.translate(3, 4);
		assertEquals(planet, new Planet(8.0, 4.0, 0.1));
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.geom.Point#centre_rotate(double)}.
	 */
	public final void testCentre_rotate() {
		assertEquals(planet, new Planet(5.0, 0.0, 0.1));
		
		double angle = 0.8;
		double x = planet.x();
		double y = planet.y();
		double rho = Math.sqrt(x*x + y*y);
		double theta = Math.atan2(y, x);
		double x1 = rho * Math.cos(theta + angle);
		double y1 = rho * Math.sin(theta + angle);
		
		planet.centre_rotate(angle);
		
		assertEquals(planet, new Planet(x1, y1, 0.1));
	}

}
