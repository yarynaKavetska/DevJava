package core.less14;

import java.util.ArrayList;
import java.util.List;

public class PersonManagement {

	private final List<Person> persons = new ArrayList<>();

	public void addPerson(String name, int age){
		persons.add(new Person(name, age));
	}
	
	public void sortByNameAsc(){
		persons.sort(null);
	}
	
	public void sortByNameDesc(){
		persons.sort(new PersonComparatorByNameDesc());
	}
	
	public void sortByAgeAsc(){
		persons.sort((first, second)->first.getAge()-second.getAge());
	}
	
	public void sortByAgeDesc(){
		persons.sort((first, second)->second.getAge()-first.getAge());
	}
	
	public List<Person> getPersons() {
		return persons;
	}
}
