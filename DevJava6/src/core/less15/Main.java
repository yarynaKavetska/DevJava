package core.less15;

import java.util.Scanner;

public class Main {

	/**
	 * Прочитати Exception
	 */

	private final static Koop KOOP = new Koop();
	private final static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to add car");
			System.out.println("Enter 3 to filter");
			System.out.println("Enter 4 to show all");
			System.out.println("Enter 0 to exit");
			switch (SC.next()) {
			case "1": {
				addPerson();
				break;
			}
			case "2": {
				addCar();
				break;
			}
			case "3": {
				filter();
				break;
			}
			case "4": {
				KOOP.print();
				break;
			}
			default: {
				isRun = false;
			}
			}
		}
	}
	
	private static void filter() {
		System.out.println("Enter brand");
		String brand = SC.next();
		KOOP.findByBrand(brand).forEach(System.out::println);
	}

	private static void addCar() {
		Person person = getPerson();
		System.out.println("Enter brand");
		String brand = SC.next();
		System.out.println("Enter model");
		String model = SC.next();
		KOOP.addCar(person, brand, model);
	}

	private static void addPerson() {
		KOOP.addPerson(getPerson());
	}
	private static Person getPerson(){
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		int age = SC.nextInt();
		return new Person(name, age);
	}
}