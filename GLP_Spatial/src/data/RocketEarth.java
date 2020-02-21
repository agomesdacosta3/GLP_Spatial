package glp;

public class RocketEarth extends Rocket  {
	private int weight ;
	private int speed ;
	private int power ;
    private double gravity_intensity=9.81;
	private double universal_gravity_constant=6.67*Math.pow(10, -11);
    private double earth_weight=5.794*Math.pow(10, 24);
	private double earth_ray=6.525*Math.pow(10, 3);
	private double space_altitude=120*Math.pow(10, 3);
	Chronometer chrono=new Chronometer();
	private int t=chrono.getSecond().getValue();
	public double getgravity_intensity() {
		
		return gravity_intensity;
		
	}
	public int gett() {
		
		return t;
	}
	
	public RocketEarth(int weight/*,int speed*/,int power) {
	 
		super(weight/*,speed*/, power);
		
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean time() {
	int max=20;	
    if(gett()<max) {
    	
    return true;	 
    }
    else {
    	
    return false;	
    	
    }
		
	}
    public double trajectory(int height,int power,int t) throws NotEngoughPowerException {
    
    if((power/height)<getgravity_intensity()) {
    	
    throw new NotEngoughPowerException("le rapport entre la puissance d la fusée et son poids est trop faible"); 	
    }
    	
 
    
     return (((power/height-getgravity_intensity())*Math.pow(t,2.0)))/2;
    	
    
    
    }
    
    
   
    public double rotativespeed= Math.sqrt((universal_gravity_constant*earth_weight)/(earth_ray+space_altitude));
    public double angular_speed=rotativespeed/(earth_ray+space_altitude);	
    
    public double getangular_speed() {
    	
    	
    return angular_speed;	
    	
    }
    
    
    public double getrotativespeed() {
    	
    	
    return rotativespeed;	
    	
    }
    
    
    public double rotativetrajectory(int t) {
    	
    return (rotativespeed/(earth_ray+space_altitude))*t;	
    	
    }
    		
    		
   		
    	
    
	public String toString() {
		
		
	return "";	
		
	}


	
		// TODO Auto-generated method stub
		

	
}
