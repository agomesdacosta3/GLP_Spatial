package data;

public class Counter implements Counting {
	private int value;

	public Counter(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Counter [value=" + value + "]";
	}

	public int getValue() {
		return value;
	}
	
	protected void setValue(int value) {
		this.value = value;
	}

	public void increment() throws LimitReachedException {
		value++;
	}

	public void decrement() throws LimitReachedException {
		if (value > 0) {
			value--;
		} else {
			throw new LimitReachedException();
		}
	}

	public void init() {
		value = 0;
	}

}
