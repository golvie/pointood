/**
 * 
 */
package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import server.logic.Logic;

import common.messages.Message;
import common.messages.MsgObject;


public class Person extends Thread {
	
	private Socket socket;
	private BufferedReader inR;
	protected DataInputStream in;
	private ObjectOutputStream outObj;
	
	private static String[] PLAYER_NAME  = {null, "PLAYER_1", "PLAYER_2"};
	private int type;
	private ArrayList<Person> players;
	private Message messages;
	private Logic gameLogic_;
	
	/**
	 * 
	 * @param s the name of socket
	 * @param type the player type 1, 2 - player / 5 - spectator
	 * @param players the list of users ArrayList
	 * @param msg the class of messages
	 * @throws IOException
	 */
	
	Person( Socket s , int type, ArrayList<Person> players, Message msg, Logic logic ) throws IOException {
		
		this.messages = msg;
		this.socket = s;
		this.type = type;
		this.players = players;
		this.gameLogic_ = logic;
		if (type<3)
			this.setName("PLAYER_"+type);
		else
			this.setName("Spectator");
		this.in = new DataInputStream(socket.getInputStream());
		this.outObj = new ObjectOutputStream (socket.getOutputStream()); // Server sends complicated Object
		this.inR = new BufferedReader( new InputStreamReader( 
										socket.getInputStream()));
	   this.start();
	}
	
	public synchronized void run() {
		StopObject stop = StopObject.getStopObject();
		if(type<3)
			players.add(type-1, this ); // 0, 1 indexes for players
		else
			players.add( this ); // all others for spectators

		System.out.println("hello "+this.getName());

		try {
			while(true) {
					
				int waste = this.in.available();
				for(int i=0; i<waste; i++)
					in.readByte(); //clear buffer from queue - we need the last line
				
				String msg = null;
				msg = inR.readLine();
				
				if (msg != null) {
					 Server.log.info("Server get new msg from "+this.getName()+": "+msg);
					 MsgObject response = new MsgObject();
					 if (msg.equals("new game") && type != Server.SPECTATOR) {
						 response.setMessage(msg);
						 response.setName(getName());
						 gameLogic_.reset();
						 synchronized (stop) {
							 stop.reset(); 
							 stop.notifyAll(); // wake up All players
						 }
						 messages.addMessage( response );
					 } else if (msg.equals("Get all players names!")) {
						 Server.log.info(this.getName()+" would like to know all players names");
						 Server.log.info(getAllNames());
						 response.setMessage(getAllNames());
						 this.sendMessage(response);
					 } else if(msg.length()>12) { 
						 if (msg.substring(0,13).equals("setPlayerName")) {
							 
							 if (this.getName().equals("PLAYER_1")) {
								 PLAYER_NAME[1]=msg.substring(13);
								
							 }
							 if (this.getName().equals("PLAYER_2")) {
								 PLAYER_NAME[2]=msg.substring(13);
								
							 }
							 Server.log.info(this.getName()+" => "+msg.substring(13));
							 this.setName(msg.substring(13));
							 response.setName(getName());
							 response.setMessage("NameIsSetted");
							 response.setType(type);
							 messages.addMessage( response );
						 }
					 } else if (type != Server.SPECTATOR && !gameLogic_.isEnded()) {
						 //who first connected - first turn
						 if (PLAYER_NAME[2].equals(this.getName()) && gameLogic_.isNotStarted()) {
							 Server.log.info( PLAYER_NAME[1]+" must be first");
							 response.setMessage(PLAYER_NAME[1]+" must be first");
							 messages.addMessage( response );
							 continue; // next loop
						 }
						 
						 Server.log.info(this.getName()+" go " + msg);
						 gameLogic_.move(msg);
						 String status = checkStatus(gameLogic_.getGameStatus());
						 Server.log.info(status);
						 
						 response.setMessage(msg);
						 response.setName(getName());
						 if(gameLogic_.isEnded()) {
							 status += " => GAME OVER";
							 if (getName().equals(PLAYER_NAME[gameLogic_.getGameStatus()])) {
								 response.setWin(true);
							 }
						 }
						 response.setStatus(status);
						 messages.addMessage( response );
						 stop.changeState();
						 try {
								synchronized( stop ) {
									while(stop.getWho(type)) {
										Server.log.info(this.getName()+" waits... ");
										stop.wait();
										Server.log.info(this.getName()+" stops waiting");
									}
								}
							} catch (InterruptedException e) {
								Server.log.error(this +" cannot wait");
							}
					 }
				 }
				
				if (gameLogic_.isEnded()) {
					synchronized (stop) {
						 stop.reset(); 
						 stop.notifyAll(); // wake up All players - somebody win
					 }
				}
			}
		} catch(Exception e) {
			Server.log.info("server - good bye my clients");
			//e.printStackTrace();
			synchronized( stop ) { // these action need if you close client's application 
				stop.reset();		// so, it prevents errors and allows you to play without interrupting server
				stop.notifyAll();
				if(players.size()>0) {
					for (Person p : players)
						try {
							p.socket.close();
						} catch (IOException e1) {
							Server.log.error("fault in closing client by server");
							e1.printStackTrace();
						}
					gameLogic_.reset();
					players.clear();
				}
			}
		}
	}
	
	private String getAllNames(){
		String names = "Players list: ";
		for (Person p : players)
			names += p.getName()+", ";
		return names;
	}
	
	private String checkStatus(int status) {
		
		switch(status) {
			case 1: 
				return PLAYER_NAME[1]+" WINS "+gameLogic_.getGameResult(PLAYER_NAME);
			case 2:
				return PLAYER_NAME[2]+" WINS "+gameLogic_.getGameResult(PLAYER_NAME);
			case -1:
				return "TIE GAME "+gameLogic_.getGameResult(PLAYER_NAME);
			default:
				return PLAYER_NAME[3-type] + " to play";
		}
	}
/**
 * 
 * @param msg message
 */

	public void sendMessage ( MsgObject msg ) {
		try {
			outObj.writeObject( msg );
		} catch (IOException e) {
			Server.log.error("cannot send message");
			e.printStackTrace();
		}
	}
}
