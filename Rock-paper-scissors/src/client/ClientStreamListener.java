/**
 * 
 */
package client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;

import common.messages.MsgObject;



/**
 * Listener for client side
 * @author V&N
 * @date Apr 10, 2010
 */
public class ClientStreamListener extends Thread {

	private ObjectInputStream in;
	private ClientApplication app;
	private Color color = null; // each player has own color
	
	public ClientStreamListener( ClientApplication app) throws IOException {
		this.app = app;
		this.in = app.in;
		this.start();
	}

	public void run() {
		
		try {
			while (true) {
				
				Object response = in.readObject();
				if(response instanceof MsgObject) {
					MsgObject res = (MsgObject) response;
					
					if (res.getMessage() != null) {
						
						String msg = res.getMessage();
						String name = res.getName();
						String status = res.getStatus();
						String msgForClient = "";
						if (name != null) msgForClient += (name+": ");
						if (msg != null) msgForClient += (msg+" ");
						if (status != null) {
							msgForClient += (status);
						
							if (status.length()>10)
								status = status.substring(status.length()-9, status.length());	
							if (status.equals("GAME OVER") && app.type < 3) {
									if (app.name.equals(name)) 
										if (res.isWin())
											msgForClient += "  You are winner!";
										else
											msgForClient += "  You are loser!";
									else
										if (!res.isWin())
											msgForClient += "  You are winner!";
										else
											msgForClient += "  You are loser!";
									//app.statusField.setText(msgForClient);
									app.newGameButton.setVisible(true);
									//ClientApplication.window.pack();
							}
						}
						
						app.statusField.setText(msgForClient); 
						
						if(msg.equals("new game")) {
							app.buttonRock.setForeground(null);
							app.buttonPaper.setForeground(null);
							app.buttonScissors.setForeground(null);
							app.newGameButton.setVisible(false);
							ClientApplication.window.pack();
						}  
						else if (msg != null && name!=null)
						if (app.name.equals(name)) { // only these player check chosen item
							if (msg.equals("Rock")) {
								app.buttonRock.setForeground(color);
								app.buttonPaper.setForeground(null);
								app.buttonScissors.setForeground(null);
							} else if (msg.equals("Paper")) {
								app.buttonRock.setForeground(null);
								app.buttonPaper.setForeground(color);
								app.buttonScissors.setForeground(null);
							} else if (msg.equals("Scissors")) {
								app.buttonRock.setForeground(null);
								app.buttonPaper.setForeground(null);
								app.buttonScissors.setForeground(color);
							} else if(msg.equals("NameIsSetted")) {
								app.type = res.getType();
								if (app.type == 1)
									color = Color.YELLOW;
								else if (app.type == 2)
									color = Color.RED;
								app.setNameButton.setVisible(false);
								app.setNameField.setEditable(false);
								app.gamePanel.setVisible(true);
								ClientApplication.window.pack();
							}
						} else if(msg.equals("isRepeatName")) {
							System.out.println("This Name is in use! Choose other name!");
							app.statusField.setText("This Name is in use! Choose other name!"); 
						}
						
					}
					
				} 
			}
		} catch (IOException e) {
			System.out.println("listener:  Cannot connect with server ");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("message receiving was unsuccessful");
		} catch (NullPointerException e) {
			System.out.println("name initializing was unsuccessful");
			e.printStackTrace();
		}
		finally {
			try {
				this.interrupt();
			} catch (Throwable e) {
				//e.printStackTrace();
			}
		}
		
	}
	
}
