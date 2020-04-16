package glp1;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarsSpaceCraftDashboard extends JPanel {
    private int y=0;
	private int valchoice;
	  private static final long serialVersionUID = 1L;
	  double height=y*193.79;	
	  private JLabel distanceValue= new JLabel(" "+height+" km");
	  private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	  public MarsSpaceCraftDashboard(int valchoice2) {
		valchoice=valchoice2;	   
	       	
		init();
		setheight();
	}
	
	private double calculateheight(double height) {
		
	return height-0.19379;	
		
		
	}
	
	public JLabel getheightValue() {
		
		
	return distanceValue;	
		
	}
	
	public void setheight() {
	double height1=calculateheight(height);
	distanceValue.setText(""+height1+ "");
	}
	
	public void init() {
		
	distanceValue.setFont(font);
	
		
	}
	public void accelerationY(int sec) { 
		y = y+(sec/200) ;
	}
    public void setVal (int newval) {
		valchoice = newval ;
	}
    public int gety() {
	
	return y;	
    
	}
	public int getValueY(int sec) {
		return y;
	}
	private String landingmessage="The spaceCraft is now landing...";	
	private String bilanmessage="The spaceCraft has landed, Let's do a record of the mission.";
	public void paintComponent(Graphics g) {

		/*System.out.println(""+y+"");*/
		super.paintComponent(g);
		 g.drawImage(Simulationutility.readImage("glp1/surface_mars.jpg"),0,0,800,800,null);
		 g.drawImage(Simulationutility.readImage("glp1/sonde_mars.jpg"),400,0+y,50,75,null);
		 if(y==645) {
		 g.drawString(bilanmessage,10,25);  
		   	 
	     }else {
	        	 
	     g.drawString(landingmessage,10,25);    	  
	     }
		 
		 
		 
		 
	    }		

	
	
}
