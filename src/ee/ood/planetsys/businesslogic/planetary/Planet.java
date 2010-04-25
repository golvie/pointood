package ee.ood.planetsys.businesslogic.planetary;


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
	
	public Planet(double x, double y, double omega) {
		super(x,y);
		this.setOmega(omega);
	}
	
	
	@Override
	public void tick() {
		this.centre_rotate(this.getOmega());
	}
	
	public String toString() {
		return "x: "+this.x()+", y: "+this.y()+", omega: "+this.getOmega();
	}
}
