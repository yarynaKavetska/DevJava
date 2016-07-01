package core.less11;

import java.util.Scanner;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final PersonManagement PM = new PersonManagement();

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to change age");
			System.out.println("Enter 3 to exit");
			switch (SC.next()) {
			case "1": {
				addPerson();
				break;
			}
			case "2": {
				changeAge();
				break;
			}
			default: {
				isRun = false;
				break;
			}
			}
			System.out.println(PM);
		}
	}

	private static void changeAge() {
		try{
			System.out.println("Enter name");
			String name = SC.next();
			System.out.println("Enter age");
			String age = SC.next();
			PM.changeAge(name, age);
		}catch(NumberFormatException e){
			System.err.println("Idiot enter correct age");
		}catch (IllegalArgumentException e) {
			System.err.println("Idiot enter correct age betwean 0 and 120");
		}
	}

	private static void addPerson() {
		try{
			System.out.println("Enter name");
			String name = SC.next();
			System.out.println("Enter age");
			String age = SC.next();
			PM.addPerson(name, age);
		}catch(NumberFormatException e){
			System.err.println("Idiot enter correct age");
		}catch (IllegalArgumentException e) {
			System.err.println("Idiot enter correct age betwean 0 and 120");
		}
	}
	
	

}
