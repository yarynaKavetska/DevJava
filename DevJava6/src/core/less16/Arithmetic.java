package core.less16;

public class Arithmetic {

	public static int div(int a, int b){
		try{
			return a/b;
		}catch(ArithmeticException e){
			throw new ArithmeticException("Idiot / by 0");
		}
	}
	
	public static int add(int a, int b) throws MyException{
		if(a==0&&b==0) throw new MyException("did you know 0 + 0 = 0?");
		return a + b;
	}
}
