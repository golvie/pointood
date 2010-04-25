/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

import ee.ood.planetsys.businesslogic.planetary.OperatedSpaceShip;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class Wait implements Command {

	private OperatedSpaceShip ship;
	private int ticks;
	
	public Wait(OperatedSpaceShip s, int t) {
		this.ship = s;
		this.ticks = t;
	}

	@Override
	public void execute() {
		ship.waits(ticks);
	}
		
}
