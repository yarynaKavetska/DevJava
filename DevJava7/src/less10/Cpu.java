package less10;

public class Cpu {

	private double mHz;

	public Cpu(double mHz) {
		this.mHz = mHz;
	}
	
	public void raise(){
		mHz+=0.5;
	}

	public double getmHz() {
		return mHz;
	}

	public void setmHz(double mHz) {
		this.mHz = mHz;
	}

	@Override
	public String toString() {
		return "Cpu [mHz=" + mHz + "]";
	}
}
