package core.less12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import core.less8.Sex;

public class Logic {

	private final List<Person> persons = new ArrayList<>();

	public void addPerson(String name, int age, String sex) {
		persons.add(new Person(name, age, Sex.valueOf(sex.toUpperCase())));
	}

	public void filterByAge(int min, int max) {
		persons.removeIf((p) -> p.getAge() < min || p.getAge() > max);
	}
	
	public void filterBySex(String sex){
		persons.removeIf((p) -> p.getSex()!=Sex.valueOf(sex.toUpperCase()));
	}
	
//	public void removeIf(Predicate<Person> predicate){
//		Iterator<Person> iter = persons.iterator();
//		while(iter.hasNext()){
//			Person p = iter.next();
//			if(predicate.test(p)){
//				iter.remove();
//			}
//		}
//	}

	public List<Person> getPersons() {
		return persons;
	}
}
