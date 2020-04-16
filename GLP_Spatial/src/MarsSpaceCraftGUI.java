package glp1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarsSpaceCraftGUI extends JFrame implements Runnable  {

	/*1 unité=193,79m*/
	private int valchoice;
	public MarsSpaceCraftGUI(int valchoice2) {
		valchoice=valchoice2;
	    init();	
		run();
		
		
	}
	
	
	private Chronometer chronometer=new Chronometer();
	private Point position = new Point(700,605);
	private int height=125;
	private int x = position.getX();
	private int y = position.getY();
   
	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");
	private JLabel secondLabel = new JLabel("Second:");
	private JLabel distanceLabel = new JLabel("elevation:");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");
	private MarsSpaceCraftDashboard dashboard = new MarsSpaceCraftDashboard(valchoice);
	private JLabel distanceValue= new JLabel("");  /*dashboard.getheightValue();*/
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 800);
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final int CHRONO_SPEED = 90;
    private static final long serialVersionUID = 1L;
	
	private int firstCounterValue = 0;
	private Counter acceleration = new Counter(firstCounterValue);
	private JPanel control = new JPanel();
	
	private void init() {
	updateValues();
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());
	
	control.setLayout(new FlowLayout(FlowLayout.CENTER));
	hourLabel.setFont(font);
	control.add(hourLabel);
	hourValue.setFont(font);
	control.add(hourValue);

	minuteLabel.setFont(font);
	control.add(minuteLabel);
	minuteValue.setFont(font);
	control.add(minuteValue);

	secondLabel.setFont(font);
	control.add(secondLabel);
	secondValue.setFont(font);
	control.add(secondValue);
	
	distanceLabel.setFont(font);
	control.add(distanceLabel);
	
	distanceValue.setFont(font);
	control.add(distanceValue);
	
	contentPane.add(BorderLayout.CENTER, dashboard);
	contentPane.add(BorderLayout.NORTH, control);
	setVisible(true);
	setPreferredSize(IDEAL_MAIN_DIMENSION);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	}

	
	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " "); 
                                                        
		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " "); 

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString() + " ");
		
		dashboard.setVal(valchoice);
		
		// The dashboard needs to be reprinted when hour, minute or second values change.
		dashboard.repaint(); 
	}
	
	private void updateValuesSpaceCraft() {
    int sec = acceleration.getValue();
    System.out.println(" "+sec+ "");
    dashboard.accelerationY(sec);
	dashboard.repaint();
    int y=dashboard.getY();
	
	
	
	}
	private boolean stop=false;
    
	private double calculateheight(double height,int y) {
		
	height+=-y*0.19379;	
	return height;	
			
	}
	
	
	private boolean stopSpaceCraft() {
	  int y=dashboard.gety();
	  double height=125;
	  System.out.println("y=" +y+  "");
	  System.out.println("height=" +height+  "");
	  double height1=calculateheight(height,y);
	  distanceValue.setText(""+height1+" km");
	  
	  if(y==645) {
	  stop=true;
	  distanceValue.setText(" 0 km");
	  }
	  else {
	  stop=false;
	  }
	  return stop;
    
	  
	
	}
	
	@Override
    public void run() {
		
		
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			acceleration.increment();
            
			CyclicCounter second = chronometer.getSecond(); 
			/*acceleration.increment();*/
			updateValuesSpaceCraft(); 
			System.out.println("time" +second+ "");
			 int y=dashboard.getY();
			
			// Ensure that the chronometer is not stopped during the iteration.
			if (!stop) {
				updateValues(); 
			
			}
            stopSpaceCraft();
			
		}

	
	}

	public static void main(String[] args) {
		
		int valchoice2=11111;
		new MarsSpaceCraftGUI(valchoice2);
		
	}








}
