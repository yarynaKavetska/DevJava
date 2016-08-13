package less20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import less16.Person;


public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(array).forEach((i)->System.out.println(i));
		System.out.println();
		Arrays.stream(array).filter(i->i%2==0).forEach(System.out::println);
		System.out.println();
		Arrays.stream(array).filter(i->i%3==0).forEach(System.out::println);
		List<Person> list = new ArrayList<>();
		list.add(new Person.Builder().age(18).addPet("Brovko")
				.addPet("Sirko").name("Ivan").build());
		list.add(new Person.Builder().age(15).addPet("Tuzik")
				.addPet("Sharik").name("Petro").build());
		list.add(new Person.Builder().age(21).addPet("Komposter")
				.addPet("Bobik").name("Mykola").build());
		
		List<String> names = list.stream().map(Person::getName)
				.collect(Collectors.toList());
		System.out.println(names);
		
		List<String> petNames = list.stream().map(p->p.getPets())
				.flatMap(List::stream)
				.sorted(Comparator.comparing(Person.Pet::getName).reversed())
				.map(Person.Pet::getName)
				.collect(Collectors.toList());
		System.out.println(petNames);
		
		int count = list.stream().map(p->p.getPets())
				.flatMap(List::stream)
				.map(Person.Pet::getName)
				.flatMapToInt(String::chars)
				.reduce(0, Integer::sum);
		
		long lenght = list.stream().map(p->p.getPets())
				.flatMap(List::stream)
				.map(Person.Pet::getName)
				.flatMapToInt(String::chars)
				.count();
		System.out.println((char)(count/lenght));
	}
}