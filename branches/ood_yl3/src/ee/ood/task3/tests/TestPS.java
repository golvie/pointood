/**
 * 
 */
package ee.ood.task3.tests;

import ee.ood.task3.businesslogic.geom.PlanetaryElementImpl;
import ee.ood.task3.businesslogic.planets.Planet;
import ee.ood.task3.businesslogic.planets.PlanetarySystem;
import ee.ood.task3.businesslogic.planets.SpaceShip;
import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * Mar 21, 2010
 */
public class TestPS extends TestCase {

	/**
	 * @param name
	 */
	public TestPS(String name) {
		super(name);
	}
	PlanetarySystem<PlanetaryElementImpl> ps;
	protected void setUp() throws Exception {
		super.setUp();
		ps = new PlanetarySystem<PlanetaryElementImpl>();
		
		ps.append(new Planet(1.0, 1.0, 0.1));
        ps.append(new Planet(-1.0, 1.0, 0.2));
        ps.append(new Planet(1.2, 3.4, Math.PI/10));
        
        ps.append(new SpaceShip(5, 5, 2, 3));
        ps.append(new SpaceShip(8, 6, 1, 4));
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link ee.ood.task3.businesslogic.planets.PlanetarySystem#PlanetarySystem()}.
	 */
	public final void testPlanetarySystem() {
		assertNotNull(ps);
	}

	/**
	 * Test method for {@link ee.ood.task3.businesslogic.planets.PlanetarySystem#tick()}.
	 */
	public final void testTick() {
		ps.tick();
		assertEquals(ps.get(0).theta(), Math.PI/4 + 0.1, 0.001);
		assertEquals(ps.get(1).theta(), 3*Math.PI/4 + 0.2, 0.001);
		assertEquals(ps.get(3).x(), 7, 0.001);
		assertEquals(ps.get(3).y(), 8, 0.001);
		for(int i=0; i<19; i++)
			ps.tick();
		assertEquals(ps.get(2).x(), 1.2, 0.001);
		assertEquals(ps.get(2).y(), 3.4, 0.001);
	}

}
