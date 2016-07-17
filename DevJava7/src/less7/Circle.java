package less7;

public class Circle implements RoundGeometric{

	private final double r;

	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double perimetr() {
		return 2*PI*r;
	}

	@Override
	public double square() {
		return PI*r*r;
	}
	
	
}
