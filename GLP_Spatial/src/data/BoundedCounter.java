package data ;

public class BoundedCounter extends Counter implements Counting {
	private int max;

	public BoundedCounter(int value, int max) {
		super(value);
		this.max = max;
	}

	@Override
	public void increment() throws LimitReachedException{
		if (getValue() < max) {
			super.increment();
		} else {
			throw new LimitReachedException();
		}
	}

	public int getMax() throws LimitReachedException{
		return max;
	}

}
