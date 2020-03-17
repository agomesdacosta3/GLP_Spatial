package glp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;





public class Simulation extends Thread {

	
	
	private Counter chrono = new Counter(0);
	private int t = chrono.getValue();  
	private ArrayList<RocketManager> lancements=new ArrayList<RocketManager>();
    private CopyOnWriteArrayList<Counter>temps=new CopyOnWriteArrayList<Counter>();	

	private boolean running=false;
	private CopyOnWriteArrayList<RocketEarth> rockets = new CopyOnWriteArrayList<RocketEarth>();
	int position=0;
    private String title;
    private Base base=new Base();
    private RocketManager rocket;
	public Simulation(/*RocketManager rocket,*/boolean running) {
	this.running=running; 
	
	rocket=new RocketManager(running );
		
		
		
	}
	

	
	public Base getbase() {
		
		return base;
		
	}
	
	public CopyOnWriteArrayList<Counter> gettemps() {
		
		return temps;
		
	}
	public RocketManager getrocket() {
		
		
		return rocket;
	}
	
    public void initialposition() {
    	
    	
    	
    	RocketEarth rocket1=new RocketEarth(0,0,100,151);
		
		
		RocketManager manager=new RocketManager(/*rocket1,*/false);
		
		
		
		lancements.add(manager);
    }
		
	public void launch(int height,int power) throws NotEngoughPowerException {	
	/*	startallrockets();*/
		
    RocketEarth rocket = new RocketEarth(height, power,700,300);
		
		
		
		/*final Thread t1=new Thread(){ 

			   @Override
			   public void run() { 
				  /* TrajectoryEarth traj=new TrajectoryEarth();	
	
			   	// TODO Auto-generated method stub
					try{*/
					double result;

					result = rocket.trajectory(height, power, t);	
		
		
		while(result<600) {
			
    rocket.setpositiony((int) (result));   
/*    Lancement2 launch=new Lancement2("launch");
*/	/*Simulationutility.unitTime();*/
	t = chrono.getValue();
	/*System.out.println("temps " + t + "le résultat est " + result + "");
	*/
	Counter chrono1=new Counter(t);
	chrono1.setValue(t);
	temps.add(chrono1);
	result = (int) (rocket.trajectory(height, power, t));
	  rocket.setpositiony((int) (result));  
	
	int result1=(int)(result);
	RocketEarth rocket1 = new RocketEarth(height, power,700,result1);	

  
    /*int positiony=rocket1.getpositiony();*/
	/*System.out.println("positiony="+positiony+"");*/
	rockets.add(rocket1);
	/*lancements.add(manager);*/
	chrono.increment();    
	base.setpositiony((int) (result));  
	/*base.repaint();
	*/
	
	
	}
				/*	}catch(NotEngoughPowerException e){
		
	System.out.println("pas assez de puissance");	
		
	}*/
	
	}
		/*}	    
	  };
	  t1.start();
	*/
 
/*	
public void startallrockets() {
	Lancement2 lancement=new Lancement2("lancement");
	Thread lancementTread = new Thread(lancement);
	lancementTread.start();
	
	
	
}*/

		
		
	

public boolean isRunning() {
	return running;
}




public void setRunning(boolean running) {
	this.running = running;
}	


	public CopyOnWriteArrayList<RocketEarth> getRockets() {
		return rockets;
	}
	public ArrayList<RocketManager> getLancements() {
		return lancements;
	}



}