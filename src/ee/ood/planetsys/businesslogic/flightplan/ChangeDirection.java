/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class ChangeDirection implements Command {

	private OperatedSpaceShip ship;
	private double angle;
	
	public ChangeDirection(OperatedSpaceShip s, double a) {
		this.ship = s;
		this.angle = a;
	}
	
	@Override
	public void execute() {
		ship.changeDirection(angle);
	}

}
