package core.less11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import core.less8.Person;
import core.less8.Sex;
import static org.junit.Assert.*;

public class ArithmeticTest {
	
	private final Arithmetic arithmetic = new Arithmetic();

	@Test
	public void add(){
		int actual = arithmetic.add(2, 2);
		int expected = 4;
		assertEquals(expected, actual);
	}
	
	@Test
	public void div(){
		int actual = arithmetic.div(2, 2);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void div2(){
		int actual = arithmetic.div(2, 0);
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void div3(){
		int actual = arithmetic.div(0, 3);
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void rename(){
		String expected = "Ivan";
		Person p = new Person(17, "Usbdbv", Sex.MALE);
		arithmetic.rename(expected, p);
		String actual = p.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void rename2(){
		arithmetic.rename(null, null);
	}
	
	@Test
	public void remove(){
		Person p1 = new Person(17, "Ivan", Sex.MALE);
		Person p2 = new Person(17, "Petro", Sex.MALE);
		Person p3 = new Person(17, "Mykola", Sex.MALE);
		Person p4 = new Person(17, "Ivan", Sex.MALE);
		List<Person> actual = new ArrayList<>
		(Arrays.asList(p1, p2, p3, p4));
		List<Person> expected = new ArrayList<>
		(Arrays.asList(p3, p2));
		arithmetic.remove("Ivan", actual);
		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertEquals(2, actual.size());
	}
	
	@Test
	public void remove2(){
		arithmetic.remove(null, null);
	}
}
