package less8;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Person person = new Person(18, "Ivan", Gender.MALE);
		Month[] months = Month.values();
		for(int i = 0; i < months.length; i++){
			System.out.println(months[i]);
		}
		System.out.println();
		Month june = Month.valueOf("JUNE");
		System.out.println(june);
		Month december = Month.valueOf("DECEMBER");
		System.out.println(december.compareTo(june));
		Locale locale = Locale.ENGLISH;
	}
}