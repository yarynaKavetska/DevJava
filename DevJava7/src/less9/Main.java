package less9;

import java.util.Scanner;

public class Main {

	private final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to find students from IT");
			System.out.println("Enter 2 to find students from Economics");
			switch (sc.next()) {
			case "1": {
				Student[] students = Student.values();
				for (int i = 0; i < students.length; i++) {
					if(students[i].getKafedra().equals(Kafedra.IT)){
						System.out.println(students[i]);
					}
				}
				break;
			}
			case "2": {
				Student[] students = Student.values();
				for (int i = 0; i < students.length; i++) {
					if(students[i].getKafedra().equals(Kafedra.ECONOMIC)){
						System.out.println(students[i]);
					}
				}
				break;
			}
			default: {
				isRun = false;
			}
			}
		}
	}

}
