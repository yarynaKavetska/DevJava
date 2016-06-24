package core.less11;

import java.util.List;

import core.less8.Person;

public class Arithmetic {

	public int add(int a, int b){
		return a+b;
	}
	
	public int div(int a, int b){
		if(b==0)return b;
		return a/b;
	}
	
	public void rename(String name, Person person){
		if(person!=null)person.setName(name);
	}
	
	public void remove(String name, List<Person> persons){
		if(persons!=null){
			persons.removeIf((p)->p.getName().equals(name));
		}
	}
}
