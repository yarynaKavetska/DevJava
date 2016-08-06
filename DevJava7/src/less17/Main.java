package less17;

import less7.Geometric;
import less7.Rectangle;

public class Main {

	public static void main(String[] args) {
		Container<Geometric> container = 
				new Container<>(new Rectangle(13, 15));
		consumer(container);
	}
	
	public static void consumer(Container<? extends Geometric> element){
		System.out.println(element.getElement().perimetr());
		System.out.println(element.getElement().square());
	}
	
	public static void producer(Container<? super Geometric> element) {
		Rectangle rectangle = new Rectangle(13, 15);
		element.setElement(rectangle);
	}
}