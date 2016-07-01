package core.less11;

public class Arithmetic {

	public static int div(int a, int b) throws ArithmeticException{
		if(b==0) throw new ArithmeticException("Idiot, / by zero is not correct");
		return a/b;
	}
	
	public static int div2(int a, int b) throws ReflectiveOperationException {
		if(b==0) throw new ReflectiveOperationException("Idiot, / by zero is not correct");
		return a/b;
	}
}
