/**
 * 
 */
package server;

/**
 * This class is needed for regulation who is moving now
 * @author V&N
 * @date Apr 11, 2010
 */
public class StopObject {

	private static boolean stopFirst = false;
	private static boolean stopSecond = false;
	private static StopObject instance = null;
	
	// don't allow create this object in another class
	private StopObject() { } 
	
	public static StopObject getStopObject() {
		if(instance == null)
			instance = new StopObject();
		return instance;
	}
	
	public synchronized void changeState() {
		if(!stopFirst) {
			stopFirst=true;
			stopSecond=false;
		} else {
			stopFirst=false;
			stopSecond=true;
		}
		notifyAll();
	}
	
	public synchronized boolean getWho(int i) {
		if(i==1)
			return stopFirst;
		else if(i==2)
			return stopSecond;
		else return false;
	}
	
	public synchronized void reset() {
		stopFirst = false;
		stopSecond = false;
	}
	
	public synchronized boolean isNew(){
		return !stopFirst && !stopSecond;
	}
	
}
