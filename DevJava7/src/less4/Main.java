package less4;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		person.name = "Ivan";
		person.age = 18;
		person.print();
		Person person2 = new Person("Petro", 23);
		person2.print();
	}
}
