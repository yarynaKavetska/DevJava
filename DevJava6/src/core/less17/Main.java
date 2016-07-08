package core.less17;

import java.util.List;
import java.util.Scanner;

public class Main {

	private static final Saver SAVER = new Saver("save.tysdbvyrtekxg");
	private static final Scanner SC = new Scanner(System.in);
	private static final PersonManagement PM = SAVER.restore();
	private static final Summary SUMMARY = new Summary();
	
	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to filter by age");
			System.out.println("Enter 3 to show all");
			System.out.println("Enter 4 to read summary");
			System.out.println("Enter 0 to exit");
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
				System.out.println(PM.getPersons());
				break;
			}
			case 4: {
				read();
				break;
			}
			default :{
				isRun = false;
			}
			}
		}
	}

	private static void read() {
		System.out.println("Enter file name");
		SUMMARY.read(SC.next()).forEach(System.out::println);
	}

	private static void filterByAge() {
		System.out.println("Enter min age");
		int min = SC.nextInt();
		System.out.println("Enter max age");
		int max = SC.nextInt();
		List<Person> persons = PM.filterByAge(min, max);
		System.out.println("Enter file name");
		SUMMARY.create(persons, SC.next());
	}

	private static void addPerson() {
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		int age = SC.nextInt();
		PM.addPerson(name, age);
		SAVER.save(PM);
	}
}