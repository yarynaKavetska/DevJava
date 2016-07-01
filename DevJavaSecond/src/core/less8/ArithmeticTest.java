package core.less8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticTest {
	
	private Arithmetic arithmetic = new Arithmetic();
	
	@Before
	public void initTestCase(){
		System.out.println("before test");
	}
	
	@After
	public void cleanTestCase(){
		System.out.println("after test");
	}

	@Test
	public void addTest(){
		int expected = 4;
		int actual = arithmetic.add(2, 2);
		assertEquals(expected, actual);
		System.out.println("test1");
	}
	
	@Test
	public void divTest(){
		int expected = 2;
		int actual = arithmetic.div(4, 2);
		assertEquals(expected, actual);
		System.out.println("test3");
	}
	
	@Test
	public void divByZeroTest(){
		int expected = 0;
		int actual = arithmetic.div(2, 0);
		assertEquals(expected, actual);
		System.out.println("test2");
	}
	
}
