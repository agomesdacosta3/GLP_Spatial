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
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import glp1.Counter;
import glp1.NotEngoughPowerException;
import glp1.RocketEarth;
import glp1.Simulationutility;
import glp1.TrajectoryEarth;





public class Lancement2 extends JFrame implements Runnable  {

	private Counter chrono = new Counter(0);
	private int t = chrono.getValue();  
	
	private String title;
	private ArrayList<RocketManager> lancements=new ArrayList<RocketManager>();
	

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 800);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(600, 750);
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 20);

	Simulationutility simulationutility=new Simulationutility();

	/*private int posistionx = base.getposistionx();
	private int positiony = base.getpositiony();
    */
	private ArrayList<RocketEarth> rockets = new ArrayList<RocketEarth>();
	private JLabel startlabel = new JLabel("start");
	private JLabel speedlabel = new JLabel("speed");
	private JLabel heightlabel = new JLabel("weight (tonnes)");
	private JLabel powerlabel = new JLabel("power (k newton)");

	private JLabel speedvalue = new JLabel("");
	private JLabel heightvalue = new JLabel("");
	private JLabel imagelbl;
	/*private ImageIcon photo;*/
	
	private JButton startboutton =new JButton("Start");/*base.getstartboutton();*/
	
	/*
	 * private JButton powerboutton=new JButton("power"); private JButton
	 * heightboutton=new JButton("height");
	 */
	
/*
	public void initactions() {
		startboutton.addActionListener(new StartAction()); /*{
			@Override
			public void actionPerformed(ActionEvent e) {

				String power1 = powerfield.getText();
				String weight1 = weightfield.getText();

				int power = Integer.valueOf(power1);
				int weight = Integer.valueOf(weight1);

				TrajectoryEarth traj = new TrajectoryEarth();

				try {
					updatevalues(weight, power);
				} catch (NotEngoughPowerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});*/

	/*}*/

	private Lancement2 instance = this;
    private RocketManager rocketmanager=new RocketManager(/*rocket,*/false);
    private Simulation simulation=new Simulation(/*rocketmanager,*/false);
	private Base base = simulation.getbase();
	private JLabel messagelabel = new JLabel("everything is OK!");
	private JLabel timeValue = new JLabel("0");
	private JLabel timeLabel= new JLabel("temps (en secondes)"); 
	private JLabel positionValue=new JLabel("0");
	private JLabel positionLabel=new JLabel("position en (metres)");
	private JTextField weightfield =base.getweightfield();
	private JTextField powerfield = base.getpowerfield();
	private JPanel pan = new JPanel();
	private JPanel pan1 = new JPanel();
	private int height = 10;
	private int power = 1000;/* Integer.valueOf(powerfield.getText() ); */

	private String weight1 = weightfield.getText();
	private String power1 = powerfield.getText();

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

	public ArrayList<RocketEarth> getRockets() {
		return rockets;
	}
	public Lancement2(String title) {

		this.title=title;
		try {
            
			initAction(); 
			
			init();
		} catch (NotEngoughPowerException e) {

			System.out.println("pas assez de puissance");

		}
	}
	
	
	private void initAction() {
		
		startboutton.addActionListener(new StartAction());
		
		
	}
	
/*{
			@Override
			public void actionPerformed(ActionEvent e) {

				String power1 = powerfield.getText();
				String weight1 = weightfield.getText();

				int power = Integer.valueOf(power1);
				int weight = Integer.valueOf(weight1);

				TrajectoryEarth traj = new TrajectoryEarth();

				try {
					updatevalues(weight, power);
				} catch (NotEngoughPowerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});*/

