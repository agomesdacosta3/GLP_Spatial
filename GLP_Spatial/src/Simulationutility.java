package glp1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Simulationutility {
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
	public static void unitTime() {
		try {
			Thread.sleep(SimulInformation.SIMULATION_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	public static void marsUnitTime() {
		try {
			Thread.sleep(SimulInformation.SIMULATION_MARS_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void earthUnitTime() {
		try {
			Thread.sleep(SimulInformation.SIMULATION_EARTH_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	/**
	 * Simulated the necessary refresh time for avoiding printing issue.
	 */
	public static void windowRefreshTime() {
		try {
			Thread.sleep(SimulInformation.SIMULATION_SPEED * 10);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
}
