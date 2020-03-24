package glp1;

import javax.swing.JPanel;

public class Mars   {

	
	private double earth_weight=5.794*Math.pow(10, 24);
	private double moon_weight=7.352*Math.pow(10, 22);
	private double mars_weight=6.39*Math.pow(10, 23);
	private double sun_weight=1.989*Math.pow(10, 30);
	
	private int Earth_Period=365;
	private int MARS_Period=780;
	private double Earth_Middle_LITTLE_AX=149598262;
	private double Earth_Middle_GREAT_AX=12231.03683;
	private double MARS_Middle_GREAT_AX=227943824;
	private double MARS_Middle_LITTLE_AX=226955940.2;
	private double universal_gravity_constant=6.67*Math.pow(10, -11);
	private double sun_mars_distance=55*Math.pow(10,9);/*m*/
	private double sun_earth_distance=1.496*Math.pow(10,11);/*m*/
	private double earth_ray=6.525*Math.pow(10, 6);/*m*/
	private double mars_ray=3.396*Math.pow(10,6);/*m*/
	private double sun_ray=6.525*Math.pow(10, 8);/*m*/
	
	public double rotativeearthspeed= Math.sqrt((universal_gravity_constant*sun_weight)/(sun_ray+sun_earth_distance+earth_ray));
	public double rotativemarsspeed= Math.sqrt((universal_gravity_constant*sun_weight)/(sun_ray+sun_mars_distance+mars_ray));
	public double earth_angular_speed=1.9923*Math.pow(10,-7);     /*rotativeearthspeed/(sun_ray+sun_earth_distance+earth_ray)*/;	
	public double mars_angular_speed=rotativeearthspeed/(sun_ray+sun_mars_distance+mars_ray);	
	private Counter chrono = new Counter(0);
	int t=chrono.getValue();
	private int positionx;
	private int positiony;
	
	
	  public double marsrotativetrajectory(int t) {
	    	
		    return (rotativemarsspeed/(sun_ray+sun_mars_distance+mars_ray))*t;	
		    	

	  }
	  public double earthrotativetrajectory(int t) {
	    	
		    return earth_angular_speed*t;	
		    	

	  }
	
	public double calculatepositionxearth(int t) {
	
	return Earth_Middle_LITTLE_AX*Math.cos((2*Math.PI/Earth_Period)*(t+Earth_Period));	
		
	}
  
	public double calculatepositionyearth(int t) {
		
		
	return Earth_Middle_GREAT_AX*Math.sin((2*Math.PI/Earth_Period)*(t+Earth_Period));
		
		
	}
    
	
	public double calculatepositionxmars(int t) {
		
		
	return MARS_Middle_LITTLE_AX*Math.sin((2*Math.PI/MARS_Period)*(t+MARS_Period));
		
		
	}
	
	public double calculatepositionymars(int t) {
		
		
	return MARS_Middle_GREAT_AX*Math.sin((2*Math.PI/MARS_Period)*(t+MARS_Period));
		
		
	}
	
	public double calculatedistanceearthmars(int t) {
		
		
	return Math.sqrt(Math.pow((calculatepositionxmars(t)-calculatepositionxearth(t)),2)+Math.pow((calculatepositionymars(t)-calculatepositionyearth(t)),2));	
		
	}
	
	public double calculatedistanceearthmarswithoutearth(int t) {
		
		
	return Math.sqrt(Math.pow((calculatepositionxmars(t)),2)+Math.pow((calculatepositionymars(t)),2));	
		
	}
	
	public double averageedistanceearthmars(int t) {
		
	     double average;
		double result=0;
	   while(t<100){
		
	 Simulationutility.earthUnitTime();	   
	  result+=Math.sqrt(Math.pow((calculatepositionxmars(t)),2)+Math.pow((calculatepositionymars(t)),2));	
		
	
	   
	  }
	   average=result/100;
	  return average;
	
	}
	
	
	
	
	
	public int getpositionx() {
		
	return positionx;	
		
	}
	public void setpositionx(int positionx) {
		
	this.positionx=positionx;	
		
	}
    
	public void setpositiony(int positiony) {
		
	this.positiony=positiony;	
		
	}
	
	public int getpositiony() {
		
	return positiony;	
		
	}
	
}
