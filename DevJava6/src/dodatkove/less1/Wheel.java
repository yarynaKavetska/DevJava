package dodatkove.less1;

public class Wheel {

	private int diametr;

	public Wheel(int diametr) {
		setDiametr(diametr);
	}
	
	public void increaseDiametr(int value){
		this.diametr+=value;
//		setDiametr(getDiametr()+value);
	}

	public int getDiametr() {
		return diametr;
	}

	public final void setDiametr(int diametr) {
		if(diametr<0)diametr=23;
		this.diametr = diametr;
	}

	@Override
	public String toString() {
		return "Wheel [diametr=" + diametr + "]";
	}
}
