package core.less2;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		p.age = 18;
		p.name = "Ivan";
		System.out.println("Name = "+ p.name + ", age = "+ p.age);
		Person z = new Person(25, "Petro");
		System.out.println("Name = "+ z.name + ", age = "+ z.age);
		p.walk(500);
		z.walk(5000);
		z.walk(1);
	}
}
