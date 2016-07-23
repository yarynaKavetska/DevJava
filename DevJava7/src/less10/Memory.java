package less10;

public class Memory {

	private int gB;

	public Memory(int gB) {
		this.gB = gB;
	}

	public int getgB() {
		return gB;
	}

	public void setgB(int gB) {
		this.gB = gB;
	}

	@Override
	public String toString() {
		return "Memory [gB=" + gB + "]";
	}
}
