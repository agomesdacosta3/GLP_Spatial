package glp1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;





public class MarsGUI extends JFrame implements Runnable {

private static final long serialVersionUID = 1L;
private MarsDashboard marsdashboard=new MarsDashboard();
private Mars mars=new Mars();
 private MarsGUI instance=this;
 private Counter chrono=new Counter(0);
 int t=chrono.getValue();
 private int IHMADJUST=500000000;/* A unite IHM graphique 1000 000 000 m*/
	private double sun_mars_distance=55*Math.pow(10,9);/*m*/
	private double sun_earth_distance=1.496*Math.pow(10,11);/*m*/
	private double earth_ray=6.525*Math.pow(10, 6);/*m*/
	private double mars_ray=3.396*Math.pow(10,6);/*m*/
	private double sun_ray=6.525*Math.pow(10, 8);
    private double dearth=sun_ray+sun_earth_distance+earth_ray;
    private double dmars=sun_ray+sun_mars_distance+mars_ray;
    private JLabel earth_sun_distancevalue = marsdashboard.getearthsundistancevalue();
    private JLabel earth_sun_distancelabel = new JLabel("");
    private JLabel timevalue  = new JLabel("");
    private JLabel timevlabel = new JLabel("");
    private JLabel positionearthxvalue      = marsdashboard.getpositionearthxvalue();
    private JLabel positionearthxvlabel      = new JLabel("");
    private JLabel positionearthyvalue      = marsdashboard.getpositionearthyvalue();
    private JLabel positionmarsxlabel      = new JLabel("");
    private JLabel positiomarsylabel      = new JLabel("");
    private JLabel positionmarsxvalue      = new JLabel("");
    private JLabel positiomarsyvalue      = new JLabel("");
    private MarsGUI() {
	
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());
	
	contentPane.add(BorderLayout.CENTER, marsdashboard);	
	
	setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);
    
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
     
	Thread MarsThread = new Thread(instance);
	MarsThread.start();
	
	
}
  private void init() {
	  
	  
	  
	  
	  
	  
	  
  }
    
    
  private void updateValues(int t) {
	
	/* double postionxmars=mars.calculatepositionxmars(t); 
	 double postionymars=mars.calculatepositionymars(t);  
	 int postionxearthgui=(int)(mars.calculatepositionxearth(t));	
     */
	  
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
     int positionxmarsgui1=postionxmarsgui/IHMADJUST;
     int positionymarsgui1=postionymarsgui/IHMADJUST;
     int postionxearthgui1=postionxearthgui/IHMADJUST;;	
     int postionyearthgui1=postionyearthgui/IHMADJUST;;
     
     
     /* mars.setpositionx(postionxgui);*/	
     marsdashboard.setpositionxearth(positionxearthb);
     marsdashboard.setpositionyearth(positionyearthb);
     
     /*
     
     marsdashboard.setpositionx(positionxmarsgui1);
     marsdashboard.setpositiony(positionymarsgui1);
     
    
     /* mars.setpositionx(postionygui);	*/
   
	/* double resultx=mars.getpositionx();
	 double resulty=mars.getpositiony();*/
	
    System.out.println(" temps="+t1+"positionxearth="+positionxearthb+"  positionyearth="+positionyearthb+"dearth="+dearth+"xmars="+positionxmarsgui1+"ymars"+positionymarsgui1+" "); 
}
  
  
  
  
  
  
public static void main(String[] args) {

	new MarsGUI();

}
@Override
   public void run() {
	int time = 0;
	while (time <= SimulInformation.SIMULATION_MARS_DURATION) {
	 
	Simulationutility.unitTime();
	 chrono.increment();
     t=chrono.getValue();	
		
	 updateValues(t); 
	 double result= mars.calculatedistanceearthmars(t);
	 marsdashboard.repaint();
	 time++;
	
	 /*
	 System.out.println("t= "+t+"positionx= "+mars.calculatepositionxmars(t)+"positiony= "+mars.calculatepositionymars(t)+"distance="+result+"average=");
	 */
	
	}

	
	
  }
}
	


// TODO Auto-generated method stub
	

	
