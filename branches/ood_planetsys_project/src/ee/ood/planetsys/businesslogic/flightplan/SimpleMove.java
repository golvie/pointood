/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

/**
 * @author Jaroslav Judin
 * Apr 25, 2010
 */
public class SimpleMove implements Command {
	
	private FlightPlan plan;
	
	public SimpleMove(FlightPlan p) {
		this.plan = p;
	}
	
	@Override
	public void execute() {
		plan.simpleMove();
	}

}
