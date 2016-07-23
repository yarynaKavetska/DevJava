package less11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import less10.Pc;

public class Main {

	private final static List<Pc> list = new ArrayList<>();
	private final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// List<String> list = new ArrayList<>();
		// list.add("A");
		// System.out.println(list);
		// list.add(0, "B");
		// System.out.println(list);
		// String b = list.set(0, "C");
		// System.out.println(b);
		// System.out.println(list);
		// System.out.println(list.contains("A"));
		// for (int i = 0; i < list.size(); i++) {
		// String string = list.get(i);
		// System.out.println(string);
		// }
		// for (String string : list) {
		// System.out.println(string);
		// }
		// System.out.println(list.indexOf("A"));
		// LinkedList<String> linkedList = new LinkedList<>();
		list.add(new Pc(4, 500, 4));
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add PC");
			System.out.println("Enter 2 to filter by MHz");
			System.out.println("Enter 3 to filter by memory capacity");
			System.out.println("Enter 4 to filter by HDD capacity");
			System.out.println("Enter 5 to show all PCs");
			System.out.println("Enter 6 to raise mHz");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1": {
				addPc();
				break;
			}
			case "2": {
				filterByMhz();
				break;
			}
			case "3": {
				filterByMemoryCapacity();
				break;
			}
			case "4": {
				filterByHddCapacity();
				break;
			}
			case "5": {
				for (Pc pc : list) {
					System.out.println(pc);
				}
				break;
			}
			case "6": {
				raise();
				break;
			}
			default:
				isRun = false;
			}
		}
	}

	private static void filterByMemoryCapacity() {
		System.out.println("Enter memory capacity");
		int memoryGb = sc.nextInt();
		for (Pc pc : list) {
			if(pc.getMemory().getgB()==memoryGb){
				System.out.println(pc);
			}
		}
	}
	
	private static void filterByHddCapacity() {
		System.out.println("Enter min capacity");
		int minCapacity = sc.nextInt();
		System.out.println("Enter max capacity");
		int maxCapacity = sc.nextInt();
		for (Pc pc : list) {
			if(pc.getHdd().getgB()>=minCapacity
					&&pc.getHdd().getgB()<=maxCapacity){
				System.out.println(pc);
			}
		}
	}

	private static void raise() {
		System.out.println("Enter memory capacity");
		int capacity = sc.nextInt();
		for (Pc pc : list) {
			if(pc.getMemory().getgB()>capacity){
				pc.raise();
			}
		}
	}

	private static void filterByMhz() {
		System.out.println("Enter MHz");
		double mHz = sc.nextDouble();
		for (Pc pc : list) {
			if(pc.getCpu().getmHz()==mHz){
				System.out.println(pc);
			}
		}
	}

	private static void addPc() {
		System.out.println("Enter MHz");
		double mHz = sc.nextDouble();
		System.out.println("Enter memory capacity");
		int memoryGb = sc.nextInt();
		System.out.println("Enter HDD capacity");
		int hddGb = sc.nextInt();
		Pc pc = new Pc(mHz, hddGb, memoryGb);
		list.add(pc);
	}
}
