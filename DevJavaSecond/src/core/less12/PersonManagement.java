package core.less12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonManagement extends ArrayList<Person>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6483713078713135803L;

	public boolean add(Person person){
		if(!contains(person)) return super.add(person);
		return false;
	}
	
	public void addPerson(String name, String age){
		int ageInt = Integer.valueOf(age);
		add(new Person(name, ageInt));
	}
	
	public List<String> forSummary(){
//		List<String> list = new ArrayList<>();
//		for (Person person : this) {
//			list.add(person.toString());
//		}
//		return list;
		return stream().map(Person::toString).collect(Collectors.toList());
	}
}
