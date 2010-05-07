/**
 * 
 */
package client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;

import common.messages.MsgObject;



/**
 * @author 
 * Apr 10, 2010
 */
public class ClientStreamListener extends Thread {

	private ObjectInputStream in;
	private ClientApplication app;
	private Color color = null;
	
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
					
					if(((MsgObject) response).getMessage() != null) {
						
						String msg = res.getMessage();
						String name = res.getName();
						String status = res.getStatus();
						String msgForClient = "";
						if (name != null) msgForClient += (name+": ");
						if (msg != null) msgForClient += (msg+" ");
						if (status != null) msgForClient += (status);
						app.statusField.setText(msgForClient);
						if(msg.equals("new game")) {
							app.buttonRock.setForeground(null);
							app.buttonPaper.setForeground(null);
							app.buttonScissors.setForeground(null);
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
								if (status.equals("1"))
									color = Color.YELLOW;
								else if (status.equals("2"))
									color = Color.RED;
								app.setNameButton.setVisible(false);
								app.setNameField.setEditable(false);
								app.gamePanel.setVisible(true);
								ClientApplication.window.pack();
							}
						}
						if (res.getLogic() != null ) {
							if(res.getLogic().isEnded()) {
								System.out.println(status.substring(0, status.length()-5));
								if (app.name.equals(status.substring(0, status.length()-5))){
									status = "You are winner!";
								} else
									status = "You are loser!";
								//app.statusField.setText(name+": "+msg+" "+status);
							}
						}
					}
					
				} 
			}
		} catch (IOException e) {
			System.out.println("listener:  Cannot connect with server ");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
		} finally {
			try {
				this.interrupt();
			} catch (Throwable e) {
				//e.printStackTrace();
			}
		}
		
	}
	
}
