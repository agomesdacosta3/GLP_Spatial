
	package glp1;

	import java.awt.BorderLayout;
	import java.awt.Container;
	import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;







	public class EarthGUI extends JFrame implements Runnable {

		
	private SpaceBase space=new SpaceBase();
	private double earth_ray=6.525*Math.pow(10, 6);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(1000, 1000);
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(1000, 1000);
	 private String title;
	 private Sonde sonde=new Sonde();
	 private Counter chronometre=new Counter(0);
	 int t=chronometre.getValue();
	 private static final long serialVersionUID = 1L;
	 private int IHMADJUST=50000;
	 private EarthPanel earthPanel=new EarthPanel();
	 private JLabel positionxvalue  =earthPanel.getpositionxvalue();
     private JLabel positionxlabel = new JLabel("positionx (km)");
     private JLabel positionyvalue  =earthPanel.getpositionyvalue();
     private JLabel positionylabel = new JLabel("positiony (km)");
     private JLabel anglevalue =earthPanel.getanglevalue();
     private JLabel anglelabel = new JLabel("angle (radian)");
     private JLabel timevalue = earthPanel.gettimevalue();
     private JLabel timelabel = new JLabel("time (secondes)");
 	 private JPanel pan = new JPanel();
 	 private EarthGUI instance=this;
     
 	 
 	 private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
 	 public EarthGUI(String title) {
		this.title=title;
		/*init();*/
		/*earthPanel=new EarthPanel();*/
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
        
		space.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
	    contentPane.add(BorderLayout.CENTER, space);
		contentPane.add(BorderLayout.SOUTH, earthPanel);
		setSize(SimuPara.WINDOW_WIDTH, SimuPara.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		Thread chronoThread = new Thread(instance);
		chronoThread.start();
	
	
	}

	 private void init()  {
		    
		    pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		    Container contentPane = getContentPane();
			contentPane.setLayout(new BorderLayout());
		    
		    
		    
		    positionxlabel.setFont(font);
		    pan.add(positionxlabel);
		    
		    positionxvalue.setFont(font);
		    pan.add(positionxvalue);
		    
		    positionylabel.setFont(font);
		    pan.add(positionylabel);
		    
		    positionyvalue.setFont(font);
		    pan.add(positionyvalue);
		    
		    anglelabel.setFont(font);
		    pan.add(anglelabel);
		    
		    anglevalue.setFont(font);
		    pan.add(anglevalue);
		    
		    timelabel.setFont(font);
		    pan.add(timelabel);
		    
		    timevalue.setFont(font);
		    pan.add(timevalue);
		    
		    
		    contentPane.add(BorderLayout.SOUTH, pan);
		    space.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		    contentPane.add(BorderLayout.NORTH, space); 
		    setVisible(true);
		    setPreferredSize(IDEAL_MAIN_DIMENSION);
	        pack();
		
			setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	 

	 
	private void updatevalues() {
	
	double angle=sonde.rotativetrajectory(t);	 
	int positionx=(int)(earth_ray*Math.cos(sonde.rotativetrajectory(t)));	 
	int positiony=(int)(earth_ray*Math.sin(sonde.rotativetrajectory(t)));
	int positionx1=positionx/IHMADJUST;
	int positiony1=positiony/IHMADJUST;
	space.setpositionx(positionx1);
	space.setpositiony(positiony1);
	                                            
	anglevalue.setText(""+angle+""); 
	positionxvalue.setText(""+positionx+"");	 
	positionyvalue.setText(""+positiony+"");		 
	                                                                           
	
	}
		public static void main(String[] args) {

			new EarthGUI("marslaunch");

		}
		@Override
		public void run() {
		
		int time=0;	
			
			while(time<= SimulInformation.SIMULATION_EARTH_DURATION) {
			
			Simulationutility.earthUnitTime();	
				
			updatevalues();
			time++;
		    chronometre.increment();
		    
		    
		    
		    t=chronometre.getValue();
		   
		    timevalue.setText(""+t+"");   
		    space.repaint();
		
			/*System.out.println(""+t+"");*/
			// TODO Auto-generated method stub
			
		}
	}
}

