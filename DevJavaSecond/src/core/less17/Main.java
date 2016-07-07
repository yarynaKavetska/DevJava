package core.less17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		print(list, (e)->true);
		System.out.println();
		print(list, (e)->e%2==0);
		System.out.println();
		print(list, (e)->e%3==0);
		List<String> list2 = new ArrayList<>();
		list2.addAll(Arrays.asList("Ivan", "Mykola", "Petro"));
		IntStream intStream = list2.stream().map(String::toUpperCase)
		.flatMapToInt(String::chars);
		intStream.forEach(Main::printAsChar);
		intStream = list2.stream().map(String::toUpperCase)
				.flatMapToInt(String::chars);
		long count = intStream.count();
		System.out.println(count);
		intStream = list2.stream().map(String::toUpperCase)
				.flatMapToInt(String::chars);
		long sum = intStream.reduce(3, (acc, element)->acc+element);
		System.out.println(sum);
		list2.parallelStream().sorted((o1, o2)->o2.compareTo(o1))
		.forEach(System.out::println);
	}
	
	static void printAsChar(int ch){
		System.out.println((char)ch);
	}
	
	static void print(List<Integer> list, Predicate<Integer> predicate){
		for (Integer integer : list) {
			if(predicate.test(integer))
			System.out.println(integer);
		}
	}
	
}
