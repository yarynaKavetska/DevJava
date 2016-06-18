package dodatkove.less1;

public class Rama {

	private int size;
	
	private Color color;

	public Rama(int size, Color color) {
		this.size = size;
		this.color = color;
	}
	
	public void changeColor(Color color){
		this.color=color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Rama [size=" + size + ", color=" + color + "]";
	}
}
