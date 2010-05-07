package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.Server;


//import server.Server;
/**
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class ClientApplication extends JPanel {

	private Socket s;
	private PrintWriter outW;
	protected ObjectInputStream in;
	protected JButton buttonRock;
	protected JButton buttonPaper;
	protected JButton buttonScissors;
	protected JButton infoButton;
	protected JButton setNameButton;
	protected JButton newGameButton;

	protected static JFrame window;
	protected JPanel gamePanel = new JPanel();
	protected JPanel controlPanel = new JPanel();
	protected JTextField    statusField = new JTextField();
	protected JTextField    setNameField = new JTextField(8);
	protected String name;
	
	public static void main(String[] args) {
		window = new JFrame("Rock Paper Scissors");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new ClientApplication());//window
        window.pack();  // finalize layout
        window.setVisible(true);
    }
	
	/** 
	 * Create a socket to communicate with a server on port 8080 of the
	 * host that the applet's code is on.  Create streams to use with
	 * the socket.  Then create a TextField for user input and a TextArea
	 * for server output.  Finally, create a thread to wait for and
	 * display server output.
	 */
	public ClientApplication() {
		try {
			s = new Socket("localhost", Server.PORT);
			in = new ObjectInputStream(s.getInputStream());
			outW =
			    new PrintWriter( new BufferedWriter( 
				 	new OutputStreamWriter(	s.getOutputStream() )), true); // client sends simple String
			new ClientStreamListener(this);
		} catch (UnknownHostException e1) {
			System.out.println("UnknownHostException");
		} catch (IOException e1) {
			System.out.println("Cannot connect with server");
		}
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, gamePanel);
		this.add(BorderLayout.NORTH, controlPanel);
		this.add(BorderLayout.SOUTH, statusField);
		this.InitButtons();
		controlPanel.setBackground(Color.BLUE);
		controlPanel.add(newGameButton);
		controlPanel.add(infoButton);
		controlPanel.add(setNameButton);
		controlPanel.add(setNameField);
		gamePanel.setSize(250, 50);
		gamePanel.setLayout(new GridLayout(1,3,3,3));
		gamePanel.add(buttonRock);
		gamePanel.add(buttonPaper);
		gamePanel.add(buttonScissors);
		
		gamePanel.setVisible(false);
	}

	public void makePanels() {
		if (name != null)
			controlPanel.remove(setNameButton);
		
	}
	
	private void InitButtons() {
		ImageIcon rock = createImageIcon("images/rock.jpg");
		ImageIcon paper = createImageIcon("images/paper.jpg");
		ImageIcon scissors = createImageIcon("images/scissors.jpg");
		
		newGameButton = new JButton("New game");
		infoButton = new JButton("Get players names!");
		setNameButton = new JButton("Set my name");
		
		buttonRock = new JButton("Rock", rock);
		buttonRock.setVerticalTextPosition(AbstractButton.BOTTOM);
		buttonRock.setHorizontalTextPosition(AbstractButton.CENTER);
		
		buttonPaper = new JButton("Paper", paper);
		buttonPaper.setVerticalTextPosition(AbstractButton.BOTTOM);
		buttonPaper.setHorizontalTextPosition(AbstractButton.CENTER);
		
		buttonScissors = new JButton("Scissors", scissors);
		buttonScissors.setVerticalTextPosition(AbstractButton.BOTTOM);
		buttonScissors.setHorizontalTextPosition(AbstractButton.CENTER);
		
		buttonRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					outW.println("Rock");
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
		buttonPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					outW.println("Paper");
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
		buttonScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					outW.println("Scissors");
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					outW.println("new game");
					//out.writeObject("new game");
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					outW.println("Get all players names!");
					//out.writeObject("Get all players names!");
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
		setNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					if (setNameField.getText()!=null && !setNameField.getText().equals("")) {
						outW.println("setPlayerName"+setNameField.getText());
						//out.writeObject("setPlayerName"+setNameField.getText());
						name = setNameField.getText();
					}
				} catch (Exception e) {
					System.out.println("Cannot connect with server");
				}
			}
		});
		
	}
	
	
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ClientApplication.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


	
}
