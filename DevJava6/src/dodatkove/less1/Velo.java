package dodatkove.less1;

public class Velo {

	private Rama rama;
	
	private Wheel wheel;

	public Velo(Rama rama, Wheel wheel) {
		this.rama = rama;
		this.wheel = wheel;
	}

	public void changeColor(Color color) {
		rama.changeColor(color);
	}

	public void increaseDiametr(int value) {
		wheel.increaseDiametr(value);
	}

	public Rama getRama() {
		return rama;
	}

	public void setRama(Rama rama) {
		this.rama = rama;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Velo [rama=" + rama + ", wheel=" + wheel + "]";
	}
}
