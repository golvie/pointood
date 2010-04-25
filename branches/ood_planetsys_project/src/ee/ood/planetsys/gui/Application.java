/**
 * 
 */
package ee.ood.planetsys.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ee.ood.planetsys.businesslogic.planetary.SpaceShip;
import ee.ood.planetsys.businesslogic.planets_fascade.PSController;

/**
 * @author Jaroslav Judin
 * Mar 19, 2010
 */
@SuppressWarnings("serial")
public class Application extends JFrame {
	
	
	private JPanel buttonPanel;
	private PSController controller;
	//private ArrayList<Point> po_dict;
	private final int planet_width = 3;
	private final int zoom = 6;
	private final int auto_speed = 100;
	private boolean auto_on = false;
	private final int cx = 400;
	private final int cy = 350;
	
	private JPanel drawPanel = new JPanel(){
		@Override
		public void paint(Graphics g) {			
			super.paint(g);
		    draw_planets(g);		
		}
	};
	
	public Application(String name) {
		super(name);
		
		controller = new PSController();
		//po_dict = new ArrayList<Point>();

		this.createWidgets();
		this.make_solar_system();
	}
	
	public void tick() {
		this.controller.tick();
		//this.move_planets();
		repaint();
	}
	
	public void tick100() {
		this.controller.multi_tick(100);
		//this.move_planets();
		repaint();
	}
	
	public void auto() {
		this.auto_on = !this.auto_on;
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
		
	private void make_solar_system() {
		this.controller.make_solar_system();
		this.delete_planets();
		this.draw_planets(getGraphics());
	}
	
	private void createWidgets() {
		//drawPanel = new JPanel();
		buttonPanel = new JPanel();		
		drawPanel.setBackground(Color.black);
		buttonPanel.setBackground(Color.gray);
		buttonPanel.setLayout((new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)));
		this.setLayout(new BorderLayout());
		this.setSize(cx*2, cy*2);
		
		JButton bTick = new JButton("Tick");
		JButton bAuto = new JButton("Auto");
		JButton b100 = new JButton("Tick100");
		JButton bDefault = new JButton("Solar System");
		JButton bLaunch = new JButton("Launch");
		
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
		buttonPanel.add( bTick );
		buttonPanel.add( b100 );
		buttonPanel.add( bAuto );
		buttonPanel.add( bDefault );
		buttonPanel.add( bLaunch );
		
		this.getContentPane().add(BorderLayout.CENTER,drawPanel);
		this.getContentPane().add(BorderLayout.EAST,buttonPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/*public void paint(Graphics g) {      
		Graphics2D g2 = (Graphics2D) drawPanel.getGraphics();
		drawPanel.paint(g2);	
        g2.setColor(Color.yellow);
        g2.fillOval(cx, cy, planet_width, planet_width);
        g2.setColor(Color.white);
		for(int i=0; i<po_dict.size(); i++)
			g2.fillOval(po_dict.get(i).x, po_dict.get(i).y, planet_width, planet_width);
	}*/
	
	public Point conv_coord(double x, double y) {
		int x0 = (int) (this.cx + x * this.zoom);
		int y0 = (int) (this.cy + y * this.zoom);
		return new Point(x0,y0);
	}
	
	public void draw_planets(final Graphics g) {
		for(int id=0; id<this.controller.getPlanetarySystem().size(); id++)
			draw_planet(id, g);
		//super.paint(getGraphics());
	}
	
	public void draw_planet(int planet_id, Graphics g) {
		double x = controller.getPlanetarySystem().get(planet_id).x();
		double y = controller.getPlanetarySystem().get(planet_id).y();
		Point coord = this.conv_coord(x, y); 
		//this.po_dict.add(planet_id, coord);
		
		g.setColor(Color.white);
		g.fillOval(coord.x, coord.y, planet_width, planet_width);
	}
	
	/*public void move_planets() {
		for(int i=0; i < controller.getPlanetarySystem().size(); i++)
			move_planet(i, controller.getPlanetarySystem().get(i).x(), controller.getPlanetarySystem().get(i).y());
		//paint(getGraphics());
	}
	
	public void move_planet(int planet_id, double x, double y) {
		Point new_coord = this.conv_coord(x, y); 
		this.po_dict.set(planet_id, new_coord);
	}*/
	
	public void delete_planets() {
		//po_dict.clear();
		repaint();
	}
	
	public void launch() {
		SpaceShip ship = controller.launch(4, 0.5, 0.5);
		int id = this.controller.getPlanetarySystem().size() - 1;
		//draw_planet(id, getGraphics());
		//paint(getGraphics());
	}
	
	/*---------------------------------------
	 * --------------MAIN--------------------
	 * -------------------------------------*/
	public static void main(String[] args) {
		new Application("Planets System");	
	}
}
