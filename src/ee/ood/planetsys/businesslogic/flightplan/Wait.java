/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */
public class Wait implements Command {

	private FlightPlan plan;
	private int ticks;
	
	public Wait(FlightPlan p, int t) {
		this.plan = p;
		this.ticks = t;
	}

	@Override
	public void execute() {
		plan.waits(ticks);
	}
		
}
