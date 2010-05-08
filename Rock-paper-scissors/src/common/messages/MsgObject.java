/**
 * 
 */
package common.messages;

import java.io.Serializable;


/**
 * Class for sending complicated objects
 * @author V&N
 * @version Apr 11, 2010
 */
@SuppressWarnings("serial")
public class MsgObject implements Serializable {

	private String message;
	private String name;
	private String status;
	private boolean win;
	private int type;
	
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public boolean isWin() {
		return win;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}

}
