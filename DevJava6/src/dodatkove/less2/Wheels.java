package dodatkove.less2;

public class Wheels {

	private int diametr;
	
	private WheelType wheelType;

	public Wheels(int diametr, WheelType wheelType) {
		this.diametr = diametr;
		this.wheelType = wheelType;
	}
	
	public void changeWheels(Wheels wheels){
		if(!this.equals(wheels)){
			this.diametr = wheels.getDiametr();
			this.wheelType = wheels.getWheelType();
		}
	}

	public int getDiametr() {
		return diametr;
	}

	public void setDiametr(int diametr) {
		this.diametr = diametr;
	}

	public WheelType getWheelType() {
		return wheelType;
	}

	public void setWheelType(WheelType wheelType) {
		this.wheelType = wheelType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diametr;
		result = prime * result
				+ ((wheelType == null) ? 0 : wheelType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Wheels))
			return false;
		Wheels other = (Wheels) obj;
		if (diametr != other.diametr)
			return false;
		if (wheelType != other.wheelType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wheels [diametr=" + diametr + ", wheelType=" + wheelType + "]";
	}
}
