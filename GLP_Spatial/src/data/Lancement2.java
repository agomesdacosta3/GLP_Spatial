package glp1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import glp1.Base;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import glp1.RocketEarth;


public class Lancement2 extends JFrame  {
    
	
	
	private Counter chrono= new Counter(0);
	private int t=chrono.getValue();
	
    private String titre;
	


	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 800);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(800, 800);
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 40);
	private Base base=new Base();
	 private int posistionx=base.getposistionx();
     private int positiony=base.getpositiony();
     
     private JLabel startlabel=new JLabel("start");
     private JLabel speedlabel=new JLabel("speed");
     private JLabel heightlabel=new JLabel("height");
     private JLabel powerlabel=new JLabel("power");
     
     private JLabel speedvalue=new JLabel("");
     private JLabel heightvalue=new JLabel("");
     private JLabel imagelbl;
     private ImageIcon photo;
     /*private JButton powerboutton=new JButton("power");
     private JButton heightboutton=new JButton("height");*/
     private JButton startboutton=new JButton("start"); 
     
     public void initactions() {
     startboutton.addActionListener(new ActionListener (){ 
      	 @Override
    	 public void actionPerformed(ActionEvent e) {
  			
  			String power1=powerfield.getText();
      		String weight1=weightfield.getText();
      		
      		int power=Integer.valueOf(power1);
      		int weight=Integer.valueOf(weight1);
      		
      	   TrajectoryEarth traj=new TrajectoryEarth();  
      
      	  try {
 				updatevalues(weight,power);
 			} catch (NotEngoughPowerException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
  			
  		}	
      	
       }
        ); 
     
      
     }
     
     private JLabel messagelabel=new JLabel("everything is OK!");
     
     private JTextField weightfield=new JTextField(10);
     private JTextField powerfield=new JTextField(10);
     private JPanel pan=new JPanel();
   
     
     private int height=10  ; 
 	private int power=1000 ;/*Integer.valueOf(powerfield.getText() );*/
     
     private  String weight1= weightfield.getText(); 
    private  String  power1  =powerfield.getText();  
     
     public String getpower1() {
    	 
    	 
    	return power1; 
    	 
     }
     
     public String getweight1() {
    	 
    	 
    	return weight1;
    	 
     }
     public String getpower() {
    	 
    	 
     	return power1; 
     	 
      }
      
      public String getheight() {
     	 
     	 
     	return weight1;
     	 
      }

 
     
     public Lancement2(String titre)   {
    	
       this.titre=titre;
    	try {
      
    	
        initactions();
    	init();
    	}catch(NotEngoughPowerException e) {
    		
    		System.out.println("pas assez de puissance");
    		
    	}
     }
     
     
     
     private void init() throws NotEngoughPowerException {
    	
    	
    
    	 Container contentPane = getContentPane();
    	 contentPane.setLayout(new BorderLayout());
    	
    	 pan.setLayout(new FlowLayout(FlowLayout.CENTER));
    /*	 
    	 this.start();
    	 this.speed();
    	 this.height();
    */	
    	/* this.power();
    	
    	 this.heightbutton();
    	 this.powerbutton();
    */
   
    startlabel.setFont(font);
     pan.add(startlabel);
     
     
     
     speedlabel.setFont(font);
     pan.add(speedlabel);
     
     speedvalue.setFont(font);
     pan.add(speedvalue);
     /*
     this.base.afficheimage();
      /*
     imagelbl.setFont(font1);
     pan.add(imagelbl);
     */
     
     
     
     messagelabel.setFont(font);
     pan.add(messagelabel);
     /*
     powerboutton.setFont(font);
     powerboutton.addActionListener(new  PowerAction()   );
     pan.add(powerboutton);
     
     */
     powerlabel.setFont(font);
     pan.add(powerlabel);
     
     powerfield.setFont(font);
     pan.add(powerfield);  
     
     heightlabel.setFont(font);
     pan.add(heightlabel);
     
    
     
     weightfield.setFont(font);
     pan.add(weightfield);

   
     
     startboutton.setFont(font);
    
     pan.add(startboutton);
     
     
   
     contentPane.add(BorderLayout.SOUTH, pan);

	base.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		contentPane.add(BorderLayout.NORTH, base);

     
     pack();
     
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     
	 setVisible(true);	
     
     pack();
     
     
     
     }
     
     
     
     public class Addpoweraction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		String power=powerfield.getText();	
		}
    	 
    	 
    	 
    	 
     }
     
     
     
     public class Addheightaction implements ActionListener{
    	
    
   

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String height=weightfield.getText(); 
    	
	}
    	 
    	 
    	 
    	 
     }
     /*
     private void afficheimage() {
 		
 		imagelbl= new JLabel();
 		photo=new ImageIcon("image/fusee2.jpg");
 	
 		
 		this.imagelbl.setBounds(posistionx, positiony,500,500);
 	    this.imagelbl.setIcon(photo);
 	    this.add(imagelbl);
 	}
 	*/
 	

     

     


     
     private void updatevalues(int height,int power) throws NotEngoughPowerException {

   RocketEarth rocket=new RocketEarth(height,power);
   double result;
     
	result = rocket.trajectory(height, power, t);

	
	while(result<600) {/*une unité dans l' interface représente deux km dans la vraie vie 1 seconde dans l' IHM correspond à 14,05 s dans la vie*/
	
		
	base.setpositiony((int)(result));
	/*
	base.repaint();
	/*
	base.afficheimage();
  */
    
    chrono.increment();
    t=chrono.getValue();
    System.out.println("temps "+t+"le résultat est "+result+"");
   result=(int)(rocket.trajectory(height, power,t)); 
   
   
	 }
	 updatestandardmessage("we are in the space");
	 }
    private void updatestandardmessage(String message) {
		// TODO Auto-generated method stub
    	 messagelabel.setText(message); 	
	}

     
	private static final long serialVersionUID = 1L;  



	  
    public double trajectory(int height,int power) {
    return ((power/height)*Math.pow(t,2.0))/2+positiony;
    }


  
	   public static void main(String[]args) {

		   
			  new Lancement2("lancement");
			   
		   }	


}


