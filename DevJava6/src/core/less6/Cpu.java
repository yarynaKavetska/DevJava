package core.less6;

public class Cpu {

	private double mHz;
	
	private final int amountOfCores;

	public Cpu(double mHz, int amountOfCores) {
		this.mHz = mHz;
		this.amountOfCores = amountOfCores;
	}
	
	public void boost(){
		mHz+=0.7;
	}

	public double getmHz() {
		return mHz;
	}

	public void setmHz(double mHz) {
		this.mHz = mHz;
	}

	public int getAmountOfCores() {
		return amountOfCores;
	}

	@Override
	public String toString() {
		return "Cpu [mHz=" + mHz + ", amountOfCores=" + amountOfCores + "]";
	}
}
