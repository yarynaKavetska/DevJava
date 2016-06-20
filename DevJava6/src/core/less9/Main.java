package core.less9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String... args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		System.out.println(list);
		list.add(0, "C");
		System.out.println(list);
		String removed = list.set(0, "D");
		System.out.println("removed = "+ removed);
		System.out.println(list);
		list.addAll(Arrays.asList("T", "E"));
		System.out.println(list);
		System.out.println(list.contains("T"));
		System.out.println(list.containsAll(Arrays.asList("T", "E")));
		System.out.println("lambda foreach");
		list.forEach((string)->System.out.println(string));
		System.out.println("foreach");
		List<String> list2 = new ArrayList<>();
		for (String string : list) {
			if(!string.equals("R")){
				list2.add(string);
			}
			System.out.println(string);
		}
		System.out.println("for i");
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
			System.out.println(string);
		}
		System.out.println(list);
		list.removeIf((string)->string.equals("B"));
		System.out.println(list);
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addFirst("A");
		linkedList.addFirst("B");
		linkedList.addFirst("C");
		System.out.println(linkedList);
		System.out.println("1");
		System.out.println(linkedList.poll());
		System.out.println(linkedList);
		System.out.println("2");
		System.out.println(linkedList.poll());
		System.out.println(linkedList);
		System.out.println("3");
		System.out.println(linkedList.poll());
		System.out.println(linkedList);
		System.out.println("4");
		System.out.println(linkedList.poll());
		System.out.println(linkedList);
		
	}
}
