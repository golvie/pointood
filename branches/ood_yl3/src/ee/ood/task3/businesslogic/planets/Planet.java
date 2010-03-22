package ee.ood.task3.businesslogic.planets;


/**
 * 
 */

/**
 * @author Jaroslav Judin
 * Mar 18, 2010
 */
public class Planet extends SpaceObject {

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
	
	@Override
	public void tick() {
		this.centre_rotate(this.omega);
	}
	
	public String toString() {
		return "x: "+this.x()+", y: "+this.y()+", omega: "+this.omega;
	}
}
