/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class ChangeDirection implements Command {

	private FlightPlan plan;
	private double angle;
	
	public ChangeDirection(FlightPlan p, double a) {
		this.plan = p;
		this.angle = a;
	}
	
	@Override
	public void execute() {
		plan.changeDirection(angle);
	}

}
