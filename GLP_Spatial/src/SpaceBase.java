package glp1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SpaceBase extends JPanel {


	
    private int initial_positionx=800;
    private int initial_positiony=500;
    private int positionx=0;
    private int positiony=0;
	private ImageIcon icon2 = new ImageIcon("glp1/espace.jpg");
	Image space = icon2.getImage(); 
    private static final long serialVersionUID = 1L;
    
	
    public SpaceBase() {
    	
    	
    	
    	
    	
    }
    
    public void paintComponent(Graphics g) {

		
		super.paintComponent(g);	
		 g.drawImage(space,3,0,1500,1000,null);
		 g.drawImage(Simulationutility.readImage("glp1/terre.jpg"),800,450,100,151,null);
		 g.drawImage(Simulationutility.readImage("glp1/satellite.jpg"),initial_positionx+positionx,initial_positiony+positiony,50,75,null);
		 
		 
		 
		 /*System.out.println("x"+positionx+"y"+positiony+"");
		 */
		
   }
   
   public int getpositionx() {
	   
	  return positionx;
	   
   }

   public int getpositiony() {
	   
		  return positiony;
		   
  }

  public void setpositionx(int positionx) {
	  
	  
	  this.positionx=positionx;
	  
  }
   
  public void setpositiony(int positiony) {
	  
	  
	  this.positiony=positiony;
	  
  } 
   
   
   
}
