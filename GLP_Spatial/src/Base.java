package glp1;



	
	import java.awt.Font;
	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import glp1.Rocket;

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import glp1.Simulation;
import glp1.Simulationutility;

import glp1.RocketManager;


	public class Base extends JPanel   {
		/*Simulation simulation=new Simulation(/*rocketmanager,false);*/
		private JTextField weightfield = new JTextField(10);
		private JTextField powerfield = new JTextField(10);
		private ArrayList<RocketManager> lancements=new ArrayList<RocketManager>();
	    private JLabel startlabel;
	    private JLabel speedlabel;
	    private JLabel heightlabel;
	    private JLabel powerlabel;
	    private JLabel imagelbl;
	    /*private ImageIcon photo;*/
		private Counter chrono = new Counter(0);
		private int t = chrono.getValue();  
		Simulationutility simulationutility=new Simulationutility();
	    private JButton powerboutton;
	    private JButton heightboutton;
	
	    private int positionx=0;
		private int positiony=0;
	    private int INITIAL_POSITIONY = 650;
	    private JPanel pan=new JPanel();
		private JButton startboutton = new JButton("start");
	    private static final long serialVersionUID = 1L;
   /*     private 		boolean run=simulation.isRunning();	  
	    /*Timer tm =new Timer(5,this);*/
		
	  

	    public JButton getstartboutton() {
	    	
	    	return startboutton;
	    }
	    public JTextField getweightfield() {
	    	
	    	return weightfield;
	    	
	    }
	    public JTextField getpowerfield() {
	    	
	    	return powerfield;
	    	
	    }
	    
	    /*
	    public void proprietebase() {
	    
	    	this.setLayout(null);
	    	/*this.start();
	    	this.speed();
	    	this.height();
	    	this.power();*/
	    	/*
	    	this.initaction();
	    }*/
		
	    public JLabel getimagelbl() {
	    	
	    	return imagelbl;
	    }
        
	    /*
	    public void initaction() {
	    	startboutton.addActionListener(new StartAction());
	    	
	    }*/

	    private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
		public void paintComponent(Graphics g) {
	        
			super.paintComponent(g);
			
			/*int positiony=rocket.getpositiony();*/
			/*g.setColor(Color.BLUE);
			g.drawLine(10, 90,300,200);*/
			
			
			
	      /* méthode à utiliser*/
			
	     /*  g.drawImage(Simulationutility.readImage("glp1/fusee2.jpg"),700,INITIAL_POSITIONY,100,151,null);*/
	       	Graphics2D g2 = (Graphics2D) g;
	    	
	       	printLine(g2);
		 
			/* tm.start();*/
		}
		  RocketManager rocketmanager1=new RocketManager(false);
		
	/*	 
	private class StartAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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
	           */
			   
	            
	          
	            /*lancements.add(rocketmanager);*/
	            /*rocketmanager.run();
	            RocketManager rocketmanager1=new RocketManager(true);
	            lancements.add(rocketmanager1);
	            System.out.println("run ou pas?="+rocketmanager1.isRunning()+"positiony="+positiony+"");
	            simulation.launch(weight, power);
	    	
	            Iterator<RocketEarth> iterator = simulation.getRockets().iterator();
	           /* TestLancement2 test=new TestLancement2();*/
	    		/*
	    		while(iterator.hasNext()) {
	    			RocketEarth rocket=iterator.next();
	            
	                repaint();
	            
	    		}*/
				
	            /* updatevalues(weight, power);
			    
	            resfresh();
			} catch (NotEngoughPowerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   }
		}*/
		
		
		private void resfresh() {
			
			
		for(t=0;t<20000;t++) {	
			repaint();		
		  }
		}
		private void printLine(Graphics2D g2) {
		    
			
			
		
			
		
		RocketManager rocketmanager=new RocketManager(false);
		lancements.add(rocketmanager);
		g2.drawImage(Simulationutility.readImage("glp1/fusee2.jpg"),700,INITIAL_POSITIONY-positiony,75,100,null);
	/*	Simulation simulation=new Simulation(/*rocketmanager,false);*/
	  /*	g2.drawImage(Simulationutility.readImage("glp1/fusee2.jpg"),700,INITIAL_POSITIONY-positiony,100,151,null);
	   
		
	 	/*for(RocketManager manager1:simulation.getLancements()) {µ*/ 
		    
	/*manager1.isRunning();*/	

	    	
	 	
	 	/*}*/
/*	for(RocketManager manager1:simulation.getLancements()) {*/ 
	    /*
		
		int positionx=manager1.getRocket().getpositionx() ;
		int positiony=manager1.getRocket().getpositiony() ;
		*/
	/*	boolean run=manager1.isRunning();	*/
	/*	final Thread t1=new Thread(){ 
		
		};t1.start();
	
		Thread  t2=new Thread(){
            @Override
			public void run() {*/
        	
            
           /*try{*/
      /*  	 t1.join();
        	sleep(15000);*/
      	  /*
        	Iterator<RocketManager> iterator1 = lancements.iterator();
	
        	
        	
      for(int i=0;i<lancements.size();i++) {  	
       /*   while(iterator1.hasNext()) {
     
    	RocketManager rocketmanager2=lancements.get(i);/*iterator1.next();*/
    	/*for(RocketManager rocketmanager2:lancements) {*/
		/* System.out.println("run ou pas?="+rocketmanager2.isRunning()+"positiony="+positiony+"");*/
	/*if( rocketmanager2.isRunning()/*manager1.isRunning()) {	*/
		/*System.out.println("run ou pas?="+rocketmanager2.isRunning()+"");	
		
			System.out.println("positiony poulet au curry="+positiony+"");
				
		Iterator<RocketEarth> iterator = simulation.getRockets().iterator();
		while(iterator.hasNext()) {
			Simulationutility.unitTime();
			RocketEarth rocket=iterator.next();
		/*for(RocketEarth rocket:simulation.getRockets()) {
			
			       int positiony=rocket.getpositiony();/* méthode à utiliser
					int x=151;
			       
			      
			       
			       	g2.drawImage(Simulationutility.readImage("glp1/fusee2.jpg"),700,INITIAL_POSITIONY-positiony,100,151,null);
			       /*	repaint();		
			       	System.out.println("positiony="+positiony+"");
			     
			 /*}*/
     	
		  /* }*/
		 
		 /* }*/  
		
	      }
	 /* }*/
	
        	/* }*/
    /*  }
    }
      /*   /*}
        catch(InterruptedException e) {
        	 
        	e.printStackTrace(); 
        	 
         }
            }
		  };t2.start();	*/

		  
		  /*
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
		*//*
		public int getposistionx() {
			
		 return positionx;	
			
		} 
		
		public int getpositiony() {
			
			
		return INITIAL_POSITIONY;	
			
		}
		
		public void setpositionx(int positionx) {
			
		this.positionx=positionx;	
			
		}
		*/
		public int getpositiony() {
			
		return positiony;	
			
		}
		public void setpositiony(int positiony) {
			
		this.positiony=positiony;	
			
			
		}

         
		
		
		}	
		

		


	
