/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class ChangeSpeed implements Command {

	private OperatedSpaceShip ship;
	private double factor;
	
	public ChangeSpeed(OperatedSpaceShip s, double f) {
		this.ship = s;
		this.factor = f;
	}
	
	@Override
	public void execute() {
		ship.changeSpeed(factor);
	}
	
}
