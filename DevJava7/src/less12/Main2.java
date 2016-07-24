package less12;

import java.util.Set;
import java.util.TreeSet;

public class Main2 {

	public static void main(String[] args) {
		Set<Person> persons = new TreeSet<>();
		persons.add(new Person(18, "Ivan"));
		persons.add(new Person(29, "Mykola"));
		persons.add(new Person(16, "Pavlo"));
		persons.add(new Person(12, "Petryk"));
		persons.add(new Person(12, "Petryk"));
		persons.add(new Person(25, "Petryk"));
		persons.forEach(System.out::println);
		
		
	}

}
