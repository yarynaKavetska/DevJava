package core.less6;

public class Ssd {

	private final int capacity;

	public Ssd(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return "Ssd [capacity=" + capacity + "]";
	}
}
