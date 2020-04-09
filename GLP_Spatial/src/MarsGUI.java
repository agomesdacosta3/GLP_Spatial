package glp1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;





public class MarsGUI extends JFrame implements Runnable {

private static final long serialVersionUID = 1L;


private int valchoice;

private MarsDashboard marsdashboard=new MarsDashboard(valchoice);
private int valchoicedash=marsdashboard.getvalchoice();
private Mars mars=new Mars();
 private MarsGUI instance=this;
 private Counter chrono=new Counter(0);
 int t=chrono.getValue();
 private int IHMADJUST=1000000000;/* A unite IHM graphique 1000 000 000 m*/
 private int MARSIHMADJUST=1000000000;	   
 private double ROCKETUHMADJUST=5*Math.pow(10,16);
 private double sun_mars_distance=22794*Math.pow(10,7);/*m*/
	private double sun_earth_distance=149597870*Math.pow(10,3);/*m*/
	private double earth_ray=6.525*Math.pow(10, 6);/*m*/
	private double mars_ray=3.396*Math.pow(10,6);/*m*/
	private double sun_ray=6.525*Math.pow(10, 8);
    private double dearth=sun_ray+sun_earth_distance+earth_ray;
    private int t1=1000000*t;
    private double earth_marswithouth_ray=mars.calculatedistanceearthmars(t1);
    private double dmars=sun_ray+sun_mars_distance+mars_ray;
    private double dearth_mars=mars_ray+earth_ray+earth_marswithouth_ray;
    private JLabel earth_sun_distancevalue = marsdashboard.getearthsundistancevalue();
    private JLabel earth_sun_distancelabel = new JLabel("");
    private JLabel timevalue  = marsdashboard.gettimevalue();
    private JLabel timevlabel = new JLabel("");
    private JLabel positionearthxvalue      = marsdashboard.getpositionearthxvalue();
    private JLabel positionearthxvlabel      = new JLabel("");
    private JLabel positionearthyvalue      = marsdashboard.getpositionearthyvalue();
    private JLabel positionmarsxlabel      = new JLabel("");
    private JLabel positiomarsylabel      = new JLabel("");
    private JLabel positionmarsxvalue      = new JLabel("");
    private JLabel positiomarsyvalue      = new JLabel("");
    private int speed=10200;
    private int weight;
    private int power;
    
    
  
    
    public MarsGUI() {
	
 
    	
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());
	
	contentPane.add(BorderLayout.CENTER, marsdashboard);	
	
	setSize(SimuPara.WINDOW_MARS_WIDTH, SimuPara.WINDOW_MARS_HEIGHT);
    
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
     
