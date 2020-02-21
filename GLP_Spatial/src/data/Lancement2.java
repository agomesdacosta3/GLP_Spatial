package glp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import glp.Base;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import glp.RocketEarth;


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
      		String height1=heightfield.getText();
      		
      		int power=Integer.valueOf(power1);
      		int height=Integer.valueOf(height1);
      		
      	   TrajectoryEarth traj=new TrajectoryEarth();  
      	 /* traj.launch(power,height);/*
  	      System.out.println("power="+power+"height="+height+""); 
      	  */
      	  try {
 				updatevalues(height,power);
 			} catch (NotEngoughPowerException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
  			
  		}	
      	
       }
        ); 
     
      
     }
     
     private JLabel messagelabel=new JLabel("everything is OK!");
     
     private JTextField heightfield=new JTextField(10);
     private JTextField powerfield=new JTextField(10);
     private JPanel pan=new JPanel();
   
     
     private int height=10   /*Integer.valueOf(heightfield.getText())*/; 
 	private int power=1000 ;/*Integer.valueOf(powerfield.getText() );*/
     
     private  String height1= heightfield.getText(); 
    private  String  power1  =powerfield.getText();  
     
     public String getpower1() {
    	 
    	 
    	return power1; 
    	 
     }
     
     public String getheight1() {
    	 
    	 
    	return height1;
    	 
     }
     public String getpower() {
    	 
    	 
     	return power1; 
     	 
      }
      
      public String getheight() {
     	 
     	 
     	return height1;
     	 
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
     
    
     
     heightfield.setFont(font);
     pan.add(heightfield);

   
     
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
		String height=heightfield.getText(); 
    	
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
 	
     private void start() {
    	 
    	 
    	 startlabel=new JLabel();
    	 this.startlabel.setBounds(10, 50, 70, 20);
         this.startlabel.setText("start");
         this.add(startlabel);
     }
     
     private void speed() {
       	 
       	 
     	speedlabel=new JLabel();
       	 this.speedlabel.setBounds(10, 90, 70, 20);
            this.speedlabel.setText("speed");
            this.add(speedlabel);
        }
     private void height() {
      	 
      	 
     	heightlabel=new JLabel();
       	 this.heightlabel.setBounds(10, 120, 70, 20);
            this.heightlabel.setText("height");
            this.add(heightlabel);
        }
     
     
     private void power() {
     	 
     	 
     	powerlabel=new JLabel();
       	 this.powerlabel.setBounds(10,140, 70, 20);
            this.powerlabel.setText("power");
            this.add(powerlabel);
        }
     
     /*
     private void powerbutton() {
    	 
    	 this.powerboutton=new JButton();
    	 this.powerboutton.setBounds(10,160,20,20);
    	 this.powerboutton.setText("power");
         this.add(powerboutton);
     }
     */

     
     private void updatevalues(int height,int power) throws NotEngoughPowerException {

   RocketEarth rocket=new RocketEarth(height,power);
   double result;
     
	result = rocket.trajectory(height, power, t);

	
	while(result<120000) {
	
		
	
   /*if(checkmaj(height1 , power1)==true) {*/
	/*int positionx=rocket.trajectory();*/ 
		
	base.setpositiony((int)(result));
	 base.repaint();
	base.afficheimage();
    /*this.imagelbl.setBounds( this.imagelbl.getX() ,(int)(result),this.imagelbl.getWidth() ,this.imagelbl.getHeight() );	*/ 
    /*base.setpositionx((int)trajectory(height, power));
    base.setpositiony((int)trajectory(height, power));*/
   /* imagelbl.repaint();*/
  /*  base.repaint();*/
    
    chrono.increment();
    t=chrono.getValue();
    System.out.println("temps "+t+"le résultat est "+result+"");
   result=(int)(rocket.trajectory(height, power,t)); 
   
   
  /* }
    else {
    	
    	updatestandardmessage("enter a number");
    } */
	 }
	 updatestandardmessage("we are in the space");
	 }
    private void updatestandardmessage(String message) {
		// TODO Auto-generated method stub
    	 messagelabel.setText(message); 	
	}

     
	private static final long serialVersionUID = 1L;  

    /*
    public boolean checkmaj(String height1 ,String power1) {
    	 height1= heightfield.getText(); 
    	  power1  =powerfield.getText();
    	final char[] chars = height1.toCharArray();
 	    final char[] chars1 = power1.toCharArray();
 	   int i=0;
	    for(i=0;i<chars.length;i++) {
	    	 if ((chars1[i]>='0'&& chars1[i]<='9')   && (chars[i] >= '0' && chars[i] <= '9')) {    
	 		int	height = Integer.valueOf(heightfield.getText()); 
	 		 int     power  =Integer.valueOf(powerfield.getText());
	    	   
	    	 return true;
	    	 }  	
	    	
	    		 
	    	 
	    		 
	    	 }
	         
	         return false;
    }
	*/
    

    /*
    public double trajectory(int height,int power) {
    
    
    	String height1 =  heightfield.getText(); 
	    String  power1  =powerfield.getText();
	    
	    final char[] chars = height1.toCharArray();
	    final char[] chars1 = power1.toCharArray();
	   
	    int i=0;
	    for(i=0;i<chars.length;i++) {
	    if ((chars1[i]>='0'&& chars1[i]<='9')   && (chars[i] >= '0' && chars[i] <= '9')) {    
			height = Integer.valueOf(/*heightfield.getText()height1); 
		      power  =Integer.valueOf(/*powerfield.getText() power1);
	    	
	    	
	    	if((!(height==0))&&(!(power ==0))) {
		try{
			 height = Integer.valueOf(heightfield.getText()); 
		     power  =Integer.valueOf(powerfield.getText());	
		 
		 
		if(height<=0) {
			updatestandardmessage("le poids doit etre positif et non nul");
			/*throw new IllegalArgumentException("le poids doit etre positif et non nul ");
			
		}
		if(power<height) {
			updatestandardmessage("We need more power to take off the rocket");
		   /* throw new IllegalArgumentException("We need more power to take off the rocket");	
		
		}
		
		else {
			
			
			return ((power/height)*Math.pow(t,2.0))/2+positiony;
		
		}
	
		}catch(NumberFormatException number){
			
			updatestandardmessage("please enter a number");
			System.out.println("please enter a number !");
			
		
			
		}
		
		}else{
		
			updatestandardmessage("the field is empty");
			throw new NumberFormatException("the field is empty!");	
			/*updatestandardmessage("the field is empty!");
			
		}
	      }
	    else {
	    	 
	    	 
	    	 throw new NumberFormatException("it is not a number");
	    	 
	    	 
	     }
    	
    }*/
	  
    public double trajectory(int height,int power) {
    return ((power/height)*Math.pow(t,2.0))/2+positiony;
    }
    /*
    private class Calculateposition/*(int height,int power) implements ActionListener{
		 
		double position;
		@Override
		public void actionPerformed(ActionEvent e)  {
		String height1 =  heightfield.getText(); 
	    String  power1  =powerfield.getText();
	    
	    final char[] chars = height1.toCharArray();
	    final char[] chars1 = power1.toCharArray();
	   
	    int i=0;
	    for(i=0;i<chars.length;i++) {
	    if ((chars1[i]>='0'&& chars1[i]<='9')   && (chars[i] >= '0' && chars[i] <= '9')) {    
			height = Integer.valueOf(heightfield.getText()); 
		      power  =Integer.valueOf(powerfield.getText() );
	          RocketEarth rocket= new RocketEarth(height,power);    	
	    	  
	    	if((!(height==0))&&(!(power ==0))) {
		try{
			 height = Integer.valueOf(heightfield.getText()); 
		     power  =Integer.valueOf(powerfield.getText());	
		 
		 
		if(height<=0) {
			updatestandardmessage("le poids doit etre positif et non nul");
			/*throw new IllegalArgumentException("le poids doit etre positif et non nul ");
			
		}
		if(power<height) {
			updatestandardmessage("We need more power to take off the rocket");
		  /* throw new IllegalArgumentException("We need more power to take off the rocket");	
		
		}
		
		else {
			
			
			 position=trajectory(height,power);
		
		}
	
		}catch(NumberFormatException number){
			
			updatestandardmessage("please enter a number"); */
			/*System.out.println("please enter a number !");*/
			/*throw new NumberFormatException("please enter a number !"); 
		
			
		}
		
		}else{
		
			updatestandardmessage("the field is empty");
			throw new NumberFormatException("the field is empty!");	*/
			/*updatestandardmessage("the field is empty!");
			
		}
	      }
	    else {
	    	 
	    	 
	    	 throw new NumberFormatException("it is not a number");
	    	 
	    	 
	     }
	}
		
	 
	    
			// TODO Auto-generated method stub
		}			
		}
           */
       /*
		 private double getposition() {
			 
			 return position;
			 
		 }
	     */
/*
     public void setposistionx(int positionx) {
    	 
    	 
    	this.posistionx=positionx; 
    	 
     }

     public void setpositiony(int posistiony) {
    	 
    	this.positiony=posistiony; 
    	 
     }
*/
   public void paintcomponment(Graphics g) {
	   
	   g.setColor(Color.YELLOW);
	   g.drawLine(400, 150, posistionx, positiony);
	
	   
	   
   }

  
	   public static void main(String[]args) {

		   
			  new Lancement2("lancement");
			   
		   }	


}


