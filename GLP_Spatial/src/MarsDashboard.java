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
    private JLabel earth_sun_distancelabel = new JLabel("earth_sun distance=");
    private JLabel earth_mars_distancelabel = new JLabel("earth_mars distance=");
    private JLabel earth_mars_distancevalue = new JLabel("");
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
    
    earth_sun_distancevalue.setFont(font);
    add(earth_sun_distancevalue);    
	
    earth_mars_distancelabel.setFont(font);
    add(earth_mars_distancelabel);
    
    earth_mars_distancevalue.setFont(font);
    add(earth_mars_distancevalue);
	
	
	
	}
	
	private int[] r4=  {21111,21112,21113,21121,21122,21123,21211,21212,21213,21221,21222,21223,22111,22112,22113,22121,22122,22123,22211,22212,22213,22221,22222,22223};/*750T*//*21111,21123,21213,21223,22113,22123,22213,22223,21113,21123,21213,21223,22113,22123,22213,22223*/
	private int[] r5 = {11111,11112,11113,11121,11122,11123,11211,11212,11213,11221,11222,11223,12111,12112,12113,12121,12122,12123,12211,12212,12213,12221,12222,12223};/*500T*//*11111,11121,11211,11221,12111,12121,12211,12221,11111,11121,11211,11221,12111,12121,12211,12221*/
	private int[] r6 = {11111,11112,11113,11121,11122,11123,11211,11212,11213,11221,11222,11223,21111,21112,21113,21121,21122,21123,21111,21212,21213,21221,21222,21223  /*5000kn*//*11111,21121,11211,21221,11111,21121,11211,21221,11113,11223,21223,21223,11112,21112,11222,21222*//*11111,21121,11211,21221,11111,21121,11211,21221,11113,11223,21223,21223,11112,21112,11222,21222/*11111,21121,11211,21221,11111,21121,11211,21221,11113,11223,21223,21223,11112,21112,11222,21222,1,21123,11123,11122,21122*/};
	private int[] r7 = {12111,12112,12113,12121,12122,12123,12211,12212,12213,12221,12222,12223,22111,22112,22113,22121,22122,22123,22211,22212,22213,22221,22222,22223  /*9000kn*//*12111,22121,12211,22221,12111,22121,12211,22221,12113,12223,22223,22223,12112,22112,12222,22222 ,12111,22121,12211,22221,12111,12211,22221,12113,12223,22223,22223,12112,22112,12222,22222,1,12212,22212,12122,22122,12213*/};
/*	private int[] r8 = {};/*250T
	private int[] r9 = {};/*200Kn*/
	private int weighttabsize = 24;
	 private int powertabsize  = 24;
	 public int getvalchoice() {
		
		 
	  return valchoice;	
	 	
	 }
	 
	 public JLabel  getpositionmarsxvalue(){
		 
		 
	 return positionmarsxvalue	; 
		 
	 }
	 
	 
     public JLabel  getpositionmarsyvalue(){
		 
		 
	return positiomarsyvalue ;	 
		 
	 }
	 
	 
	 public JLabel getearthmarsdistancevalue() {
			
			
			return earth_mars_distancevalue; 	
				
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
		 g.drawImage(Simulationutility.readImage("glp1/fusee.jpg"),755+earthpositionx+rocketpositionx,390+earthpositiony+rocketpositiony,10,20,null);
		 g.drawLine(100, 700, 100, 600);/*ordonnée*/
		
		 g.drawLine(70, 630, 100, 600);/*fleche*/
		 g.drawLine(100, 600, 130, 630);
		 g.drawLine(100, 590, 100, 580);/*y*/
		 g.drawLine(100, 580, 90, 570);
		 g.drawLine(100, 580, 110, 570);
		 
		 g.drawLine(100, 700, 200, 700);/*absysse*/
		 g.drawLine(170, 730, 200, 700);/*fleche*/
		 g.drawLine(200, 700, 170, 670);
		 
		 g.drawLine(210, 690, 220,710 );
		 g.drawLine(210,710,220,690);
		 
	
		 
		 
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

    public int weightchoose(int valchoice) {
 	     int weight=0;
 	    		 
		 int res=0;
		 for (int index = 0; index < weighttabsize; index++) {
				
			 if (r4[index] == valchoice) {
	            	res = 1 ;
	          }
			 
		 }
		 
		 for (int index = 0; index < weighttabsize; index++) {
		 
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
	public int powerchoose(int valchoice) {
		int res= 0;
		int power=0;
		for (int index = 0; index < powertabsize; index++) {
			
			 if (r6[index] == valchoice) {
	            	res = 1 ;
	          }
		}
		
		for (int index = 0; index < powertabsize; index++) {
		 
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