	Thread MarsThread = new Thread(instance);
	MarsThread.start();
	
	
}

  
  public void landed() {
		
		if(((750+marsdashboard.getpositionxearth()+marsdashboard.getrocketpositionx())==(755+marsdashboard.getpositionxmars()))&&((390+marsdashboard.getpositionyearth()+marsdashboard.getrocketpositiony())==(390+marsdashboard.getpositionymars()))) {
			
			
		dispose();
		}	
  }

    
  
	private double angelradian(double angle) {
		
		
	return (2*Math.PI*angle)/360;	
		
	}
	
  
  private void updateValuesmars(int t) {
    	  
	  int t2=t*50000;
	  double angle=mars.marsrotativetrajectory(t2);
	
	  double positionmarsx=dmars*Math.cos(angle);
	  double positionmarsy=dmars*Math.sin(angle); 	  
	  double positionmarsxa=positionmarsx/MARSIHMADJUST;
	  double positionmarsya=positionmarsy/MARSIHMADJUST;
      int    positionmarsxb=(int)positionmarsxa;    
      int    positionmarsyb=(int)positionmarsya;    
	  
      
      marsdashboard.setpositionx(positionmarsxb);
      marsdashboard.setpositiony(positionmarsyb);
  
	
	
  }
    
  private void updateValues(int t) {
	
	
	  
	 int t1=1000000*t;
	 double positionxearth=dearth*Math.cos(mars.earthrotativetrajectory(t1));
	 double positionyearth=dearth*Math.sin(mars.earthrotativetrajectory(t1));
	 double positionxeartha=positionxearth/IHMADJUST;
	 double positionyeartha=positionyearth/IHMADJUST;		 
	 int positionxearthb=(int)positionxeartha;
	 int positionyearthb=(int)positionyeartha;
	
	 int postionxearthgui=/*(int)(mars.calculatepositionxearth(t));*/(int)(dearth*Math.cos(mars.earthrotativetrajectory(t1)));
     int postionyearthgui=/*(int)(mars.calculatepositionyearth(t));*/(int)(dearth*Math.sin(mars.earthrotativetrajectory(t1)));
     int postionxmarsgui=/*(int)(mars.calculatepositionxmars(t));*/	 (int)(dmars*Math.cos(mars.marsrotativetrajectory(t1)));
     int postionymarsgui=/*(int)(mars.calculatepositionymars(t));*/   (int)(dmars*Math.sin(mars.marsrotativetrajectory(t1)));
   
     int weight1 = marsdashboard.weightchoose();
     int power1  = marsdashboard.powerchoose();

     double positionrocketx=mars.calculatepositionxrocket( 5000000,500000,speed, t1);
     double positionrockety=mars.calculatepositionyrocket( 5000000,500000, speed, t1); 
 
     double positionxrocketa=positionrocketx/ROCKETUHMADJUST;
	 double positionyrocketa=positionrockety/ROCKETUHMADJUST;	
     
	 double simultated_distance=Math.sqrt(Math.pow(positionrocketx,2)+Math.pow(positionrockety,2) );
	 
	 
	 int positionxrocketb=(int)positionxrocketa;
	 int positionyrocketb=(int)positionyrocketa;
	 System.out.println("x="+positionrocketx+" y="+positionrockety+" t="+t1+"poids "+weight1+"puissance="+power1+"simultation="+simultated_distance+" distance terre mars "+dearth_mars+"");
	 
	 marsdashboard.setrocketpositionx(positionxrocketb);
	 marsdashboard.setrocketpositiony(positionyrocketb);
	 
     marsdashboard.setpositionxearth(positionxearthb);
     marsdashboard.setpositionyearth(positionyearthb);
     
     double positionxearthkm=positionxearth/1000;
     double positionyearthkm=positionyearth/1000;
     
     
     positionearthxvalue.setText(""+positionxearthkm+"km");
     positionearthyvalue.setText(""+positionyearthkm+"km");
     timevalue.setText(""+t1+"seconds");
     double result=mars.calculatedistanceearthmars(t);
	  int t2=t*1000000;
			  
			  
			  
	  double angle=mars.marsrotativetrajectory(t2);
	
	  double positionmarsx=dmars*Math.cos(angle);
	  double positionmarsy=dmars*Math.sin(angle); 	  
	  double positionmarsxa=positionmarsx/MARSIHMADJUST;
	  double positionmarsya=positionmarsy/MARSIHMADJUST;
      int    positionmarsxb=(int)positionmarsxa;    
      int    positionmarsyb=(int)positionmarsya;    
	  
     
     marsdashboard.setpositionx(positionmarsxb);
     marsdashboard.setpositiony(positionmarsyb);
     double speed=mars.getmarsangularspeed();
    /* System.out.println("temps"+t2+"x="+positionrocketx+"y="+positionrockety+"speed="+speed+"d terre mars"+dmars+"");
    */
  }
  
  
  
  
  
 
public static void main(String[] args) {
    
	new MarsGUI();

}
@Override
   public void run() {
	int time = 0;
	while (time <= SimulInformation.SIMULATION_MARS_DURATION) {
	 
	Simulationutility.marsUnitTime();
	 chrono.increment();
     t=chrono.getValue();	
		
	 updateValues(t); 
	 double result= mars.calculatedistanceearthmars(t);
	 marsdashboard.repaint();
	 time++;
	 landed();
	 /*
	 System.out.println("t= "+t+"positionx= "+mars.calculatepositionxmars(t)+"positiony= "+mars.calculatepositionymars(t)+"distance="+result+"average=");
	 */
	
	}

	
	
  }
}
	


// TODO Auto-generated method stub
	

	
