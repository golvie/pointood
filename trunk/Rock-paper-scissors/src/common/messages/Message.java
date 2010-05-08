/**
 * 
 */
package common.messages;

import java.util.ArrayList;

/**
 * Class which saves messages and after sending removes them
 * @author V&N
 * @version May 8, 2010
 */

public class Message {

	private ArrayList<MsgObject> messages = new ArrayList<MsgObject>();
	
	public synchronized void addMessage( MsgObject msg ) { 
		messages.add( msg );
		notifyAll(); 					
	}
	
	public synchronized MsgObject getMessage() {  
		try {
			while( messages.isEmpty() )
				wait();			
		} catch( InterruptedException e ) { }
	
		MsgObject s = (MsgObject) messages.get(0);
		messages.remove(0);
		return s;
	}
	
}
