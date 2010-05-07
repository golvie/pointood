/**
 * 
 */
package server;

import java.util.ArrayList;

import common.messages.Message;
import common.messages.MsgObject;



/**
 * posqlaet soobshenija vsem polzovateljam
 */
public class Sender extends Thread {
	
	private ArrayList<Person> players;
	private Message message;
	
	/**
	 * 
	 * @param narod all users
	 * @param s the class of messages 
	 */

	public Sender(ArrayList<Person> players, Message s) {
		this.message = s;
		this.players = players;
		this.start();
	}
	
	/**
	 * sends unsended messages to all users
	 */
	
	public void run() {
		while( true ) {
			MsgObject response = message.getMessage();
				for( int i = 0 ; i < players.size() ; i++)
					players.get(i).sendMessage( response );
			
		}
	}
}