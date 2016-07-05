package core.less14;

public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>();
		container.setElement("Hello");
		System.out.println(container.getElement());
		Container<Integer> container2 = new Container<>();
	}
	
	static void producer(Container<? super Number> container){
		container.setElement(new Integer(1));
	}
	
	static void consumer(Container<? extends Number> container){
		int i = container.getElement().intValue();
	}
}
