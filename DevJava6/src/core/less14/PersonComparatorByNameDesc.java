package core.less14;

import java.util.Comparator;

public class PersonComparatorByNameDesc implements Comparator<Person>{

	@Override
	public int compare(Person first, Person second) {
		return second.getName().compareTo(first.getName());
	}

}
