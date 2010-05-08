package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


import org.apache.log4j.Logger;

import server.logic.Logic;
import server.logic.LogicImpl;

import common.messages.Message;

/**
 * This server application opens a port and listens for clients to connect.
 * @author 
 * Apr 13, 2010
 */
public class Server {
	public static final int PORT = 8090;
	//static BufferedReader in;
	static Socket socket;
	private static  int PLAYER = 0;
	static final int SPECTATOR = 5;
	public static Logger log = Logger.getLogger(Server.class);
	private ArrayList<Person> players = new ArrayList<Person>();
	private Message message = new Message();
	private Logic gameLogic_ = new LogicImpl();
	
	public Server()  {
		ServerSocket server;
		try {
			server = new ServerSocket(PORT);
		
			log.info("Server started...");
			
			new Sender( players , message); // thread which sends all messages from server
			try {
				while(true) {
					log.info("server try to accept new client..");
					socket = server.accept();
					
					if(players.size()==0)
						PLAYER=0;
					if(PLAYER++ < 2)
						new Person( socket , PLAYER , players , message, gameLogic_ );
					else
						new Person( socket , SPECTATOR , players , message, gameLogic_ );
	
				}
			}
			catch(Exception e) { 
				server.close(); 
				log.info("Server closing..."); 
	
			}
		} catch (IOException e1) {
			log.error("Cannot create server now ... maybe port "+PORT+" is used.");
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server();
	}
}
