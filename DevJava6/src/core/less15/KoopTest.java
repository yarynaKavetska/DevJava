package core.less15;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KoopTest {
	
	private static final Koop KOOP = new Koop();

	@Before
	public void setUp(){
		KOOP.addPerson(new Person("Ivan", 18));
		KOOP.addCar(new Person("Ivan", 18), "Seat", "Ibiza");
		KOOP.addCar(new Person("Ivan", 18), "Saab", "9000");
		KOOP.addPerson(new Person("Mykola", 35));
		KOOP.addCar(new Person("Mykola", 35), "BMW", "B6");
		KOOP.addCar(new Person("Mykola", 35), "Mercedes", "slk");
		KOOP.addCar(new Person("Mykola", 35), "Audi", "R8");
		KOOP.addPerson(new Person("Petro", 12));
	}

	@After
	public void tearDown(){
		KOOP.getMap().clear();
	}

	@Test
	public final void getPersonByCarBrand() {
		assertEquals(3, KOOP.getMap().keySet().size());
		assertEquals(3, KOOP.getMap().values().size());
		Collection<List<Car>> carCol = KOOP.getMap().values();
		List<Car> cars = new ArrayList<>();
		for (List<Car> list : carCol) {
			cars.addAll(list);
		}
		assertEquals(5, cars.size());
		List<Person> persons = KOOP.findByBrand("Audi");
		assertEquals(1, persons.size());
		assertTrue(persons.contains(new Person("Mykola", 35)));
		KOOP.print();
	}

}
