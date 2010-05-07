/**
 * 
 */
package common.messages;

import java.util.ArrayList;



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
