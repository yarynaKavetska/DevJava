package core.less12;

import org.junit.*;
import static org.junit.Assert.*;

public class LogicTest {

	private final Logic logic = new Logic();
	
	@Before
	public void init(){
		System.out.println("Before");
		logic.addPerson("Ivan", 18, "male");
		logic.addPerson("Petro", 21, "male");
		logic.addPerson("Mykola", 15, "male");
		logic.addPerson("Ivanka", 6, "female");
		logic.addPerson("Oksana", 30, "female");
	}
	
	@After
	public void clear(){
		System.out.println("After");
		logic.getPersons().clear();
	}
	
	@Test
	public void filterByAge(){
		System.out.println("Test 1");
		logic.filterByAge(18, 25);
		assertEquals(2, logic.getPersons().size());
	}
	
	@Test
	public void filterBySex(){
		System.out.println("Test 2");
		logic.filterBySex("male");
		assertEquals(3, logic.getPersons().size());
	}
}
