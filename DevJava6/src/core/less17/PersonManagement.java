package core.less17;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonManagement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853366440837013377L;
	
	private final Set<Person> persons = new HashSet<>();

	public void addPerson(String name, int age){
		persons.add(new Person(name, age));
	}
	
	public List<Person> filterByAge(int min, int max){
//		List<Person> finded = new ArrayList<>();
//		Iterator<Person> iter = persons.iterator();
//		while(iter.hasNext()){
//			Person person = iter.next();
//			if(person.getAge()>=min&&person.getAge()<=max){
//				finded.add(person);
//			}
//		}
		
//		for (Person person : persons) {
//			if(person.getAge()>=min&&person.getAge()<=max){
//				finded.add(person);
//			}
//		}
		return persons.stream()
				.filter((person)->person.getAge()>=min)
				.filter((person)->person.getAge()<=max)
				.collect(Collectors.toList());
	}
	
	public Set<Person> getPersons() {
		return persons;
	}
}
