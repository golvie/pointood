
import java.io.IOException;

import com.athlet.facade.Controller;

/**
 * 
 */

/**
 * @author Jaroslav Judin
 * May 25, 2010
 */
public class Main {

	/** Simple test harness.   */
	  public static void main (String[] args) throws IOException {
	   
	    Controller c = new Controller("Decathlon_input.txt");
	    c.addPoints();
	    c.sortByPoints();
	    //c.printList();
	    c.buildXML();
	  }

	
}
