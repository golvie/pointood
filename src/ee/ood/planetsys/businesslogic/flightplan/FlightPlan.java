/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

import ee.ood.planetsys.businesslogic.geom.Point;
import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */

//Receiver class.
public class FlightPlan {

	private OperatedSpaceShip ship;
	public int paused_ticks = 0;
	
	
	public void waits(int ticks) {
		paused_ticks = ticks;
		//ship.translate(ship.getDx(), ship.getDy());
	}
	
	public void changeSpeed(double factor) {
		ship.setDx(ship.getDx()*factor);
		ship.setDy(ship.getDy()*factor);
		ship.translate(ship.getDx(), ship.getDy());
	}
	
	public void changeDirection(double angle) {
		Point p = new Point(ship.getDx(), ship.getDy());
		p.centre_rotate(angle);
		ship.setDx(p.x());
		ship.setDy(p.y());
		ship.translate(ship.getDx(), ship.getDy());
	}
	
	public void simpleMove() {
		if (paused_ticks != 0)
			paused_ticks--;
		else
			ship.translate(ship.getDx(), ship.getDy());
	}
	
}
