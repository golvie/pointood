/**
 * 
 */
package ee.ood.planetsys.businesslogic.planetary;



/**
 * @author Jaroslav Judin
 * Mar 20, 2010
 */
public class SpaceShip extends SpaceObject {
	
	public SpaceShip(double x, double y, double dx, double dy) {
		super(x, y);
		this.setDx(dx);
		this.setDy(dy);
	}

	@Override
	public void tick() {
		translate(getDx(), getDy());
	}
	
}
