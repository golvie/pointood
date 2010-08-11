import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseLis implements MouseListener, MouseMotionListener {
     
	private Point from, to;
	private Point toX;
	private int param = 1; 
	private DrawPanel drawPanel;
   
	public MouseLis(DrawPanel draw) {
		this.drawPanel = draw;
	}
	public void useFreeLine() {
		param = 1;
	}
	public void useLine() {
		param = 0;
	}
	

	public void mousePressed(MouseEvent e) {
		from = e.getPoint();
		toX = e.getPoint();
	}

	public void mouseReleased(MouseEvent e) {
		to = e.getPoint();
		Line line = new Line(from, to);
		drawPanel.addNewLine(line);
	}
	  

	public void mouseDragged(MouseEvent e) {
		if(param == 1) {
			Line line = new Line(from, e.getPoint());
			from = e.getPoint();
			drawPanel.addNewLine(line);
		} else {
			Color xorColor = new Color(255, 255, 255);
			Graphics g = drawPanel.getGraphics();
			g.setColor(drawPanel.getColor());
						
			g.setXORMode(xorColor);
			drawPanel.viewLine(new Line(from, toX), g);
			toX = e.getPoint();			
			drawPanel.viewLine(new Line(from, toX), g);
		}
		
	}
	

	public void mouseClicked(MouseEvent e) {}


	public void mouseEntered(MouseEvent e) {}


	public void mouseExited(MouseEvent e) {}
	
	
	public void mouseMoved(MouseEvent e) {}
	
}