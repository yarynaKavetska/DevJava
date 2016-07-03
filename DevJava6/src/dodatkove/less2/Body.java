package dodatkove.less2;

import dodatkove.less1.Color;

public class Body {

	private Color color;
	
	private Type type;
	
	private int year;

	public Body(Color color, Type type, int year) {
		this.color = color;
		this.type = type;
		this.year = year;
	}
	
	public void changeColor(Color color){
		if(color!=null)
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Body))
			return false;
		Body other = (Body) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Body [color=" + color + ", type=" + type + ", year=" + year
				+ "]";
	}
}
