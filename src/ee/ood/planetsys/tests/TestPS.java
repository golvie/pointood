/**
 * 
 */
package ee.ood.planetsys.tests;

import ee.ood.planetsys.businesslogic.planetary.Planet;
import ee.ood.planetsys.businesslogic.planetary.PlanetarySystem;
import ee.ood.planetsys.businesslogic.planetary.SpaceObject;
import ee.ood.planetsys.businesslogic.planetary.SpaceShip;
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
	PlanetarySystem<SpaceObject> ps;
	protected void setUp() throws Exception {
		super.setUp();
		ps = new PlanetarySystem<SpaceObject>();
		
		ps.add(new Planet(1.0, 1.0, 0.1));
        ps.add(new Planet(-1.0, 1.0, 0.2));
        ps.add(new Planet(1.2, 3.4, Math.PI/10));
        
        ps.add(new SpaceShip(5, 5, 2, 3));
        ps.add(new SpaceShip(10, 0, 0.1, 0.1));
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.planetary.PlanetarySystem#PlanetarySystem()}.
	 */
	public final void testPlanetarySystem() {
		assertNotNull(ps);
	}

	/**
	 * Test method for {@link ee.ood.planetsys.businesslogic.planetary.PlanetarySystem#tick()}.
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
