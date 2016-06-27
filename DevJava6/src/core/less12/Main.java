package core.less12;

import java.util.Scanner;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final Logic LOGIC = new Logic();

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to filter by age");
			System.out.println("Enter 3 to filter by sex");
			System.out.println("Enter 4 to exit");
			switch (SC.nextInt()) {
			case 1: {
				addPerson();
				break;
			}
			case 2: {
				filterByAge();
				break;
			}
			case 3: {
				filterBySex();
				break;
			}
			default :{
				isRun = false;
			}
			}
			System.out.println(LOGIC.getPersons());
		}
	}

	private static void filterBySex() {
		System.out.println("Enter sex");
		LOGIC.filterBySex(SC.next());
	}

	private static void filterByAge() {
		System.out.println("Enter min age");
		int min = SC.nextInt();
		System.out.println("Enter max age");
		int max = SC.nextInt();
		LOGIC.filterByAge(min, max);
	}

	private static void addPerson() {
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		int age = SC.nextInt();
		System.out.println("Enter sex");
		String sex = SC.next();
		LOGIC.addPerson(name, age, sex);
	}
}
