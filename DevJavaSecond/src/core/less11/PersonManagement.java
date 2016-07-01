package core.less11;

import java.util.ArrayList;
import java.util.List;

public class PersonManagement {

	private final List<Person> list = new ArrayList<>();

	public void addPerson(String name, String strAge){
		int age = Integer.valueOf(strAge);
		list.add(new Person(name, age));
	}
	
	public void changeAge(String name, String strAge){
		for (Person person : list) {
			if(person.getName().equals(name)){
				person.changeAge(strAge);
			}
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
