package data;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		x = 0;
		y = 0;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws IllegalArgumentException {
		if (x >= -500 && x <= 500) {
			this.x = x;
		} else {
			throw new IllegalArgumentException("New x value " + x + " non authorized ");
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws IllegalArgumentException {
		if (y >= -500 && y <= 500) {
			this.y = y;
		} else {
			throw new IllegalArgumentException("New y value " + y + " non authorized ");
		}
	}

}
