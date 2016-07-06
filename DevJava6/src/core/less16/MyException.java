package core.less16;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2777558981480995088L;

	public MyException(String message) {
		super("Stuped idiot "+message);
	}

	@Override
	public void printStackTrace() {
		System.err.println(getMessage());
	}
}
