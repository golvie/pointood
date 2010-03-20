

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MListener implements 
        MouseListener, MouseMotionListener {
        
        private Point from;
        private Point to;
        private Point toX;
        private boolean pen = true; 
        private DrawPanel drawPanel;
       
        public MListener(DrawPanel draw) {
                this.drawPanel = draw;
        }
        
        public void enablePen(){
        	pen = true;
        	drawPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        public void disablePen(){
        		pen = false;
        		drawPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
        
        @Override
        public void mousePressed(MouseEvent e) {   
            	from = e.getPoint();   
            	toX = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        	
        		to = e.getPoint();
        		Line line = new Line(from, to);
        		drawPanel.lisaUusJoon(line);
        }
        
       
        @Override
        public void mouseDragged(MouseEvent e) {
        		if(pen) {
        			Line line = new Line(from, e.getPoint());
        			from = e.getPoint();
        			drawPanel.lisaUusJoon(line);
        		}
        		else {
        			Color xorColor = new Color(255, 255, 255);//Color.white;
        			Graphics g = drawPanel.getGraphics();
        			g.setColor( drawPanel.getColor());
        			//Color color = drawPanel.getColor();
        			
        			
        			
        			g.setXORMode(xorColor);
        			drawPanel.viewLine(new Line(from, toX), g);
        			toX = e.getPoint();
        			
        			drawPanel.viewLine(new Line(from, toX), g);
        		}
        }
        @Override
        public void mouseClicked(MouseEvent e) {
                
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                
        }

        @Override
        public void mouseExited(MouseEvent e) {
               
        }
        @Override
        public void mouseMoved(MouseEvent e) {
                
        }

}

