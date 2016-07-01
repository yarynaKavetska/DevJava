package core.less14;

import java.util.Comparator;

public class PersonComparatorByAgeAsc implements Comparator<Person>{

	@Override
	public int compare(Person first, Person second) {
		return first.getAge()-second.getAge();
	}
}
