package ee.paint.panels;

import ee.paint.listener.MouseLis;
import ee.paint.panels.DrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PaintFrame extends JFrame {

	private JRadioButton freeLine;
    private JRadioButton staticLine;
	private ButtonGroup group;
	private JPanel radioBlock;
	private JPanel rbPanelAndColor;
	private JPanel left;
	private JButton butColor;
	private JButton butClear;

	private DrawPanel drawPanel;
    private final MouseLis listener;

    public static final String FREE_LINE = "Free line";
    public static final String JUST_LINE = "Just line";
    public static final String COLOR_CHOOSER = "Choose color";
    public static final String PALETTE = "Palette";

	public PaintFrame (String title) {
		setTitle(title);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int lx = screenSize.width;
		int ly = screenSize.height;
		setBounds(lx*25/100, ly*2/10, lx/2, 6*ly/10);

		Image im = kit.getImage("paint.gif");
		setIconImage(im);

		drawPanel = new DrawPanel();
		listener = new MouseLis(drawPanel);
		drawPanel.addMouseListener(listener);
		drawPanel.addMouseMotionListener(listener);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(leftPanel(), BorderLayout.WEST);
        mainPanel.add(drawPanel, BorderLayout.CENTER);
	    this.add(mainPanel);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible( true );

	}

	public JPanel rbPanel () {
		group = new ButtonGroup();
		freeLine = new JRadioButton(FREE_LINE, true);
		staticLine = new JRadioButton(JUST_LINE);
		group.add( freeLine );
		group.add( staticLine );

		radioBlock = new JPanel();
		radioBlock.setLayout(new BoxLayout(radioBlock, BoxLayout.Y_AXIS));
		radioBlock.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		radioBlock.setBorder(BorderFactory.createTitledBorder(PALETTE));
		radioBlock.add(freeLine);
		radioBlock.add(staticLine);

		freeLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setFreeLine(true);
				//System.out.println(FREE_LINE);
			}
		});
		staticLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setFreeLine(false);
				//System.out.println(JUST_LINE);
			}
		});

		return radioBlock;
	}

	public JPanel rbAndColor () {
		butColor = new JButton(COLOR_CHOOSER);

		rbPanelAndColor = new JPanel();
		rbPanelAndColor.setLayout(new BorderLayout());
		rbPanelAndColor.add(rbPanel(), BorderLayout.NORTH);
		rbPanelAndColor.add(butColor, BorderLayout.CENTER);

		butColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = JColorChooser.showDialog(null, COLOR_CHOOSER, Color.BLACK);
				drawPanel.setColor(col);
				//System.out.println(COLOR_CHOOSER);
			}
		});

		return rbPanelAndColor;
	}

	public JPanel leftPanel () {
		butClear = new JButton("Clear");

		left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(rbAndColor(), BorderLayout.NORTH);
		left.add(butClear, BorderLayout.SOUTH);

		butClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPanel.deleteContent();
				//System.out.println("Button Clear");
			}
		});

		return left;
	}

}
