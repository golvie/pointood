/**
 * 
 */
package server.logic;

import java.io.Serializable;

/**
 * @author 
 * Apr 12, 2010
 */
public interface Logic extends Serializable {
	
	public void move(String choice);
	
	public void reset();
	
	public int getGameStatus();
	
	public boolean isEnded();
	
	public boolean isNotStarted();
	
	public boolean roundComplited();

	/**
	 * @param name
	 * @return
	 */
	public String getGameResult(String[] name);
	
}
