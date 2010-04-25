/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class ChangeSpeed implements Command {

	private FlightPlan plan;
	private double factor;
	
	public ChangeSpeed(FlightPlan p, double f) {
		this.plan = p;
		this.factor = f;
	}
	
	@Override
	public void execute() {
		plan.changeSpeed(factor);
	}
	
}
