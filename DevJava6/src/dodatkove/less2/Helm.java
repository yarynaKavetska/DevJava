package dodatkove.less2;

public class Helm {

	private boolean haveButtons;
	
	private int diametr;

	public Helm(boolean haveButtons, int diametr) {
		this.haveButtons = haveButtons;
		this.diametr = diametr;
	}
	
	public void increase(){
		diametr++;
	}

	public boolean isHaveButtons() {
		return haveButtons;
	}

	public void setHaveButtons(boolean haveButtons) {
		this.haveButtons = haveButtons;
	}

	public int getDiametr() {
		return diametr;
	}

	public void setDiametr(int diametr) {
		this.diametr = diametr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diametr;
		result = prime * result + (haveButtons ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Helm))
			return false;
		Helm other = (Helm) obj;
		if (diametr != other.diametr)
			return false;
		if (haveButtons != other.haveButtons)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Helm [haveButtons=" + haveButtons + ", diametr=" + diametr
				+ "]";
	}
}