private boolean stop=true;
private class StartAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String power1 = powerfield.getText();
		String weight1 = weightfield.getText();

		int power = Integer.valueOf(power1);
		int weight = Integer.valueOf(weight1);

		/*TrajectoryEarth traj = new TrajectoryEarth();*/

		try {
			/*
		    simulation.initialposition();
			ArrayList<RocketManager> lancements=simulation.getLancements();
			*//*
            RocketEarth rocket=new RocketEarth(weight,power,100,151);
            RocketManager rocketmanager=new RocketManager(/*rocket,true);
            Simulation simulation=new Simulation(rocketmanager);
          */
            /*
            simulation.startallrockets();
           */
		   
            
          
            /*lancements.add(rocketmanager);*/
            /*rocketmanager.run();*/
			if(!stop) {
			stop=true;
			/*startboutton.setText(" Start ");*/	
				
			}
			else {
				
				
            RocketManager rocketmanager1=new RocketManager(true);
            lancements.add(rocketmanager1);
            stop=false;
            /*startboutton.setText(" Stop ");*/
        	
        	Thread Lancement2Thread = new Thread(instance);
        	Lancement2Thread.start();
        	
            System.out.println("run ou pas?="+rocketmanager1.isRunning()+"positiony=");
           simulation.launch(weight, power);
            
            
            t = chrono.getValue(); 
             /*updatevalues(weight,  power);*/
            Iterator<RocketEarth> iterator = simulation.getRockets().iterator();
			}
            
            
            /*  updatevalues();
            
            /* TestLancement2 test=new TestLancement2();*/
    		/*
    		while(iterator.hasNext()) {
    			RocketEarth rocket=iterator.next();
            
                repaint();
            
    		}*/
			
            /* updatevalues(weight, power);*/
		    
            
		} catch (NotEngoughPowerException e1) {
			// TODO Auto-generated catch block
			updatestandardmessage("not enough power !");
		
		}
	   }
	}
   /*
	private class StartAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String power1 = powerfield.getText();
			String weight1 = weightfield.getText();

			int power = Integer.valueOf(power1);
			int weight = Integer.valueOf(weight1);

			/*TrajectoryEarth traj = new TrajectoryEarth();

			try {
				/*
			    simulation.initialposition();
				ArrayList<RocketManager> lancements=simulation.getLancements();
				*//*
	            RocketEarth rocket=new RocketEarth(weight,power,100,151);
	            RocketManager rocketmanager=new RocketManager(/*rocket,true);
                Simulation simulation=new Simulation(rocketmanager);
	          */
	            /*
	            simulation.startallrockets();
	           
	            simulation.setRunning(true);
	            
	            /*lancements.add(rocketmanager);
	            rocketmanager.run();
	            updatevalues(weight, power);
			    
			
			} catch (NotEngoughPowerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
    
	
	
	}*/
	
	/*
	private void initAction() {
		startboutton.addActionListener(new StartAction());
	}*/

	private void init() throws NotEngoughPowerException {

		
		
		
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		pan1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		/*
		 * this.start(); this.speed(); this.height();
		 */
		/*
		 * this.power();
		 * 
		 
		 */
		
		timeLabel.setFont(font1);
		pan1.add(timeLabel);
		
		
        timeValue.setFont(font1);
        pan1.add(timeValue);
        
        
        positionLabel.setFont(font1);
        pan1.add(positionLabel);
        positionValue.setFont(font1);
		pan1.add(positionValue);
		
        startlabel.setFont(font);
		pan.add(startlabel);

		speedlabel.setFont(font);
		pan.add(speedlabel);

		speedvalue.setFont(font);
		pan.add(speedvalue);
		/*
		 * this.base.afficheimage(); /* imagelbl.setFont(font1); pan.add(imagelbl);
		 */

		messagelabel.setFont(font);
		pan.add(messagelabel);
		/*
		 * powerboutton.setFont(font); powerboutton.addActionListener(new PowerAction()
		 * ); pan.add(powerboutton);
		 * 
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
        contentPane.add(BorderLayout.WEST,pan1);
		contentPane.add(BorderLayout.SOUTH, pan);
         
		base.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		contentPane.add(BorderLayout.NORTH, base);
         
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	    
		pack();

	
	
	}

	public class Addpoweraction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String power = powerfield.getText();
		}

	}

	public class Addheightaction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String height = weightfield.getText();

		}

	}
	/*
	 * private void afficheimage() {
	 * 
	 * imagelbl= new JLabel(); photo=new ImageIcon("image/fusee2.jpg");
	 * 
	 * 
	 * this.imagelbl.setBounds(posistionx, positiony,500,500);
	 * this.imagelbl.setIcon(photo); this.add(imagelbl); }
	 */
     
	private void updatevalues() {
		
		
	   /* RocketEarth rocket = new RocketEarth(weight, power,700,300);
		*/
		
		
		Iterator<RocketEarth> iterator = simulation.getRockets().iterator();
		Iterator<Counter> iterator1 = simulation.gettemps().iterator();
		while(iterator.hasNext()) {	
		  while(iterator1.hasNext()) {
			
			/*for(RocketEarth rocket:simulation.getRockets()) {*/
			       Simulationutility.unitTime();
			       RocketEarth rocket=iterator.next();
					Counter chrono=iterator1.next();
			       int result=rocket.getpositiony();
			       int time=chrono.getValue();
					int time1=(int)(time*4.45);
					int result1=result*200;
			       base.setpositiony(result);
			      
		           
			       
			      
			       positionValue.setText(""+result1+"");
			       timeValue.setText(""+time1+"");       
			       base.repaint();
			   
		      }
		        
		   }
		  if(base.getpositiony()>600) {
			  dispose();	
			  System.out.println(""+base.getpositiony()+"");
		    	 EarthGUI earth=new EarthGUI("earthlaunch");
		           earth.setVisible(true);
				   earth.run();
		    	
		    	
		     }
		       
			
			
		
		/*}*/		
		}
	
	    private void changegui() {
	    	
	    if(base.getpositiony()==600) {
	    	System.out.println(""+base.getpositiony()+"");
	    	/* MarsGUI earth=new MarsGUI("marslaunch");
	           earth.setVisible(true);
			   dispose();*/	
	    	
	    	
	     }
	    	
	    }
	
	
	
	     @Override
	     public void run() {
	    
	    	 while(!stop) {
	 	 

	    		 chrono.increment();
	    	
	    		 updatevalues();
	    		
	    		 /* System.out.println("temps " + t + "");
	    /*	updatevalues();*/
	     /* base.repaint();	 
	    	*/ 
	           	 
	    	 }	 
	         
	     
	     
	  }
	
	
	
			/*final Thread t1=new Thread(){ 

				   @Override
				   public void run() { 
					  /* TrajectoryEarth traj=new TrajectoryEarth();	
		
				   	// TODO Auto-generated method stub
						try{*/
					/*	double result;
                           
						result = rocket.trajectory(weight, power, t);	
			
			
			while(result<600) {
				
				   
  
	/*    Lancement2 launch=new Lancement2("launch");
	*	
		t = chrono.getValue();
		System.out.println("temps " + t + "le résultat est " + result + "");
		
		
		result = (int) (rocket.trajectory(weight, power, t));
		  base.setpositiony((int) (result));  
			
			base.repaint();
			chrono.increment();
				
		}
	}
		/*
		Iterator<RocketEarth> iterator = simulation.getRockets().iterator();
		while(iterator.hasNext()) {	
			RocketEarth rocket=iterator.next();
		for(RocketEarth rocket:simulation.getRockets()) {
			      
			       int result=rocket.getpositiony();
			       base.setpositiony(result);
			       base.repaint();
		
		  System.out.println("positiony="+result+"");
		
		}		
		}
	 */
	
	
	
	private void updatevalues(int height, int power) throws NotEngoughPowerException {
        
		RocketEarth rocket = new RocketEarth(height, power,700,300);
		
		
		double result;

		result = rocket.trajectory(height, power, t);
      
		/*while (result < 600) {*//*
								 * une unité dans l' interface représente deux km dans la vraie vie 1 seconde
								 * dans l' IHM correspond à 14,05 s dans la vie
								 
*/
	
			/*rocket.setpositiony((int) (result));
			
			base.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
			contentPane.add(BorderLayout.NORTH, base);
              
			/*
			 * base.afficheimage();
			
              */ 
			
			t = chrono.getValue();
			System.out.println("temps " + t + "le résultat est " + result + "");
			result = (int) (rocket.trajectory(height, power, t));
			
			
			int result1=(int)(result);
			base.setpositiony(result1);
			base.repaint();
			/*
			RocketEarth rocket1 = new RocketEarth(height, power,700,result1);	
			rockets.add(rocket1);
			*/
		/*}*/
		
	}	
	    /*   RocketManager rocketmanager=new RocketManager(true);
		 
		
		   simulation.launch(height, power);
			
	       for(RocketEarth rocket:simulation.getRockets()) {
	    	int result=rocket.getpositiony();
	    	base.setpositiony(result);
	    	base.repaint();
			
	       
	            System.out.println("result="+result+"");
	       }*/
	       /*chrono.increment();*/
			
		/*}
		Simulationutility.windowRefreshTime();
		updatestandardmessage("we are in the space");
	}
      */
	private void updatestandardmessage(String message) {
		// TODO Auto-generated method stub
		messagelabel.setText(message);
	}

	private static final long serialVersionUID = 1L;

	public double trajectory(int height, int power) {
		return ((power / height) * Math.pow(t, 2.0)) / 2 ;
	}
    



	public static void main(String[] args) {

		new Lancement2("lancement");

	}

}



