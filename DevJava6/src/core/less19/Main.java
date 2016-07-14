package core.less19;

import core.less5.Geometric;
import core.less5.Rectangle;

public class Main {

	public static void main(String[] args) {
//		Container container = new Container(5);
//		System.out.println(((String)container.getObject()).substring(0, 4));
		Container<String> container = new Container<>("Hello");
		System.out.println(container.getElement().substring(0, 4));
	}
	
	static void print(Container<? extends Geometric> container){
//		container.setElement(new Rectangle(15, 20));
	}
}
