package dodatkove.less3;

import org.junit.Assert;
import org.junit.Test;

public class Logic {

	public static int add(int a, int b){
		if(a<0 || b<0) throw new IllegalArgumentException();
		return a+b;
	}
	
	@Test
	public void addTest(){
		int actual = add(1,2);
		int expected = 3;
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addTest2(){
		add(-1,-1);
	}
	
	
}
