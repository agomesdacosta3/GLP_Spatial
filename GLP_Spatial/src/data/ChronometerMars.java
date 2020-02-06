package data;

public class ChronometerMars extends ChronometerEarth {
	private Counting year;
	private Counting day;

	public ChronometerMars() {
		year = new CyclicCounter(0, 99);
		day = new CyclicCounter(0, 365);
	}

}
