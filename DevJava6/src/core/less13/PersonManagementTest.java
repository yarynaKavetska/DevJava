package core.less13;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonManagementTest {
	
	private final PersonManagement pm = new PersonManagement();

	@Before
	public final void setUp(){
		pm.addPerson("Ivan", 18);
		pm.addPerson("Petro", 23);
		pm.addPerson("Mykola", 35);
		pm.addPerson("Sergiy", 56);
		pm.addPerson("Ivan", 18);
	}

	@After
	public final void tearDown(){
		pm.getPersons().clear();
	}

	@Test
	public final void addTest() {
		int actual = pm.getPersons().size();
		int expected = 4;
		assertTrue(new Person("Ivan", 18).equals(new Person("Ivan", 18)));
		assertEquals(expected, actual);
	}
	
	@Test
	public final void filterByAgeTest(){
		List<Person> actual = pm.filterByAge(23, 40);
		assertEquals(2, actual.size());
		assertTrue(actual.contains(new Person("Petro", 23)));
		assertTrue(actual.contains(new Person("Mykola", 35)));
	}

}
