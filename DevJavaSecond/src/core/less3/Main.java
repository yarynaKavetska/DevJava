package core.less3;

public class Main {
	
	public static final int NORMAL_AGE_FOR_HUMAN = 12;

	public static void main(String[] args) {
		Human h = new Human();
		h.walk();
		h.setAge(10);
		int age = h.getAge();
		Object o = new Human();
		Hunter hunter = new Hunter();
		hunter.eatMeat("bird meat");
		hunter.walk();
		hunter.killMammont();
		System.out.println(h);
		System.out.println(hunter);
		Human human = new Hunter(NORMAL_AGE_FOR_HUMAN);
		System.out.println(human);
	}
}
