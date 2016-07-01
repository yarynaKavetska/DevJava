package core.less14;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonManagementTest {
	
	private static final PersonManagement PM = new PersonManagement();

	@Before
	public void setUp() {
		PM.addPerson("Ivan", 18);
		PM.addPerson("Petro", 25);
		PM.addPerson("Mykola", 15);
		PM.addPerson("Sergiy", 37);
		PM.addPerson("Petro", 29);
	}

	@After
	public void tearDown() {
		PM.getPersons().clear();
	}

	@Test
	public final void sortByNameAsc(){
		List<Person> expected = new ArrayList<>();
		expected.add(new Person("Ivan", 18));
		expected.add(new Person("Mykola", 15));
		expected.add(new Person("Petro", 25));
		expected.add(new Person("Petro", 29));
		expected.add(new Person("Sergiy", 37));
		PM.sortByNameAsc();
		List<Person> actual = PM.getPersons();
		assertEquals(expected, actual);
	}
	
	@Test
	public final void sortByNameDesc(){
		PM.sortByNameDesc();
		List<Person> actual = PM.getPersons();
		Person first = actual.get(0);
		for (int i = 1; i < actual.size(); i++) {
			assertTrue(descName(first, actual.get(i)));
			first = actual.get(i);
		}
	}
	
	private final boolean descName(Person first, Person second){
		return first.getName().compareTo(second.getName()) >= 0;
	}

}
