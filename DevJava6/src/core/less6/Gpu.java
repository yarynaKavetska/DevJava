package core.less6;

public class Gpu {

	private final int capacity;
	
	private final int mHz;
	
	private Gpu gpu;

	public Gpu(int capacity, int mHz) {
		this.capacity = capacity;
		this.mHz = mHz;
	}

	public Gpu getGpu() {
		return gpu;
	}

	public void addGpu(Gpu gpu) {
		this.gpu = gpu;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getmHz() {
		return mHz;
	}

	@Override
	public String toString() {
		return "Gpu [capacity=" + capacity + ", mHz=" + mHz + ", gpu=" + gpu
				+ "]";
	}
}
