package glp1;

public class Sonde {
	
	
	private double earth_ray=6.525*Math.pow(10, 6);
	private double space_altitude=120*Math.pow(10, 3);
    private double earth_weight=5.794*Math.pow(10, 24);
	  private double gravity_intensity=9.81;
		private double universal_gravity_constant=6.67*Math.pow(10, -11);	
	  public double rotativespeed= Math.sqrt((universal_gravity_constant*earth_weight)/(earth_ray+space_altitude));
	  public double angular_speed=rotativespeed/(earth_ray+space_altitude);	
	  private int positionx; 
	  private int positiony; 
	
	
	
    public double rotativetrajectory(int t) {
    	
    return (rotativespeed/(earth_ray+space_altitude))*t;	
    	
    }
	
	public int getpositionx() {
		
		
	return positionx;	
		
		
	}

	
	public void setpositiony(int positiony) {
		
		
	this.positiony=positiony;	
		
	}
	
	public void setpositionx(int positionx) {
		
		
	this.positionx=positionx;	
		
		
	}
	
	
	public int getpositiony() {
		
		
		return positiony;	
			
			
	}
    
    
}
