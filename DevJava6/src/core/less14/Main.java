package core.less14;

import java.util.Scanner;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final PersonManagement PM = new PersonManagement();

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to sort by name asc");
			System.out.println("Enter 4 to sort by name desc");
			System.out.println("Enter 0 to exit");
			switch (SC.nextInt()) {
			case 1: {
				addPerson();
				break;
			}
			case 2: {
				PM.getPersons().forEach(System.out::println);
				break;
			}
			case 3: {
				PM.sortByNameAsc();
				break;
			}
			case 4: {
				PM.sortByNameDesc();
				break;
			}
			default :{
				isRun = false;
			}
			}
		}
	}

	private static void addPerson() {
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		int age = SC.nextInt();
		PM.addPerson(name, age);
	}
}