package core.less6;

public class Ram {

	private final int mHz;
	
	private int capacity;

	public Ram(int mHz, int capacity) {
		this.mHz = mHz;
		this.capacity = capacity;
	}
	
	public void addRam(Ram ram){
		if(ram.mHz == this.mHz){
			this.capacity+=ram.capacity;
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getmHz() {
		return mHz;
	}

	@Override
	public String toString() {
		return "Ram [mHz=" + mHz + ", capacity=" + capacity + "]";
	}
}
