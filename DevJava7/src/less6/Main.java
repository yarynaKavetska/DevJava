package less6;

public class Main {

	public static void main(String[] args) {
		Human.go();
		Hunter.go();
		System.out.println(Human.CLASS_NAME);
//		System.out.println(Human.countOfHumans);
		final Human human = new Human("Ivan");
		human.run();
		human.setAge(-20);
//		human.setName("Ivan");
		int age = human.getAge();
		String name = human.getName();
		Hunter hunter = new Hunter("Petro");
		hunter.run();
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		hunter.eatMeat();
		System.out.println(human);
		System.out.println(hunter);
		System.out.println(hunter.getCountOfHumans());
	}
}
