package chrono;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class manages the dashboard (hour, minute, second) of chronometer GUI.
 * 
 * This class is only responsible of graphical result printing.
 * 
 * There is no algorithmic processing in this class.
 * 
 * @author tliu@u-cergy.fr
 * 
 */
public class Dashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Rocket and base image have his initial position
	 */
	
	private Point position = new Point(700,560);
	private int x = position.getX();
	private int y = position.getY();
	
	private ImageIcon icon = new ImageIcon("src/pictures/fusee.jpg");      
	Image fusee = icon.getImage();
	private ImageIcon icon2 = new ImageIcon("src/pictures/BackgroundCap.jpg");
	Image background = icon2.getImage();
	
	String launchtext = "Click on the << Start Launch >> button and wait a few second for the start of the rocket launch ";
	String launchtext2 = "The launch has started";
	String launchtext3 = "The rocket is accelarating for gain enough speed in order to be able to go in the space ";
	String launchtext4 = "The rocket has reached the speed required, now let's see what happen in the space... ";
	
	int checkpointX = 10;
	int checkpointY = 550;
	int checkpointY2 = 400;
	int checkpointY3 = 150;
	
	String checkpointName = "Step 1  ";
	String checkpointName2 = "Step 2  ";
	
	/**
	 * Defines what to do when the repaint() method is called.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background,3,0,857,647,null);
		g.drawImage(fusee,x,y,50,122,null);
		
		if (y > checkpointY) {
			g.drawString(launchtext,10,25);
		}
		
		else if (y > checkpointY2) {
			g.drawLine(0,checkpointY2-5,863,checkpointY2-5);
			g.drawString(checkpointName,checkpointX,checkpointY2+10);
			g.drawString(launchtext2,10,25);
		}
		
		else if (y > checkpointY3) {
			g.drawLine(0,checkpointY3-5,863,checkpointY3-5);
			g.drawString(checkpointName2,checkpointX,checkpointY3+10);
			g.drawString(launchtext3,10,25);
		}
		
		else {
			g.drawString(launchtext4,10,25);
		}
		
	}
	
	public void accelerationY(int sec) {
		y = y-(sec/200) ;
	}
	
	public int getValueY(int sec) {
		y = y-(sec/200) ;
		return y;
	}
	
	public void resetY() {
		y = position.getY();
	}
}