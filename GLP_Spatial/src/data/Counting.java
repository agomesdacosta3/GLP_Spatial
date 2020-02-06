package data;

public interface Counting {
	void increment() throws LimitReachedException;

	void decrement() throws LimitReachedException;

	int getValue();
}
