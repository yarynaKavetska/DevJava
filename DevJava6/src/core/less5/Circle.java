package core.less5;

public class Circle implements RoundGeometric{

	private int r;

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public int perimetr() {
		return (int) (2*PI*r);
	}

	@Override
	public int square() {
		return (int) (PI*r*r);
	}
}
