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
public class DashboardWrong extends JPanel {
	
	private int valchoice ;
	private int chronospeed;

	public DashboardWrong (int valchoice2,int CHRONO_SPEED) {
		valchoice = valchoice2 ;
		chronospeed = CHRONO_SPEED;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Rocket and base image have his initial position
	 */
	
	private Point position = new Point(700,605);
	private int x = position.getX();
	private int y = position.getY();
	
	private ImageIcon icon = new ImageIcon("src/pictures/fusee.jpg");      
	Image fusee = icon.getImage();
	private ImageIcon icon2 = new ImageIcon("src/pictures/BackgroundCap.jpg");
	Image capcanaveral = icon2.getImage();
	private ImageIcon icon3 = new ImageIcon("src/pictures/Paris.jpg");
	Image paris = icon3.getImage();
	private ImageIcon icon4 = new ImageIcon("src/pictures/NorthPole.jpg");
	Image northpole = icon4.getImage();
	
	Image background = null;
	      
	String launchtext = "Click on the << Start Launch >> button and wait a few second for the start of the rocket launch ";
	String launchtext2 = "The launch has started";
	String launchtext3 = "The rocket is accelarating for gain enough speed in order to be able to go in the space ";
	String launchtext4 = "The rocket hasn't succeed to reach the speed required, now let's see why... ";
	String errortext = "Error in the process";
	
	int checkpointX = 10;
	int checkpointY = 603;
	int checkpointY2 = 400;
	int checkpointY3 = 150;
	
	String checkpointName = "Step 1  ";
	String checkpointName2 = "Step 2  ";
	
	private int[] arraycode1 = {11111,11121,11211,11221,12111,12121,12211,12221,21111,21121,21211,21221,22111,22121,22211,22221};
	private int[] arraycode2 = {11112,11122,11212,11222,12112,12122,12212,12222,21112,21122,21212,21222,22112,22122,22212,22222};
	private int[] arraycode3 = {11113,11123,11213,11223,12113,12123,12213,12223,21113,21123,21213,21223,22113,22123,22213,22223};
	private int tabsize = 16;
	
	private int[] arraycode4 = {11111,11112,11113,11121,11122,11123,12111,12112,12113,12121,12122,12123,21111,21112,21113,21121,21122,21123,22111,22112,22113,22121,22122,22123};
	private int[] arraycode5 = {11211,11212,11213,11221,11222,11223,12211,12212,12213,12221,12222,12223,21211,21212,21213,21221,21222,21223,22211,22212,22213,22221,22222,22223};
	private int tabgroup2size = 24;
	
	private int[] arraycode6 = {11111,11112,11113,11121,11122,11123,11211,11212,11213,11221,11222,11223,21111,21112,21113,21121,21122,21123,21211,21212,21213,21221,21222,21223};
	private int[] arraycode7 = {12111,12112,12113,12121,12122,12123,12211,12212,12213,12221,12222,12223,22111,22112,22113,22121,22122,22123,22211,22212,22213,22221,22222,22223};
	private int tabgroup3size = 24;
	
	private boolean checktext = true ; // gère le fait qu'il n'y ait pas de confusion entre le moment où la fusée monte et le moment où la fusée crash
 	
	/**
	 * Defines what to do when the repaint() method is called.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		background = ChooseBackground(background);
		
		g.drawImage(background,3,0,857,647,null);
		g.drawImage(fusee,x,y,25,61,null);
		
		if ((y > checkpointY) && (checktext == true)) {
			g.drawString(launchtext,10,25);
		}
		
		else if ((y > checkpointY2) && (checktext == true)) {
			g.drawLine(0,checkpointY2-5,863,checkpointY2-5);
			g.drawString(checkpointName,checkpointX,checkpointY2+10);
			g.drawString(launchtext2,10,25);
		}
		
		else if ((y > checkpointY3) && (checktext == true)) {
			g.drawLine(0,checkpointY3-5,863,checkpointY3-5);
			g.drawString(checkpointName2,checkpointX,checkpointY3+10);
			g.drawString(launchtext3,10,25);
		}
		
		else if ((y < checkpointY3) && (checktext == true)) {
			g.drawLine(0,checkpointY3-5,863,checkpointY3-5);
			g.drawString(launchtext3,10,25);
			checktext = false;
		}
		
		else if ((y > checkpointY3) && (checktext == false)) {
			g.drawString(launchtext4,10,25);
		}
		
		else if ((y > checkpointY2) && (checktext == false)) {
			g.drawString(launchtext4,10,25);
		}
		
		else if ((y > checkpointY) && (checktext == false)) {
			g.drawString(launchtext4,10,25);
		}
		
	}
	
	public void accelerationY(int sec) { // gère le choix de la puissance de propulsion
		
		int acceleration = sec/200;
		int res = 0 ;
		
		for (int index = 0; index < tabgroup3size; index++) {
            if (arraycode6[index] == valchoice) {
            	res = 6 ;
            }
		}
		
		for (int index = 0; index < tabgroup3size; index++) {
            if (arraycode7[index] == valchoice) {
            	res = 7 ;
            }
		}
		
		if (res == 6) {
			//Il n'est pas nécessaire de changer la valeur de la variable acceleration
		}
		else if (res == 7)  {
			acceleration = sec/150;
		}
		
		y = y-acceleration ;
	}
	
	public void deccelerationY(int sec) { // gère le crash de la fusee
		y = y+(sec/200);
		x = x-(sec/500);
	}
	
	public int getValueY(int sec) {
		return y;
	}
	
	public void resetY() {
		y = position.getY();
	}
	
	public void resetText() {
		checktext = true;
	}
	
	public void setVal (int newval) {
		valchoice = newval ;
	}
	
	public Image ChooseBackground(Image realbackground) { // gère le choix de la base de lancement
		
		int res = 0 ;
		
		for (int index = 0; index < tabsize; index++) {
            if (arraycode1[index] == valchoice) {
            	res = 1 ;
            }
		}
		
		for (int index = 0; index < tabsize; index++) {
            if (arraycode2[index] == valchoice) {
            	res = 2 ;
            }
		}
        
		for (int index = 0; index < tabsize; index++) {
            if (arraycode3[index] == valchoice) {
            	res = 3 ;
            }
		}
		
		if (res == 1) {
			realbackground = capcanaveral ;
		}
		else if (res == 2)  {
			realbackground = paris ;
		}
		else if (res == 3) {
			realbackground = northpole ;
		}
		return realbackground ;
	}
	
public int setChronoSpeed () { // gère le choix de la vitesse de la fusee
		
		int res = 0 ;
		
		for (int index = 0; index < tabgroup2size; index++) {
            if (arraycode4[index] == valchoice) {
            	res = 4 ;
            }
		}
		
		for (int index = 0; index < tabgroup2size; index++) {
            if (arraycode5[index] == valchoice) {
            	res = 5 ;
            }
		}
		
		if (res == 4) {
			//Il n'est pas nécessaire de changer la valeur du chronospeed
		}
		else if (res == 5)  {
			chronospeed = 50;
		}
		
		return chronospeed ;
	}

}