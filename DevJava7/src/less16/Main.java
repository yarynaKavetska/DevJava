package less16;

import java.util.Comparator;

import less16.Person.Pet;


public class Main {

	public static void main(String[] args) {
		Person person = new Person.Builder()
			.age(18)
			.name("Ivan")
			.addPet("Barsik")
			.addPet("Murzik")
			.build();
		Person person2 = new Person.Builder()
			.age(18)
			.name("Mykola")
			.build();
		
		person.getPets().sort(new Comparator<Person.Pet>(){
			@Override
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
}
