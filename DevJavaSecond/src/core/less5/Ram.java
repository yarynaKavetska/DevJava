package core.less5;

public class Ram {

	private int capacity = 1024;

	public Ram() {
	}

	public Ram(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Ram [capacity=" + capacity + "]";
	}
}
