package chrono;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Main GUI class for a succesful launch.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/

public class ChronometerGUI extends JFrame implements Runnable {
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(863, 750);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(863, 650);

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	/**
	 * The normal speed is 1000, e.q. one refresh per second (1000 milliseconds).
	 */
	private static int CHRONO_SPEED = 90;

	private static final long serialVersionUID = 1L;

	/**
	 * The core functional part : the chronometer.
	 */
	private Chronometer chronometer = new Chronometer();
	private int firstCounterValue = 170;
	private Counter acceleration = new Counter(firstCounterValue);

	private JButton startButton = new JButton(" Start Launch ");
	private JButton clearButton = new JButton(" Restart Launch ");

	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");
	private JLabel secondLabel = new JLabel("Second:");

	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");

	private JPanel control = new JPanel();

	/**
	 * This instance is used in the inner classes for different action listeners.
	 */
	private ChronometerGUI instance = this;

	/**
	 * Initial status of for the start button.
	 */
	private boolean stop = true;
	
	private int valchoice;
	
	public ChronometerGUI(String title, int newvalchoice) {
		super(title);
		valchoice = newvalchoice;
		init();
	}
	
	/**
	 * The dashboard part is managed in a separate class.
	 */

	private Dashboard dashboard = new Dashboard(valchoice,CHRONO_SPEED);

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

		startButton.setFont(font);
		startButton.addActionListener(new StartStopAction());
		control.add(startButton);

		clearButton.setFont(font);
		clearButton.addActionListener(new ClearAction());
		control.add(clearButton);

		contentPane.add(BorderLayout.NORTH, control);

		dashboard.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		contentPane.add(BorderLayout.SOUTH, dashboard);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(IDEAL_MAIN_DIMENSION);
		setResizable(false);
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
	
	private void updateValuesRocket() {
		int sec = acceleration.getValue();
		dashboard.accelerationY(sec);
		dashboard.repaint();
		System.out.println("The rocket's height at " + chronometer.getHourInt() + "hour " + chronometer.getMinuteInt() + "minute and " + chronometer.getSecondInt() + "second is " + dashboard.getValueY(sec));
	}
	
	private void updateValuesResetRocket() {
		dashboard.resetY();
		dashboard.repaint();
	}
 
	/**
	 * Defines what to do for each time unit (by default 1 second) : it increments the chronometer
	 */
	@Override
	public void run() {
		System.out.println("\nThe launch has begin\n");
		System.out.println("background code =" + valchoice);
		while (!stop) {
			try {
				if ((dashboard.setChronoSpeed()) != CHRONO_SPEED)  {
					CHRONO_SPEED = dashboard.setChronoSpeed() ;
				}
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			acceleration.increment();
			
			
			// Ensure that the chronometer is not stopped during the iteration.
			if (!stop) {
				updateValues();
				updateValuesRocket();
			}
			
			int sec = acceleration.getValue();
			
			if (dashboard.getValueY(sec) < -120) {
				stop = true ;
				dispose();
				/*
				if ((dashboard.ChooseType()) == 1) {
					EarthGUI earth = new EarthGUI();
        			earth.setVisible(true);
        		}
        		else if ((dashboard.ChooseType()) == 2) {
        			MarsGUI mars = new MarsGUI();
        			mars.setVisible(true);
        		}
        		*/
			}
		}
	}

	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Resume Launch ");
				System.out.println("\nThe launch has been paused\n");
			} else {
				stop = false;
				startButton.setText(" Pause the launch ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}

	private class ClearAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
			startButton.setText(" Start Launch");
			chronometer.init();
			acceleration.reset(firstCounterValue);
			updateValues();
			updateValuesResetRocket();
			System.out.println("\nThe launch has been reinitialized\n");			
		}
	}

	public static void main(String[] args) {
		int defaultvalchoice = 11111 ;
		new ChronometerGUI("Succesful launch",defaultvalchoice);
	}

}
