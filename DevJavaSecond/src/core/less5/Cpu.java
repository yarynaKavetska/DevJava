package core.less5;

public class Cpu {

	private int countOfCores = 1;
	
	private int MHz = 2;

	public Cpu() {
	}

	public Cpu(int countOfCores, int mHz) {
		this.countOfCores = countOfCores;
		MHz = mHz;
	}

	public void boost(){
		MHz += 1;
	}
	
	public int getCountOfCores() {
		return countOfCores;
	}

	public void setCountOfCores(int countOfCores) {
		this.countOfCores = countOfCores;
	}

	public int getMHz() {
		return MHz;
	}

	public void setMHz(int mHz) {
		MHz = mHz;
	}

	@Override
	public String toString() {
		return "Cpu [countOfCores=" + countOfCores + ", MHz=" + MHz + "]";
	}
}
