/**
 * 
 */
package ee.ood.planetsys.businesslogic.planetary;

import ee.ood.planetsys.businesslogic.geom.Point;


/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 */
public abstract class SpaceObject extends Point {

	private double omega;
	private double dx;
	private double dy;
	
	public abstract void tick();
	
	protected SpaceObject(double x, double y){
		super(x,y);
	}

	public void setOmega(double omega) {
		this.omega = omega;
	}

	public double getOmega() {
		return omega;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDx() {
		return dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDy() {
		return dy;
	}
	
	
}
