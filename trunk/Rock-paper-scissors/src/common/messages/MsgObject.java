/**
 * 
 */
package common.messages;

import java.io.Serializable;

import common.logic.Logic;

/**
 * @author 
 * Apr 11, 2010
 */
@SuppressWarnings("serial")
public class MsgObject implements Serializable {

	private String message;
	private String name;
	private String status;
	private Logic logic;
	
	/**
	 * @return the logic
	 */
	public Logic getLogic() {
		return logic;
	}
	/**
	 * @param logic the logic to set
	 */
	public void setLogic(Logic logic) {
		this.logic = logic;
	}
	
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

}
