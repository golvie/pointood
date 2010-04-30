/**
 * 
 */
package ee.ood.planetsys.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ee.ood.planetsys.businesslogic.planets_fascade.PSController;

/**
 * @author Jaroslav Judin
 * Mar 19, 2010
 */
@SuppressWarnings("serial")
public class Application extends JFrame {
	
	
	private JPanel buttonPanel;
	private PSController controller;
	private final int planet_width = 3;
	private final int zoom = 6;
	private final int auto_speed = 100;
	private boolean auto_on = false;
	private final int cx = 400;
	private final int cy = 350;
	private String titleLable = "TimeLine: ";
	
	private JPanel drawPanel = new JPanel(){
		@Override
		public void paint(Graphics g) {			
			super.paint(g);
		    draw_planets(g);		
		}
	};
	
	JButton bTick = new JButton("Tick");
	JButton bAuto = new JButton("Auto");
	JButton b100 = new JButton("Tick100");
	JButton bDefault = new JButton("Solar System");
	JButton bLaunch = new JButton("Launch");
	JButton bLaunchOp = new JButton("Launch Operated Spaceship");
	JButton bChangeDir = new JButton("Change direction");
	JButton bChangeSpeed = new JButton("Change speed");
	JButton bWait = new JButton("Wait");
	JTextField dirField = new JTextField("changed_angle",5);
	JTextField speedField = new JTextField("speed_factor",5);
	JTextField waitField = new JTextField("waited_ticks",5);
	
	public Application(String name) {
		super(name);
		
		controller = new PSController();

		this.createWidgets();
		this.make_solar_system();
	}
	
	
	public void tick() {
		this.controller.tick();
		repaint();
		buttonPanel.setBorder(BorderFactory.createTitledBorder(titleLable + controller.getCounter()));
	}
	
	public void tick100() {
		this.controller.multi_tick(100);
		repaint();
		buttonPanel.setBorder(BorderFactory.createTitledBorder(titleLable + controller.getCounter()));
	}
	
	public void auto() {
		this.auto_on = !this.auto_on;
		if(auto_on)
			bAuto.setText("Stop");
		else
			bAuto.setText("Auto");
		this.autoTick();
	}
	
	public void autoTick() {
		Timer t = new Timer();
		if(auto_on){
			this.tick();
			TimerTask tt= new TimerTask() {
				public void run() {
					autoTick();	
				}
			};
			t.schedule(tt, auto_speed);
		}
	}
	
	public void showError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Exception", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	private void make_solar_system() {
		this.controller.make_solar_system();
		this.delete_planets();
	}
	
	private void createWidgets() {
		buttonPanel = new JPanel();		
		drawPanel.setBackground(Color.black);
		buttonPanel.setLayout(new GridLayout (3,4));
		buttonPanel.setBorder(BorderFactory.createTitledBorder(titleLable + controller.getCounter()));
		this.setLayout(new BorderLayout());
		this.setSize(cx*2, cy*2);
		
		bChangeDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.operatedChangeDirection( Double.valueOf(dirField.getText()) );
				} catch (NumberFormatException ex) {
					showError("cannot get value of direction");
				}
			}
		});
		bChangeSpeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.operatedChangeSpeed( Double.valueOf(speedField.getText()) );
				} catch (NumberFormatException ex) {
					showError("cannot get value of speed");
				}
			}
		});
		bWait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.operatedWait( Integer.valueOf(waitField.getText()) );
				} catch (NumberFormatException ex) {
					showError("cannot get value of waiting");
				}
			}
		});
		bTick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tick();
			}
		});
		bAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				auto();
			}
		});
		b100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tick100();
			}
		});
		bDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				make_solar_system();
			}
		});
		bLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launch();
			}
		});
		bLaunchOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchOperated();
			}
		});
		
		buttonPanel.add( bTick );
		buttonPanel.add( b100 );
		buttonPanel.add( bAuto );
		buttonPanel.add( bDefault );
		buttonPanel.add( bLaunch );
		buttonPanel.add( bLaunchOp );
		buttonPanel.add( bChangeDir );
		buttonPanel.add( dirField );
		buttonPanel.add( bChangeSpeed );
		buttonPanel.add( speedField );
		buttonPanel.add( bWait );
		buttonPanel.add( waitField );
		
		this.getContentPane().add(BorderLayout.CENTER,drawPanel);
		this.getContentPane().add(BorderLayout.NORTH,buttonPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public Point conv_coord(double x, double y) {
		int x0 = (int) (this.cx + x * this.zoom);
		int y0 = (int) (this.cy + y * this.zoom);
		return new Point(x0,y0);
	}
	
	public void draw_planets(final Graphics g) {
		g.setColor(Color.yellow);
		g.drawOval(cx, cy, planet_width, planet_width); // DRAW SUN
		for(int id=0; id<this.controller.getPlanetarySystem().size(); id++)
			draw_planet(id, g);
	}
	
	public void draw_planet(int planet_id, Graphics g) {
		double x = controller.getPlanetarySystem().get(planet_id).x();
		double y = controller.getPlanetarySystem().get(planet_id).y();
		Point coord = this.conv_coord(x, y); 
		
		g.setColor(Color.white);
		g.drawOval(coord.x, coord.y, planet_width, planet_width);
	}
	
	
	public void delete_planets() {
		repaint();
		buttonPanel.setBorder(BorderFactory.createTitledBorder(titleLable + controller.getCounter()));
	}
	
	public void launch() {
		controller.launch(4, 0.5, 0.5);
	}
	
	public void launchOperated() {
		controller.launchOperated(4, 0.5, 0.5);
	}
	
	/*---------------------------------------
	 * --------------MAIN--------------------
	 * -------------------------------------*/
	public static void main(String[] args) {
		new Application("Planetary System");	
	}
}
