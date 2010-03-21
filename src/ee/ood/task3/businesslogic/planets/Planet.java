package ee.ood.task3.businesslogic.planets;

import ee.ood.task3.businesslogic.geom.PointSimulationElement;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 */
public class Planet extends PointSimulationElement {

	/**
	 * 
	 */
	
	private double omega;
	
	public Planet(double x, double y, double omega) {
		super(x,y);
		this.omega = omega;
	}
	
	public double getOmega() {
		return this.omega;
	}
	
	public void tick() {
		this.centre_rotate(this.omega);
	}
	
	public String toString() {
		return "x: "+this.x()+", y: "+this.y()+", omega: "+this.omega;
	}
}
