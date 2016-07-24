package less12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(18, "Ivan"));
		persons.add(new Person(29, "Mykola"));
		persons.add(new Person(16, "Pavlo"));
		persons.add(new Person(12, "Petryk"));
		persons.forEach((Person person)->System.out.println(person));
		Iterator<Person> iter = persons.iterator();
		while(iter.hasNext()){
			if(iter.next().getAge()<18){
				iter.remove();
			}
		}
		System.out.println();
		persons.forEach((person)->System.out.println(person));
		iter = persons.iterator();
		
		while(iter.hasNext()){
			if(iter.next().getName().startsWith("I")){
				iter.remove();
			}
		}
		System.out.println();
		persons.forEach(System.out::println);
		persons.add(new Person(16, "Pavlo"));
		persons.add(new Person(12, "Petryk"));
		persons.add(new Person(18, "Ivan"));
		System.out.println();
		persons.forEach(System.out::println);
		iter = persons.iterator();
		while(iter.hasNext()){
			Person person = iter.next();
			if(person.getAge()<18||person.getName().startsWith("I")){
				iter.remove();
			}
		}
		System.out.println();
		persons.forEach(System.out::println);
//		ListIterator<Person> listIter = persons.listIterator();
		persons.add(new Person(16, "Pavlo"));
		persons.add(new Person(12, "Petryk"));
		persons.add(new Person(18, "Ivan"));
		System.out.println();
		persons.forEach(System.out::println);
		persons.sort(null);
//		Comparable<Person> comparable = 
//				(Comparable<Person>) persons.get(0);
		
		System.out.println();
		persons.forEach(System.out::println);
		persons.sort(new PersonComparatorByNameDesc());
		System.out.println();
		persons.forEach(System.out::println);
	}

}
