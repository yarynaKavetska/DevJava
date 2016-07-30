package less14;

public class MyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1170095488434419808L;

	public MyException(String message) {
		super("Stupid idiot "+message);
	}

	@Override
	public void printStackTrace() {
		System.err.println(getMessage());
	}
}
