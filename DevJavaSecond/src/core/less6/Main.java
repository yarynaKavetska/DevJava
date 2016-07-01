package core.less6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("A");
		strings.add("B");
		System.out.println(strings);
		strings.add(1, "C");
		System.out.println(strings);
		System.out.println(strings.contains("A"));
		System.out.println(strings.indexOf("A"));
		System.out.println(strings.containsAll(Arrays.asList("C", "A", "B")));
		strings.forEach((e)->System.out.print(e));
		System.out.println();
		for (String e : strings){
			System.out.print(e);
		}
		System.out.println();
		for (int i = 0; i < strings.size(); i++) {
			String e = strings.get(i);
			System.out.print(e);
		}
		System.out.println();
		strings.remove("C");
		System.out.println(strings);
		strings.add(strings.set(1, "C"));
		System.out.println(strings);
		strings.removeIf((e)->e.equals("B"));
		System.out.println(strings);
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		System.out.println(list);
		System.out.println(list.getLast());
		list.removeLast();
		System.out.println(list);
		
		Iterator<String> iter = strings.iterator();
		System.out.println(strings);
		while(iter.hasNext()){
			String e = iter.next();
			if(e.equals("C")&&e.length()>=1){
				iter.remove();
			}
		}
		System.out.println(strings);
		ListIterator<String> listIter = strings.listIterator(strings.size());
		while(listIter.hasPrevious()){
			System.out.println(listIter.previous());
		}
		
		while(true){
			System.out.println("Enter 1 to something");
			System.out.println("Enter 2 to something");
			System.out.println("Enter 3 to something");
			System.out.println("Enter 4 to something");
			System.out.println("Enter 5 to something");
			Scanner sc = new Scanner(System.in);
			int choise = sc.nextInt();
			switch (choise) {
			case 1:{
				System.out.println("Enter diametr");
				int diametr = sc.nextInt();
				//call method
				break;
			}
			case 5:{
				System.exit(0);
				break;
			}
			default:
				break;
			}
		}
	}

}
