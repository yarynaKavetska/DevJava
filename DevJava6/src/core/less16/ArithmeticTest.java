package core.less16;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticTest {

//	@Test(expected=ArithmeticException.class)
	@Test
	public final void test() {
		try{
			Arithmetic.div(2, 0);
			System.out.println("Never");
		}catch(ArithmeticException | NullPointerException e){
			e.printStackTrace();
			System.out.println("Catched");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("All the time");
		}
	}

	@Test
	public final void myException(){
		try {
			Arithmetic.add(2, 2);
			Arithmetic.add(0, 0);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
