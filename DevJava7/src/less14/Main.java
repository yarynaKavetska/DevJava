package less14;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// try{
		// int result = div(3,0);
		// System.out.println(result);
		// }catch(IOException | ArithmeticException e){
		// e.printStackTrace();
		// System.out.println(0);
		// }finally{
		// System.out.println("ASasas");
		// }

		boolean isRun = true;
		while (isRun) {
			switch (scanner.next()) {
			case "1": {
				try {
					enterInt();
				} catch (MyException e) {
					e.printStackTrace();
				}
				break;
			}
			case "2": {
				try {
					enterLetter();
				} catch (MyException e) {
					e.printStackTrace();
				}
				break;
			}
			default:
				isRun = false;
				break;
			}
		}
	}

	private static void enterLetter() {
		System.out.println("Enter letter");
		String s = scanner.next();
		if (s.length() > 1) {
			throw new MyException("you just need enter one letter!!!");
		}
		System.out.println("Good");
	}

	private static void enterInt() {
		System.out.println("Enter int");
		try {
			scanner.nextInt();
			System.out.println("Good");
		} catch (InputMismatchException e) {
			throw new MyException("you just need enter int!!!");
		}
	}

	static int div(int a, int b) throws IOException {
		if (b == 0)
			throw new IOException("/ by zero");
		return a / b;
	}
}
