import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	private Vector<Line> lines = new Vector<Line>();
	private Vector<Color> colors = new Vector<Color>();
	private Color usingColor = Color.black;
	
	DrawPanel(){
		setLayout(new BorderLayout());
		setBackground(Color.white);		
	}
	
	public void setColor(Color color){
    	usingColor = color;
    }
    public Color getColor(){
    	return usingColor;
    }
	public void deleteContent() {
		lines.clear();
		colors.clear();
		repaint();
	}
	
	public void viewLine(Line line, Graphics pic) {
        Graphics g = pic;
        g.drawLine(line.getFrom().x, line.getFrom().y, line.getTo().x, line.getTo().y );
    }
    
    public void lisaUusJoon(Line line) {
        lines.add(line);
        colors.add(usingColor);
        Graphics g = getGraphics();
        g.setColor(usingColor);
        g.drawLine(line.getFrom().x, line.getFrom().y, line.getTo().x, line.getTo().y);
    }

	@Override
	public void paint(Graphics g) {       		
	        super.paint(g);
	        joonistaJooned(g);
	}

	private void joonistaJooned(Graphics g) {

		for (int i = 0; i < lines.size() && i < colors.size(); i++) {
            Line line = lines.get(i);
            Color color = colors.get(i);
        	g.setColor(color);
            g.drawLine(line.getFrom().x, line.getFrom().y, line.getTo().x, line.getTo().y );
        }
        
	}
	
}
