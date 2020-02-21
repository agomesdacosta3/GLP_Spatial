package glp;

import java.util.Scanner;

public class TrajectoryEarth  {
   

	
	private int power;
	private int weight;
	 /*Progression progress = new Progression();*/
	public TrajectoryEarth(){
		
		
		
	}
	private Counter chrono= new Counter(0);
	private Counter spacechrono= new Counter(0);  
	 private  Counter getCounter() {
		 
		 return chrono;
		 
	 }
	
	
	 private int getpower() {
		 
	   return power;	 
	 }
	 
	 private int getweght() {
		 
		   return weight;	 
		 }
	   /* 
	    System.out.println("veuillez entrer la puissance de la fusée ");
	    String power1=sc.nextLine();
	    System.out.println("veuillez entrer le poids de la fusée ");
	    String weight1=sc.nextLine();
	  */
	    RocketEarth rocket=new RocketEarth(power,weight);
	    /*
	    System.out.println("veuillez entrer le poids de la fusée ");
	    sc.close();
	    */
	
    	    
   public void rotative(int power,int weight) {
	   RocketEarth rocket=new RocketEarth(power,weight);
	  
	   int  ti=spacechrono.getValue();
	    
	    double angle=rocket.rotativetrajectory(ti);
	    while(angle<100) {
	    	 spacechrono.increment();
	    	 ti=spacechrono.getValue();
	    	 angle=rocket.rotativetrajectory(ti);	
	    
	    
	    
	    	 System.out.println("temps="+ti+"angle de  "+angle+"");  
	   
	   
	    }
   
	    
			/*rocket.time()==false;*/
			System.out.println("il n' y a pas assez de rapport puissance/poids pour faire décoller la fusée");	
		
		
	   }
   public void launch(int power,int weight) {	    
	   RocketEarth rocket=new RocketEarth(power,weight);
	    try {
	    int t=chrono.getValue();
	    double result=rocket.trajectory(weight, power,t); 
	    while(result<120000) {
	   
	   
	    
	    
	     chrono.increment();
	     t=chrono.getValue();
	    result=rocket.trajectory(weight, power,t);
	     System.out.println("temps="+t+"le resutat est "+result+"");
	 
	    }
	    System.out.println("we are in the space");
	/*    int  ti=chrono.getValue();
	    
	    double angle=rocket.rotativetrajectory(ti);
	    while(angle<360*Math.pow(360,10)) {
	    	 chrono.increment();
	    	 ti=chrono.getValue();
	    	 angle=rocket.rotativetrajectory(ti);	
	    
	    
	    
	    System.out.println("temps="+ti+"angle de rotation "+angle+"");
	  */  
	    
	    /*
	     System.out.println("anle de rotation "+angle+"");
	    */
	    
	     }
	    
		catch(NotEngoughPowerException e) {
			/*rocket.time()==false;*/
			System.out.println("il n' y a pas assez de rapport puissance/poids pour faire décoller la fusée (c vrai)");	
		
		}
   }
   
   
   public void start(int power,int weight) {

	   TrajectoryEarth traj=new TrajectoryEarth();   
	final Thread t1=new Thread(){ 

   @Override
   public void run() { 
	  /* TrajectoryEarth traj=new TrajectoryEarth();*/	
   traj.launch(power, weight);	
   System.out.println("t1 se termine");
   	// TODO Auto-generated method stub
		
	}	    
  };
   t1.start();
  
  Thread  t2=new Thread() {
	  @Override
		public void run() { 
	    	
	 	try {
			t1.join();
			System.out.println("t2 commence");
			sleep(5000);
		/*	TrajectoryEarth traj=new TrajectoryEarth();*/
		    traj.rotative(power,weight);
			/* progress.lance_progress(5);*/
	 	} catch (InterruptedException e) {
		    
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	    	// TODO Auto-generated method stub
	 		
	 	
   	
    }
   	
   };
   
   t2.start();
   
   }
   

     
   
  }
  
	

