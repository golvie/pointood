/**
 * 
 */
package ee.ood.planetsys.businesslogic.flightplan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaroslav Judin
 * Apr 24, 2010
 */

//Invoker class.
public class FlightPlan {

	List<Command> commands = new ArrayList<Command>();
	
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	public void popCommand() {
		if (commands.size() > 0) {
			commands.get(0).execute();
			commands.remove(0);
		}
	}
	
	public int size() {
		return commands.size();
	}
	
}
