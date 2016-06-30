package core.less13;

import java.util.Scanner;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final PersonManagement PM = new PersonManagement();

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to filter by age");
			System.out.println("Enter 3 to exit");
			switch (SC.nextInt()) {
			case 1: {
				addPerson();
				break;
			}
			case 2: {
				filterByAge();
				break;
			}
			default :{
				isRun = false;
			}
			}
		}
	}

	private static void filterByAge() {
		System.out.println("Enter min age");
		int min = SC.nextInt();
		System.out.println("Enter max age");
		int max = SC.nextInt();
		System.out.println(PM.filterByAge(min, max));
	}

	private static void addPerson() {
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		int age = SC.nextInt();
		PM.addPerson(name, age);
		System.out.println(PM.getPersons());
	}
}