package core.less5;

public class Main {

	public static void main(String[] args) {
		Bard bard = new Bard("Lutik");
		SimpleBallada simpleBallada = new SimpleBallada();
		bard.singingBallada(simpleBallada);
		System.out.println("boo-boo-boo!!!");
		HeroBallada heroBallada = new HeroBallada();
		bard.singingBallada(heroBallada);
		
		Geometric rectangle = new Rectangle(13, 20);
//		System.out.println("Perimetr = " + rectangle.perimetr());
//		System.out.println("Square = " + rectangle.square());
//		print(rectangle);
//		Geometric.print(rectangle);
		rectangle.print();
		Geometric circle = new Circle(15);
//		System.out.println("Perimetr = " + circle.perimetr());
//		System.out.println("Square = " + circle.square());
//		print(circle);
//		Geometric.print(circle);
		circle.print();
	}
	
//	static void print(Geometric geometric){
//		System.out.println("Perimetr = " + geometric.perimetr());
//		System.out.println("Square = " + geometric.square());
//	}
}
