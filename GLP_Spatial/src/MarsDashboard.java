package glp1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarsDashboard  extends JPanel {


	
	private static final long serialVersionUID = 1L;
    private Mars mars =new Mars();	
    private int marspositionx=0;/*1 unité dans l' ihm graphique correspont à 2*10E5 km*/
    private int marspositiony=0;
    private int earthpositionx=0;
    private int earthpositiony=0;
    private int rocketpositionx=0;
    private int rocketpositiony=0;
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private JLabel earth_sun_distancevalue = new JLabel("");
    private JLabel earth_sun_distancelabel = new JLabel("earth_sun distance");
    private JLabel timevalue  = new JLabel("");
    private JLabel timelabel = new JLabel("time");
	private JLabel positionearthxvalue      = new JLabel("");
    private JLabel positionearthxvlabel      = new JLabel("earth x=");
    private JLabel positionearthyvalue      = new JLabel("");
    private JLabel positionearthylabel      = new JLabel("earth y=");
    private JLabel positionmarsxlabel      = new JLabel("mars x=");
    private JLabel positiomarsylabel      = new JLabel("mars y=");
    private JLabel positionmarsxvalue      = new JLabel("");
    private JLabel positiomarsyvalue      = new JLabel("");
	
   
    private int valchoice;
  
	public MarsDashboard(int valchoice2){
    	
    valchoice=valchoice2;	
		
    setLayout(new FlowLayout(FlowLayout.CENTER));	
    
    
    
    earth_sun_distancevalue.setFont(font);
    add(earth_sun_distancevalue);
    
    timelabel.setFont(font);
    add(timelabel);
    
    timevalue.setFont(font);
    add(timevalue);
    
    positionearthxvlabel.setFont(font);
    add(positionearthxvlabel);
    
    
   
    positionearthxvalue.setFont(font);
    add(positionearthxvalue);
    
    positionearthylabel.setFont(font);
    add(positionearthylabel);
    
    positionearthyvalue.setFont(font);
    add( positionearthyvalue);
    
    positionmarsxlabel.setFont(font);
    add(positionmarsxlabel);
    
    positionmarsxvalue.setFont(font);
    add(positionmarsxvalue);
    
    positiomarsylabel.setFont(font);
    add(positiomarsylabel);
	
    positiomarsyvalue.setFont(font);
    add(positiomarsyvalue);
    
    earth_sun_distancelabel.setFont(font);
    add(earth_sun_distancelabel);
	
	}
	
	private int[] r4=  {21111,21123,21213,21223,22113,22123,22213,22223,21113,21123,21213,21223,22113,22123,22213,22223};/*750T*/
	private int[] r5 = {11111,11121,11211,11221,12111,12121,12211,12221,11111,11121,11211,11221,12111,12121,12211,12221};/*500T*/
	private int[] r6 = {11111,21121,11211,21221,11111,21121,11211,21221,11113,11223,21223,21223,11112,21112,11222,21222};/*5000kn*/
	private int[] r7 = {12111,22121,12211,22221,12111,22121,12211,22221,12113,12223,22223,22223,12112,22112,12222,22222};/*9000kn*/
	 private int tabsize = 16;
	
	 public int getvalchoice() {
		
	  return valchoice;	
	 	
	 }
	 
	 public JLabel getearthsundistancevalue() {
		
		
	return earth_sun_distancevalue; 	
		
	}
	public JLabel getpositionearthxvalue() {
		
		
	return positionearthxvalue; 	
		
	}
	
	public JLabel getpositionearthyvalue() {
		
		
		return positionearthyvalue; 	
			
    }
	
	
    public JLabel gettimevalue() {
    	
    	
      return timevalue;	
    	
    }
	
	public void paintComponent(Graphics g) {

		
		super.paintComponent(g);	
		 g.drawImage(Simulationutility.readImage("glp1/terre.jpg"),750+earthpositionx,400+earthpositiony,25,50,null);
		 g.drawImage(Simulationutility.readImage("glp1/soleil.jpg"),750,400,75,100,null);
		 g.drawImage(Simulationutility.readImage("glp1/mars.jpg"),750+marspositionx,390+marspositiony,25,50,null);
		 g.drawImage(Simulationutility.readImage("glp1/fusee2.jpg"),755+earthpositionx+rocketpositionx,390+earthpositiony+rocketpositiony,10,20,null);
		 /*g.drawLine(100, 700, 100, 600);
		 g.drawLine(100, 700, 200, 700);
		 */
	
		 
		 
    }
	
		
	public int getrocketpositionx() {
		
	return  rocketpositionx ;	
		
	}
	
    public int getrocketpositiony() {
		
	return  rocketpositiony	;
		
	}
	
	public void setrocketpositionx(int rocketpositionx) {
		
	this.rocketpositionx=rocketpositionx;	
		
	}
	
    public void setrocketpositiony(int rocketpositiony) {
		
	this.rocketpositiony=rocketpositiony;	
		
	}
	
	
	
	
	
    public int getpositionxmars() {
    	
    	
    return marspositionx;	
    	
    }
    
    
    public int getpositionymars() {
    	
    	
        return marspositiony;	
        	
    }
    
    public int getpositionxearth() {
    	
    	
        return earthpositionx;	
        	
    }
    
    public int getpositionyearth() {
    	
    	
    return earthpositiony;	
    	
    }
    public void setpositionx(int marspositionx) {
    	
    	
    this.marspositionx=marspositionx;	
    	
    }
    
    public void setpositionxearth(int earthpositionx) {
    	
    	
        this.earthpositionx=earthpositionx;	
        	
    }
    
    
    public void setpositionyearth(int earthpositiony) {
    	
    	
        this.earthpositiony=earthpositiony;	
        	
    }
    public void setpositiony(int marspositiony) {
    	
    	
    this.marspositiony=marspositiony;	
    	
    }

    public int weightchoose() {
 	     int weight=0;
 	    		 
		 int res=0;
		 for (int index = 0; index < tabsize; index++) {
				
			 if (r4[index] == valchoice) {
	            	res = 1 ;
	          }
			 
		 }
		 
		 for (int index = 0; index < tabsize; index++) {
		 
			 if (r5[index] == valchoice) {
	            	res = 2 ;
	          }
		 } 
			
	 
			 if (res == 1) {
					weight= 750;
		     }
		 
			 if (res == 2) {
					weight= 500 ;
			 
			 }	
		 
		return weight;
		
		
	}
	public int powerchoose() {
		int res= 0;
		int power=0;
		for (int index = 0; index < tabsize; index++) {
			
			 if (r6[index] == valchoice) {
	            	res = 1 ;
	          }
		}
		
		for (int index = 0; index < tabsize; index++) {
		 
			 if (r7[index] == valchoice) {
	            	res = 2 ;
	          }
		}	 
			 if (res == 1) {
					power= 5000;
		     }
			 if (res == 2) {
					power= 9000;
			 
			 }
		
		return power;
		
	}
}