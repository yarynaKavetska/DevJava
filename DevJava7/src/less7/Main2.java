package less7;

public class Main2 {

	public static void main(String[] args) {
		Geometric rectangle = new Rectangle(13, 15);
		print(rectangle);
		Geometric circle = new Circle(20);
		print(circle);
	}
	
	static void print(Geometric geometric){
		double perimetr = geometric.perimetr();
		double square = geometric.square();
		System.out.println("Square = "+square+" perimetr = "+perimetr);
	}
}
