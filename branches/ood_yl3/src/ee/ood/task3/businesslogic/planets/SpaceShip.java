/**
 * 
 */
package ee.ood.task3.businesslogic.planets;

import ee.ood.task3.businesslogic.geom.PlanetaryElementImpl;


/**
 * @author Jaroslav Judin
 * Mar 20, 2010
 */
public class SpaceShip extends PlanetaryElementImpl {

	private double dx;
	private double dy;
	
	public SpaceShip(double x, double y, double dx, double dy) {
		super(x, y);
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void tick() {
		translate(dx, dy);
	}

	
	
}
