package glp1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarsDashboard  extends JPanel {


	
    
    private Mars mars =new Mars();	
    private int marspositionx=0;/*1 unité dans l' ihm graphique correspont à 2*10E5 km*/
    private int marspositiony=0;
    private int earthpositionx=0;
    private int earthpositiony=0;
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
	
	
	public MarsDashboard(){
    	
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
		 g.drawImage(Simulationutility.readImage("glp1/terre.jpg"),500+earthpositionx,500+earthpositiony,75,100,null);
		 g.drawImage(Simulationutility.readImage("glp1/soleil.jpg"),500+marspositionx,500+marspositiony,75,100,null);
	     /*System.out.println("x"+positionx+"y"+positiony+"");
		 */
		 
    }
    public int getpositionx() {
    	
    	
    return marspositionx;	
    	
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

	
	
	
	
	
}
