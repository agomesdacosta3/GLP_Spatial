package glp1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EarthPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	
	
	 private JLabel positionxvalue  =new JLabel("0");
     private JLabel positionxlabel = new JLabel("positionx (km)");
     private JLabel positionyvalue  =new JLabel("0");
     private JLabel positionylabel = new JLabel("positiony (km)");
     private JLabel anglevalue = new JLabel("0");
     private JLabel anglelabel = new JLabel("angle (radian)");
     private JLabel timevalue = new JLabel("0");
     private JLabel timelabel = new JLabel("time (secondes)");
 	
 	 private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

 	 
 	 
 	 
  public EarthPanel() {
    
	  
   setLayout(new FlowLayout(FlowLayout.CENTER));

    
    setBackground(Color.WHITE);
   
    positionxlabel.setFont(font);
    add(positionxlabel);
    
    positionxvalue.setFont(font);
    add(positionxvalue);
    
    positionylabel.setFont(font);
    add(positionylabel);
    
    positionyvalue.setFont(font);
    add(positionyvalue);
    
    anglelabel.setFont(font);
    add(anglelabel);
    
    anglevalue.setFont(font);
    add(anglevalue);
    
    timelabel.setFont(font);
    add(timelabel);
    
    timevalue.setFont(font);
    add(timevalue);
    
    

	
	}	

    public JLabel getpositionxvalue() {
    	
    	
    return positionxvalue;	
    	
    }
    
    public JLabel getpositionyvalue() {
    	
    	
    return positionyvalue;	
    	
    }

    public JLabel getanglevalue() {
    	
    return anglevalue;	
    	
    }

    public JLabel gettimevalue() {
    	
    	
    return timevalue;	
    	
    	
    }
    
    
}
