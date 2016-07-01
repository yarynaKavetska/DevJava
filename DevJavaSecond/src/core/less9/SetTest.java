package core.less9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

	private Set<Person> set = new TreeSet<>(new PersonComparator());
	
	@Before
	public void init(){
		set.add(new Person("Ivan", 15));
		set.add(new Person("Vitaliy", 20));
		set.add(new Person("Petro", 18));
		set.add(new Person("Ivan", 50));
	}
	
	@After
	public void clear(){
		set.clear();
	}
	
	@Test
	public void sizeTest(){
		int actual = set.size();
		System.out.println(set);
		assertEquals(4, actual);
	}
	
	@Test
	public void eqTest(){
		Person p1 = new Person("Ivan", 18);
		Person p2 = new Person("Ivan", 18);
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void compareTest(){
		Comparator<Person> comparator = new PersonComparator();
		Person p1 = new Person("Ivan", 18);
		Person p2 = new Person("Petro", 18);
		assertEquals(7, comparator.compare(p1, p2));
		Comparable<Person> comparable = (Comparable<Person>) p1;
		assertEquals(-7, comparable.compareTo(p2));
	}
	
	@Test
	public void sort(){
		List<String> list = new ArrayList<>(Arrays
				.asList("D", "R", "Q", "A", "U"));
		System.out.println(list);
		list.sort(null);
		System.out.println(list);
		list.sort((o1, o2)->o2.compareTo(o1));
		System.out.println(list);
	}
}
