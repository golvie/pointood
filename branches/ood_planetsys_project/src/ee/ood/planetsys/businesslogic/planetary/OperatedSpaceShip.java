/**
 * 
 */
package ee.ood.planetsys.businesslogic.planetary;

import ee.ood.planetsys.businesslogic.flightplan.ChangeDirection;
import ee.ood.planetsys.businesslogic.flightplan.ChangeSpeed;
import ee.ood.planetsys.businesslogic.flightplan.FlightPlan;
import ee.ood.planetsys.businesslogic.flightplan.Invoker;
import ee.ood.planetsys.businesslogic.flightplan.SimpleMove;
import ee.ood.planetsys.businesslogic.flightplan.Wait;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class OperatedSpaceShip extends SpaceObject {

	private FlightPlan plan;
	private Invoker invoker;
	
	public OperatedSpaceShip(double x, double y, double dx, double dy) {
		super(x, y);
		this.plan = new FlightPlan(); 
		this.invoker = new Invoker();
		this.setDx(dx);
		this.setDy(dy);
	}

	
	@Override
	public void tick() {
		if (invoker.size() == 0)
			invoker.addCommand( new SimpleMove(plan));
		invoker.popCommand();
	}
	
	public void changeDirection(double angle) {
		invoker.addCommand( new ChangeDirection(plan, angle));
	}
	
	public void changeSpeed(double factor) {
		invoker.addCommand( new ChangeSpeed(plan, factor));
	}
	
	public void waitTicks(int ticks) {
		invoker.addCommand( new Wait(plan, ticks));
	}
	
}
