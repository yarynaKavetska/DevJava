package core.less11;

import org.junit.Test;

public class ArithmeticTest {

	@Test(expected=ArithmeticException.class)
	public void divTest(){
		try {
			System.out.println("Asssssssssss");
			Arithmetic.div2(2, 0);
		} catch (ReflectiveOperationException e1) {
			e1.printStackTrace();
		}
		try{
			Arithmetic.div(2, 0);
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
		Arithmetic.div(2, 0);
	}
}
