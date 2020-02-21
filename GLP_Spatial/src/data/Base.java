package glp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base extends JPanel {


	public Base() {
		super();// TODO Auto-generated constructor stub
	    this.proprietebase();
	}
    private JLabel startlabel;
    private JLabel speedlabel;
    private JLabel heightlabel;
    private JLabel powerlabel;
    private JLabel imagelbl;
    private ImageIcon photo;
    private JButton powerboutton;
    private JButton heightboutton;
    

	
    
    public void proprietebase() {
    
    	this.setLayout(null);
    	/*this.start();
    	this.speed();
    	this.height();
    	this.power();*/
    	this.afficheimage();
    	/*this.initaction();*/
    }
    
    public JLabel getimagelbl() {
    	
    	return imagelbl;
    }
    private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	public void paintConpoFontnment(Graphics g) {
        
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(10, 90,300,200);

	}
	/*
	private void initaction() {
		
	powerboutton.addActionListener(new PowerAction() );	
	heightboutton.addActionListener(new HeightAction());	
		
	}*/

	private int positionx=750;
	private int posistiony=400;
	
    public void afficheimage() {
 		
		imagelbl= new JLabel();
		photo=new ImageIcon("image/fusee2.jpg");
	
		
		this.imagelbl.setBounds(positionx, posistiony ,500,500);
	    this.imagelbl.setIcon(photo);
	    this.add(imagelbl);
	}
	
	public int getposistionx() {
		
	 return positionx;	
		
	}
	
	public int getpositiony() {
		
		
	return posistiony;	
		
	}
	
	public void setpositionx(int positionx) {
		
	this.positionx=positionx;	
		
	}
	
	public void setpositiony(int positiony) {
		
	this.posistiony=positiony;	
		
		
	}
	/*
	private void afficheimage() {
		
		imagelbl= new JLabel();
		photo=new ImageIcon("image/fusee2.jpg");
	
		
		this.imagelbl.setBounds(positionx,posistiony,230,230);
	    this.imagelbl.setIcon(photo);
	    this.add(imagelbl);
	}
	
	/*
    private void start() {
   	 
   	 
   	 startlabel=new JLabel();
   	 this.startlabel.setBounds(10, 90, 70, 20);
        this.startlabel.setText("start");
        this.add(startlabel);
    }
    
    private void speed() {
      	 
      	 
    	speedlabel=new JLabel();
      	 this.speedlabel.setBounds(10, 180, 70, 20);
           this.speedlabel.setText("speed");
           this.add(speedlabel);
       }
    private void height() {
     	 
     	 
    	heightlabel=new JLabel();
      	 this.heightlabel.setBounds(10, 150, 70, 20);
           this.heightlabel.setText("height");
           this.add(heightlabel);
       }
    
    
    private void power() {
    	 
    	 
    	powerlabel=new JLabel();
      	 this.powerlabel.setBounds(10, 120, 70, 20);
           this.powerlabel.setText("power");
           this.add(powerlabel);
       }
    
}
    /*
    public class PowerAction implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		
    	String	power=powerlabel.getText();
    		
    		
    	}
    }
    public class HeightAction implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    	String height=heightlabel.getText();	
    		
    		
    	
    }*/
    	
}
    	
    	
    	
    	
    	
    	
    
     
    
    
    
/*
	public static void main(String[] args) {
		new Base();
	}

*/


