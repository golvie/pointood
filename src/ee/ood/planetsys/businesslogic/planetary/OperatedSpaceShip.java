/**
 * 
 */
package ee.ood.planetsys.businesslogic.planetary;

import ee.ood.planetsys.businesslogic.flightplan.FlightPlan;
import ee.ood.planetsys.businesslogic.geom.Point;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
//Receiver class.
public class OperatedSpaceShip extends SpaceObject {

	private FlightPlan plan;
	private int paused_ticks = 0;
	
	public OperatedSpaceShip(double x, double y, double dx, double dy) {
		super(x, y);
		this.setDx(dx);
		this.setDy(dy);
		plan = new FlightPlan();
	}

	@Override
	public void tick() {
		
		if (paused_ticks != 0)
			paused_ticks--;
		else if (plan.size() == 0)
			translate(getDx(), getDy());
		else
			plan.popCommand();
		
	}
	
	public void waits(int ticks) {
		paused_ticks = ticks-1;
	}
	
	public void changeSpeed(double factor) {
		setDx(getDx()*factor);
		setDy(getDy()*factor);
		translate(getDx(), getDy());
	}
	
	public void changeDirection(double angle) {
		Point p = new Point(getDx(), getDy());
		p.centre_rotate(angle);
		setDx(p.x());
		setDy(p.y());
		translate(getDx(), getDy());
	}
	
	public FlightPlan getPlan(){
		return this.plan;
	}
}
