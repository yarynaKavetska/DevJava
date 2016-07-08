package core.less17;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonManagementTest {
	
	private static final Saver SAVER = new Saver("uyuhn.vds");
	private final PersonManagement pm = new PersonManagement();
	private static final Summary SUMMARY = new Summary();

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
	public void summaryTest(){
		List<Person> persons = pm.filterByAge(20, 40);
		File file = new File("fgsdgf.txt");
		file.deleteOnExit();
		SUMMARY.create(persons, "fgsdgf");
		List<String> expected = new ArrayList<>();
		for(Person person : persons){
			expected.add(person.getName()+" "+ person.getAge());
		}
		List<String> actual = SUMMARY.read("fgsdgf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void saverTest(){
		File file = new File("uyuhn.vds");
		file.deleteOnExit();
		SAVER.save(pm);
		PersonManagement actual = SAVER.restore();
		assertEquals(pm.getPersons(), actual.getPersons());
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
