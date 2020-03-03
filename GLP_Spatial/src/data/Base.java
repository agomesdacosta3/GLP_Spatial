package glp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import glp1.Simulationutility;
public class Base extends JPanel implements ActionListener {


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
    Image image;
    private int positionx=0;
	private int posistiony=0;
    private int INITIAL_POSITIONY = 600;
    
    Timer tm =new Timer(5,this);
    public void proprietebase() {
    
    	this.setLayout(null);
    	/*this.start();
    	this.speed();
    	this.height();
    	this.power();*/
    	
    	/*this.initaction();*/
    }
	
    public JLabel getimagelbl() {
    	
    	return imagelbl;
    }
    private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	public void paintComponent(Graphics g) {
        
		super.paintComponent(g);
		/*g.setColor(Color.BLUE);
		g.drawLine(10, 90,300,200);*/
    
		g.drawImage(Simulationutility.readImage("src/glp1/fusee2.jpg"),700,INITIAL_POSITIONY ,null);
	    tm.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		INITIAL_POSITIONY=INITIAL_POSITIONY-posistiony;
		// TODO Auto-generated method stub
		repaint();
	}
    /*
	
    public void afficheimage() {
 		
		imagelbl= new JLabel();
		photo=new ImageIcon("image/fusee2.jpg");
	
		
		this.imagelbl.setBounds(positionx, posistiony ,500,500);
	    this.imagelbl.setIcon(photo);
	    this.add(imagelbl);
	}
	*/
	public int getposistionx() {
		
	 return positionx;	
		
	}
	
	public int getpositiony() {
		
		
	return INITIAL_POSITIONY;	
		
	}
	
	public void setpositionx(int positionx) {
		
	this.positionx=positionx;	
		
	}
	
	public void setpositiony(int positiony) {
		
	this.posistiony=positiony;	
		
		
	}


	
	
	
}
